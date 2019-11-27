package com.datangedu.cn.Service.CustomerCar;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.AllorderMapper;
import com.datangedu.cn.dao.mapper.CartMapper;
import com.datangedu.cn.dao.mapper.CustomersMapper;
import com.datangedu.cn.dao.mapper.ServiceproductMapper;
import com.datangedu.cn.dao.mapper.ServiceproviderMapper;
import com.datangedu.cn.model.cart.Cart;
import com.datangedu.cn.model.cart.CartExample;
import com.datangedu.cn.model.customers.CustomersExample;
import com.datangedu.cn.model.order.Allorder;
import com.datangedu.cn.model.order.AllorderExample;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;
import com.datangedu.cn.model.serviceproduct.ServiceproductExample;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;

@Service
public class CustomerCarServletIMPL implements CustomerCarServlet {
	@Resource
	CartMapper cartMapper;
	@Resource
	ServiceproductMapper serviceproduct;
	@Resource
	ServiceproviderMapper serviceprovider;
	@Resource
	CustomersMapper customers;
	@Resource
	AllorderMapper allorderMapper;

	public List<Cart> findListByCuId(HttpServletRequest request)// cart list
	{
		CartExample cartExample = new CartExample();
		CartExample.Criteria Criteria = cartExample.createCriteria();
		Criteria.andCartCustomeridEqualTo(request.getParameter("id"));
		cartExample.setOrderByClause("CART_PROVIDERID");
		return cartMapper.selectByExample(cartExample);
	}

	public List<Cart> findPclineByPcId(String productid)// cart list
	{
		CartExample cartExample = new CartExample();
		CartExample.Criteria Criteria = cartExample.createCriteria();
		Criteria.andCartProductidEqualTo(productid);
		cartExample.setOrderByClause("CART_PROVIDERID");
		return cartMapper.selectByExample(cartExample);
	}

	public List<String> findPcIdListByPvId(String providerid)// cart list
	{
		Set<String> set = new HashSet<String>();
		List<String> list = new ArrayList<String>();
		CartExample cartExample = new CartExample();
		CartExample.Criteria Criteria = cartExample.createCriteria();
		Criteria.andCartProvideridEqualTo(providerid);
		cartExample.setOrderByClause("CART_PROVIDERID");
		Iterator<Cart> itc = cartMapper.selectByExample(cartExample).iterator();
		while (itc.hasNext()) {
			set.add(itc.next().getCartProductid());
		}
		list.addAll(set);
		return list;
	}

	public List<String> getPvIdDistinct(List<Cart> listCart)// provider id list
	{
		Set<String> set = new HashSet<String>();
		List<String> list = new ArrayList<String>();
		Iterator<Cart> itc = listCart.iterator();
		while (itc.hasNext()) {
			set.add(itc.next().getCartProviderid());
		}
		list.addAll(set);
		return list;
	}

	public List<String> getPvNameDistinct(List<String> idlist)// provider name list
	{
		Set<String> set = new HashSet<String>();
		List<String> list = new ArrayList<String>();
		Iterator<String> its = idlist.iterator();
		for (int i = 0; i < idlist.size(); i++) {
			ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
			ServiceproviderExample.Criteria criteria = serviceproviderExample.createCriteria();
			criteria.andServProviderIdEqualTo(idlist.get(i));
			list.add(serviceprovider.selectByExample(serviceproviderExample).get(0).getServProviderName());
		}
		return list;
	}

	public String getPvNameDistinct(String providerid)// provider name list
	{
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria criteria = serviceproviderExample.createCriteria();
		criteria.andServProviderIdEqualTo(providerid);
		return serviceprovider.selectByExample(serviceproviderExample).get(0).getServProviderName();
	}

	public List<String> getPcNameDistinct(List<String> idlist)// provider name list
	{
		Set<String> set = new HashSet<String>();
		List<String> list = new ArrayList<String>();
		Iterator<String> its = idlist.iterator();
		while (its.hasNext()) {
			ServiceproductExample serviceproductExample = new ServiceproductExample();
			ServiceproductExample.Criteria criteria = serviceproductExample.createCriteria();
			criteria.andServProductidEqualTo(its.next());
			set.add(serviceproduct.selectByExample(serviceproductExample).get(0).getServProductname());
		}
		list.addAll(set);
		return list;
	}

	public String getPcNameDistinct(String productid)// provider name list
	{
		List<String> list = new ArrayList<String>();
		ServiceproductExample serviceproductExample = new ServiceproductExample();
		ServiceproductExample.Criteria criteria = serviceproductExample.createCriteria();
		criteria.andServProductidEqualTo(productid);
		return serviceproduct.selectByExample(serviceproductExample).get(0).getServProductname();
	}

	public int updateCustomerCartNum(HttpServletRequest request) {
		System.out.println(Integer.parseInt(request.getParameter("num")));
		Cart cart = new Cart();
		cart.setCartNumber(Integer.parseInt(request.getParameter("num")));
		CartExample cartExample = new CartExample();
		CartExample.Criteria Criteria = cartExample.createCriteria();
		Criteria.andCartCustomeridEqualTo(request.getParameter("cuid"));
		Criteria.andCartProductidEqualTo(request.getParameter("pcid"));
		return cartMapper.updateByExampleSelective(cart, cartExample);

	}

	@Override
	public int deleteCartline(HttpServletRequest request) {
		CartExample cartExample = new CartExample();
		CartExample.Criteria Criteria = cartExample.createCriteria();
		Criteria.andCartCustomeridEqualTo(request.getParameter("cuid"));
		Criteria.andCartProductidEqualTo(request.getParameter("pcid"));
		return cartMapper.deleteByExample(cartExample);
	}

	public int insertOrderFromCart(Cart cart, String str, Date datetime) {
		Allorder allor = new  Allorder();
		allor.setOrdeCustomerid(cart.getCartCustomerid());
		allor.setOrdeCustomername(getCuNameDistinct(cart.getCartCustomerid()));
		allor.setOrdeEvaluation("");
		allor.setOrdeEvaluationstatus(0);
		allor.setOrdeId(str);
		allor.setOrdeNum(cart.getCartNumber());
		allor.setOrdePayway(0);
		allor.setOrdePrice(cart.getCartPrice());
		allor.setOrdeProduct(getPcNameDistinct(cart.getCartProductid()));
		allor.setOrdeProvidername(getPvNameDistinct(cart.getCartProviderid()));
		allor.setOrdeStarttime(datetime);
		allor.setOrdeState(0);
		AllorderExample allorderExample = new AllorderExample();
		AllorderExample.Criteria criteria = allorderExample.createCriteria();
		return allorderMapper.insert(allor);
		
		
	}

	public String getCuNameDistinct(String customerid)// provider name list
	{
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria criteria = customersExample.createCriteria();
		criteria.andCustIdEqualTo(customerid);
		return customers.selectByExample(customersExample).get(0).getCustName();
	}
	public int deCartByCuid(HttpServletRequest request)
	{
		CartExample cartExample = new CartExample();
		CartExample.Criteria Criteria = cartExample.createCriteria();
		Criteria.andCartCustomeridEqualTo(request.getParameter("id"));
		return cartMapper.deleteByExample(cartExample);
	}
	public Serviceproduct findlinebypramarykey(String str) {
		return serviceproduct.selectByPrimaryKey(str);
	}

}

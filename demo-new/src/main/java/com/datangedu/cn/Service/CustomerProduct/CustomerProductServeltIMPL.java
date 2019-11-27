package com.datangedu.cn.Service.CustomerProduct;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.customers.CustomersExample;
import com.datangedu.cn.model.order.Allorder;
import com.datangedu.cn.model.order.AllorderExample;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;
import com.datangedu.cn.model.serviceproduct.ServiceproductExample;
import com.datangedu.cn.model.serviceprovider.Serviceprovider;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;

@Service
public class CustomerProductServeltIMPL implements CustomerProductServelt {

	@Resource
	ServiceproductMapper serviceproductMapper;
	@Resource
	ServiceproviderMapper serviceproviderMapper;
	@Resource
	CartMapper cartMapper;
	@Resource
	AllorderMapper allorderMapper;
	@Resource
	CustomersMapper customersMapper;

	public List<Serviceproduct> findProduct(HttpServletRequest request) {
		ServiceproductExample serviceproductExample = new ServiceproductExample();
		ServiceproductExample.Criteria criteria = serviceproductExample.createCriteria();
		serviceproductExample.setOrderByClause("SERV_RECOMMENDED DESC");
		return serviceproductMapper.selectByExample(serviceproductExample);
	}

	public List<Serviceproduct> numberDesc(HttpServletRequest request) {
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria criteria1= serviceproviderExample.createCriteria();
		criteria1.andServProviderStateEqualTo(1);
		List<Serviceprovider> list =serviceproviderMapper.selectByExample(serviceproviderExample);
		List<String> lists =new ArrayList<String>();
		for(int i = 0;i < list.size();i++)
		{
			lists.add(list.get(i).getServProviderName());
		}
		ServiceproductExample serviceproductExample = new ServiceproductExample();
		ServiceproductExample.Criteria criteria2 = serviceproductExample.createCriteria();
		criteria2.andServProvidernameIn(lists);
		serviceproductExample.setOrderByClause("SERV_BUMBER desc");
		return serviceproductMapper.selectByExample(serviceproductExample);

	}

	public List<Serviceproduct> priceDesc(HttpServletRequest request) {
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria criteria1= serviceproviderExample.createCriteria();
		criteria1.andServProviderStateEqualTo(1);
		List<Serviceprovider> list =serviceproviderMapper.selectByExample(serviceproviderExample);
		List<String> lists =new ArrayList<String>();
		for(int i = 0;i < list.size();i++)
		{
			lists.add(list.get(i).getServProviderName());
		}
		ServiceproductExample serviceproductExample = new ServiceproductExample();
		ServiceproductExample.Criteria criteria2 = serviceproductExample.createCriteria();
		criteria2.andServProvidernameIn(lists);
		serviceproductExample.setOrderByClause("SERV_PRICE desc");
		return serviceproductMapper.selectByExample(serviceproductExample);

		
	}

	public List<Serviceproduct> priceEsc(HttpServletRequest request) {
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria criteria1= serviceproviderExample.createCriteria();
		criteria1.andServProviderStateEqualTo(1);
		List<Serviceprovider> list =serviceproviderMapper.selectByExample(serviceproviderExample);
		List<String> lists =new ArrayList<String>();
		for(int i = 0;i < list.size();i++)
		{
			lists.add(list.get(i).getServProviderName());
		}
		ServiceproductExample serviceproductExample = new ServiceproductExample();
		ServiceproductExample.Criteria criteria2 = serviceproductExample.createCriteria();
		criteria2.andServProvidernameIn(lists);
		serviceproductExample.setOrderByClause("SERV_PRICE");
		return serviceproductMapper.selectByExample(serviceproductExample);
		
	}

	public List<Cart> findCartline(HttpServletRequest request) {
		CartExample cartExample = new CartExample();
		CartExample.Criteria criteria = cartExample.createCriteria();
		criteria.andCartProductidEqualTo(request.getParameter("pcid"));
		criteria.andCartProvideridEqualTo(request.getParameter("pvid"));
		criteria.andCartCustomeridEqualTo(request.getParameter("cuid"));
		return cartMapper.selectByExample(cartExample);
		
	}

	@Override
	public int addCart(HttpServletRequest request) {
		Cart cart = new Cart();
		cart.setCartProductid(request.getParameter("pcid"));
		cart.setCartProviderid(request.getParameter("pvid"));
		cart.setCartCustomerid(request.getParameter("cuid"));
		cart.setCartPrice(Integer.parseInt(request.getParameter("pcpri")));
		cart.setCartNumber(1);
		cart.setCartAprice(Integer.parseInt(request.getParameter("pcpri")));
		CartExample cartExample = new CartExample();
		CartExample.Criteria criteria = cartExample.createCriteria();
		return cartMapper.insert(cart);
	}

	@Override
	public int updateNum(HttpServletRequest request) {
		Cart cart = new Cart();
		cart.setCartNumber(findCartline(request).get(0).getCartNumber() + 1);
		cart.setCartAprice(
				(findCartline(request).get(0).getCartNumber() + 1) * Integer.parseInt(request.getParameter("pcpri")));
		CartExample cartExample = new CartExample();
		CartExample.Criteria criteria = cartExample.createCriteria();
		criteria.andCartCustomeridEqualTo(request.getParameter("cuid"));
		criteria.andCartProductidEqualTo(request.getParameter("pcid"));
		criteria.andCartProvideridEqualTo(request.getParameter("pvid"));
		return cartMapper.updateByExampleSelective(cart, cartExample);

	}

	public int insertOrderFromProc(HttpServletRequest request, String str, Date datetime) {
		Allorder allor = new Allorder();
		allor.setOrdeCustomerid(request.getParameter("cuid"));
		allor.setOrdeCustomername(findcuname(request.getParameter("cuid")));
		allor.setOrdeEvaluation("");
		allor.setOrdeEvaluationstatus(0);
		allor.setOrdeId(str);
		allor.setOrdeNum(1);
		allor.setOrdePayway(0);
		allor.setOrdePrice(Integer.parseInt(request.getParameter("pcpri")));
		allor.setOrdeProduct(findpcname(request.getParameter("pcid")));
		allor.setOrdeProvidername(findpvname(request.getParameter("pvid")));
		allor.setOrdeStarttime(datetime);
		allor.setOrdeState(0);
		AllorderExample allorderExample = new AllorderExample();
		AllorderExample.Criteria criteria = allorderExample.createCriteria();
		return allorderMapper.insert(allor);
	}

	public String findcuname(String cuid) {
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria criteria = customersExample.createCriteria();
		criteria.andCustIdEqualTo(cuid);
		return customersMapper.selectByExample(customersExample).get(0).getCustName();
	}

	public String findpvname(String pvid) {
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria criteria = serviceproviderExample.createCriteria();
		criteria.andServProviderIdEqualTo(pvid);
		return serviceproviderMapper.selectByExample(serviceproviderExample).get(0).getServProviderName();
		

	}

	public String findpcname(String pcid) {
		ServiceproductExample serviceproductExample = new ServiceproductExample();
		ServiceproductExample.Criteria criteria = serviceproductExample.createCriteria();
		criteria.andServProductidEqualTo(pcid);
		return serviceproductMapper.selectByExample(serviceproductExample).get(0).getServProductname();
	}

	public Serviceproduct findlinebypramarykey(String str) {
		return serviceproductMapper.selectByPrimaryKey(str);
	}

	@Override
	public List<Serviceproduct> findlike(String brabch, String str) {
		List<Serviceproduct> list = new ArrayList<Serviceproduct>();
		if (brabch.equals("1")==true) {
			list = serviceproductMapper.selectBypcname(str);
			if (list.size() != 0) {
				return list;
			} else {
				return null;
			}
		} else {
			list = serviceproductMapper.selectBypvname(str);
			if (list.size() != 0) {
				return list;
			} else {
				return null;
			}
		}
	}
	
	

}

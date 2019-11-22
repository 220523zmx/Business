package com.datangedu.cn.Service.CustomerPay;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.validator.constraints.Currency;
import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.AllorderMapper;
import com.datangedu.cn.dao.mapper.CustomersMapper;
import com.datangedu.cn.dao.mapper.ServiceproductMapper;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.order.Allorder;
import com.datangedu.cn.model.order.AllorderExample;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;
import com.datangedu.cn.model.serviceproduct.ServiceproductExample;

@Service
public class CustomerPayServletIMPL implements CustomerPayServlet {

	@Resource
	AllorderMapper allorderMapper;
	@Resource
	ServiceproductMapper serviceproductMapper;
	@Resource
	CustomersMapper CustomersMapper;
	public List<Allorder> findorder(HttpServletRequest request)
	{
		AllorderExample allorderExample = new AllorderExample();
		AllorderExample.Criteria criteria= allorderExample.createCriteria();
		criteria.andOrdeCustomeridEqualTo(request.getParameter("cusid"));
		criteria.andOrdeIdEqualTo(request.getParameter("orid"));
		return allorderMapper.selectByExample(allorderExample);
		
	}
	public String findproductid(String pcname){
		ServiceproductExample serviceproductExample = new ServiceproductExample();
		ServiceproductExample.Criteria  criteria =  serviceproductExample.createCriteria();
		criteria.andServProductnameEqualTo(pcname);
		return 	serviceproductMapper.selectByExample(serviceproductExample).get(0).getServProductid();

	}
	public int updatepayway(HttpServletRequest request)
	{
		Allorder allorder = new Allorder();
		allorder.setOrdePayway(Integer.parseInt(request.getParameter("payway")));
		AllorderExample allorderExample = new AllorderExample();
		AllorderExample.Criteria criteria= allorderExample.createCriteria();
		criteria.andOrdeIdEqualTo(request.getParameter("orid"));
		return allorderMapper.updateByExampleSelective(allorder, allorderExample);
	}
	public int updatestate(HttpServletRequest request) {
		Allorder allorder = new Allorder();
		allorder.setOrdeState(1);
		AllorderExample allorderExample = new AllorderExample();
		AllorderExample.Criteria criteria= allorderExample.createCriteria();
		criteria.andOrdeIdEqualTo(request.getParameter("orid"));
		return allorderMapper.updateByExampleSelective(allorder, allorderExample);
	}
	public int updatenum(HttpServletRequest request) {
		List<Allorder> list = findorder(request);
		Serviceproduct serviceproduct  = new Serviceproduct();
		int j = 0;
		for(int i = 0;i<list.size();i++)
		{ 
			int x =list.get(i).getOrdeNum();//订单商品的数量
			System.out.println("x:"+x);
			Serviceproduct pc= serviceproductMapper.selectByPrimaryKey(findproductid(list.get(i).getOrdeProduct()));
			int y = pc.getServBumber();//该商品的总数量
			System.out.println("y:"+y);
			serviceproduct.setServBumber(x+y);
			System.out.println("x+y:"+(x+y));
			ServiceproductExample serviceproductExample = new ServiceproductExample();
			ServiceproductExample.Criteria  criteria =  serviceproductExample.createCriteria();
			criteria.andServProductidEqualTo(pc.getServProductid());
			j+=serviceproductMapper.updateByExampleSelective(serviceproduct, serviceproductExample);
			
		}
		return j;
	}
	public int updatecusnum(HttpServletRequest request)
	{
		List<Allorder> list = findorder(request);
		Customers customers = new Customers();
		System.out.println(request.getParameter("cusid"));
		Customers cust = CustomersMapper.selectByPrimaryKey(request.getParameter("cusid"));
		int ordernum = 0,orderprice = 0,customernum = cust.getCustNumber(),customerprice = cust.getCustPrice();
		for(int i = 0;i<list.size();i++)
		{ 
			ordernum 	=list.get(i).getOrdeNum();//订单商品的数量
			orderprice 	=list.get(i).getOrdePrice();//订单商品单价
			customerprice 	+= (ordernum*orderprice);//累加消费金额 
		}
		cust.setCustId(request.getParameter("cusid"));
		cust.setCustNumber(customernum+1);
		cust.setCustPrice(customerprice);
		return CustomersMapper.updateByPrimaryKeySelective(cust);
	}
}

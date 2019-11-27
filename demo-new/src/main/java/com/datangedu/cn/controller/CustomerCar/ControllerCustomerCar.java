package com.datangedu.cn.controller.CustomerCar;


import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.datangedu.cn.Random.ServletRandomIMPL;
import com.datangedu.cn.Service.CustomerCar.CustomerCarServlet;
import com.datangedu.cn.model.cart.Cart;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;

@Controller
@RequestMapping("/customer")
public class ControllerCustomerCar {
	@Resource
	CustomerCarServlet customerCar;

	@ResponseBody
	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public Map<String, Object> customercar(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Cart> cartlist = customerCar.findListByCuId(request);// 购物车集合
		List<String> pvid = customerCar.getPvIdDistinct(cartlist);// 根据购物车遍历集合去回独自的id集合
		List<String> pvname = customerCar.getPvNameDistinct(pvid);// 根据服务商id集合取回服务商姓名
		map.put("pvnamelist", pvname);// 一个顾客：多个服务商
		for (int i = 0; i < pvid.size(); i++) {
			List<String> pcid = customerCar.findPcIdListByPvId(pvid.get(i));//
			List<String> pcname = customerCar.getPcNameDistinct(pcid);// 单条服务商对应的商品名集合
			map.put(customerCar.getPvNameDistinct(pvid.get(i)), pcname);// 1个服务商：多个商品
			for (int j = 0; j < pcid.size(); j++) {
				String str = customerCar.getPcNameDistinct(pcid.get(j));
				List<Cart> list = customerCar.findPclineByPcId(pcid.get(j));
				map.put(str, list);
			}
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/cart_sub", method = RequestMethod.POST)
	public Map<String,Object> customercarSub(HttpServletRequest request)
	{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("state",customerCar.updateCustomerCartNum(request));
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/cart_add", method = RequestMethod.POST)
	public Map<String,Object> customercarAdd(HttpServletRequest request)
	{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("state",customerCar.updateCustomerCartNum(request));
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/cart_change", method = RequestMethod.POST)
	public Map<String,Object> customercarChange(HttpServletRequest request)
	{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("state",customerCar.updateCustomerCartNum(request));
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/cart_delete", method = RequestMethod.POST)
	public Map<String,Object> customercarDelete(HttpServletRequest request)
	{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("state",customerCar.deleteCartline(request));
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/carttoorder", method = RequestMethod.POST)//提交清单
	public Map<String,Object> carttoorder(HttpServletRequest request)
	{
		Map<String,Object> map = new HashMap<String, Object>();
		ServletRandomIMPL  servletRandom   = new ServletRandomIMPL ();
		String str = servletRandom.getRandomNo(11);
		Date datetime = new Date();
		List<Cart> cartlist = customerCar.findListByCuId(request);// 购物车集合
		if(cartlist.size()!=0) {
		for(int i = 0;i<cartlist.size();i++)
		{
			customerCar.insertOrderFromCart(cartlist.get(i), str, datetime);
		}
		customerCar.deCartByCuid(request);
		map.put("state", 1);
		map.put("orderid",str);
		map.put("ordertime",datetime);}
		else {
			map.put("state", 2);
			map.put("waring", "可以先选择所需商品再付款");
		}
		return map;
		
	}
	@RequestMapping(value = "/cartproimgshow", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg(HttpServletRequest request) throws Exception {

		byte[] imageContent;
		// 根据id获取当前用户的信息

		Serviceproduct pc = customerCar.findlinebypramarykey(request.getParameter("id"));
		imageContent = pc.getServProductimg();
		System.out.println("图片===" + pc.getServProductimg());

		// 设置http头部信息
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		// 返回响应实体
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}
}

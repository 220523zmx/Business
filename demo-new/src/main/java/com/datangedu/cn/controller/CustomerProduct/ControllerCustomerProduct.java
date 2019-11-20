package com.datangedu.cn.controller.CustomerProduct;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.datangedu.cn.Service.CustomerProduct.CustomerProductServelt;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;

@Controller
@RequestMapping("/customer")
public class ControllerCustomerProduct {
	@Resource
	CustomerProductServelt customerProduct;
	@Resource
	
	@ResponseBody
	@RequestMapping(value = "/product", method = RequestMethod.POST)

	public Map<String, Object> Product(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productlist", customerProduct.findProduct(request));
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/numberDesc", method = RequestMethod.POST)

	public Map<String, Object> numberDesc(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productlist", customerProduct.numberDesc(request));
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/priceDesc", method = RequestMethod.POST)

	public Map<String, Object> priceDesc(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productlist", customerProduct.priceDesc(request));
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/priceEsc", method = RequestMethod.POST)

	public Map<String, Object> priceEsc(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productlist", customerProduct.priceEsc(request));
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/add_cart", method = RequestMethod.POST)
	public Map<String, Object> addCart(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (customerProduct.findCartline(request).size() == 0) {
			if (customerProduct.addCart(request) == 1) {
				map.put("state", "已加入购物车");
			} else {
				map.put("state", "请稍后");
			}
		} else {
			if (customerProduct.updateNum(request) == 1) {
				map.put("state", "已加入购物车");
			} else {
				map.put("state", "请稍后");
			}
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/just_buy", method = RequestMethod.POST)
	public Map<String, Object> justbuy(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		ServletRandomIMPL  servletRandom   = new ServletRandomIMPL ();
		String str = servletRandom.getRandomNo(11);
		Date datetime = new Date();
		int a = customerProduct.insertOrderFromProc(request, str, datetime);
		if(a!=0)
		{
			map.put("status", "已提交订单");
			map.put("str",str);
		}
		else
		{
			map.put("status", "提交订单失败");
		}

		return map;

	}
	@RequestMapping(value = "/proimgshow", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg(HttpServletRequest request) throws Exception {

		byte[] imageContent;
		// 根据id获取当前用户的信息

		Serviceproduct pc = customerProduct.findlinebypramarykey(request.getParameter("id"));
		imageContent = pc.getServProductimg();
		System.out.println("图片===" + pc.getServProductimg());

		// 设置http头部信息
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		// 返回响应实体
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}
	@ResponseBody
	@RequestMapping(value = "/pro_like", method = RequestMethod.POST)
	public Map<String,Object> findlikename(HttpServletRequest request)
	{
		Map<String ,Object> map = new HashMap<String ,Object>();
		
		List<Serviceproduct> list = new ArrayList<Serviceproduct>();
		list = customerProduct.findlike(request.getParameter("branch"), request.getParameter("likename"));
		if(list!=null)
		{
			map.put("productlist", list);
		}else {
			map.put("state", "未搜索到结果，请刷新");
			map.put("status", 1);
		}
		return map;
	}

}

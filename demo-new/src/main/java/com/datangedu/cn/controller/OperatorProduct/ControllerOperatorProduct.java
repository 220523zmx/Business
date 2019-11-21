package com.datangedu.cn.controller.OperatorProduct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.Service.OperatorProduct.OperatorProductServlet;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;

@Controller
@RequestMapping(value = "/operator")
public class ControllerOperatorProduct {
	@Resource
	OperatorProductServlet operatorProductServlet;
	@ResponseBody
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public Map<String,Object> findproductlist(HttpServletRequest request)
	{
		Map<String,Object> map = new HashMap<String, Object>();
		System.out.println("??"+request.getParameter("likename")+""+request.getParameter("orderby"));
		String str = request.getParameter("likename");
		int i = Integer.parseInt(request.getParameter("orderby"));
		String order = "DESC";
		if(i == 1){
			order = "DESC";
		}else {
			order = "ASC";
		}
		List<Serviceproduct> list = operatorProductServlet.findbylikename(str,order);
		if(list.size() == 0)
		{
			map.put("code", 0);
			map.put("state", "搜索结果为空请刷新");
		}else {
			map.put("productlist", list);
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/statedown", method = RequestMethod.POST)
	public Map<String,Object> statedown(HttpServletRequest request)
	{
		Map<String,Object> map = new HashMap<String, Object>();
		int i = operatorProductServlet.statedown(request.getParameter("pcid"));
		if(i == 0)
		{
			map.put("code", 0);
			map.put("state", "下线失败");
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/stateup", method = RequestMethod.POST)
	public Map<String,Object> stateup(HttpServletRequest request)
	{
		Map<String,Object> map = new HashMap<String, Object>();
		int i =  operatorProductServlet.stateup(request.getParameter("pcid"));
		if(i == 0)
		{
			map.put("code", 0);
			map.put("state", "上线失败");
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/productdelect", method = RequestMethod.POST)
	public Map<String,Object> productdelect(HttpServletRequest request)
	{
		Map<String,Object> map = new HashMap<String, Object>();
		int i =  operatorProductServlet.productdelect(request.getParameter("pcid"));
		if(i == 0)
		{
			map.put("code", 0);
			map.put("state", "删除失败");
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/loststateup", method = RequestMethod.POST)
	public Map<String,Object> loststateup(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();
		String str = request.getParameter("str");
	     String[] arr = str.split(","); 
	     for(String tmp : arr) { 
	    	 int i =  operatorProductServlet.stateup(tmp);
	 		if(i == 0)
	 		{
	 			map.put("code", 0);
	 			map.put("state", "上线失败");
	 		}
	    	 }
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/loststatedown", method = RequestMethod.POST)
	public Map<String,Object> loststatedown(HttpServletRequest request)
	{
		Map<String,Object> map = new HashMap<String, Object>();
		String str = request.getParameter("str");
		String[] arr = str.split(","); 
	     for(String tmp : arr) { 
	    	 int i = operatorProductServlet.statedown(tmp);
	 		if(i == 0)
	 		{
	 			map.put("code", 0);
	 			map.put("state", "下线失败");
	 		}
	    	 }
		return map;
	}
}

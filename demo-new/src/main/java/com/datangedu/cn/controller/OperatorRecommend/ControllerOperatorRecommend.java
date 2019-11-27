package com.datangedu.cn.controller.OperatorRecommend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.Service.OperatorRecommend.OperatorRecommendServlet;
import com.datangedu.cn.model.order.Allorder;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;

@Controller
@RequestMapping(value = "/operator")
public class ControllerOperatorRecommend {
	@Resource
	OperatorRecommendServlet operatorRecommendServlet;
	@ResponseBody
	@RequestMapping(value = "/countorder", method = RequestMethod.GET)
	public Map<String, Object> countorder(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		long i = operatorRecommendServlet.countorder(request.getParameter("likename"));
		System.out.println("size" + i);
		if (i == 0) {
			map.put("trailerpage", 0);
			map.put("state", "搜索结果空");
		} else {

			map.put("trailerpage", i);
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/topage", method = RequestMethod.GET)
	public Map<String, Object> topage(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Serviceproduct> list = operatorRecommendServlet.topage(request);
		if(list.size()!=0||list !=null)
		{
		map.put("productlist", list);
		}else {
			map.put("code", 1);
			map.put("status","为搜索到结果");
		}
		
		return map;
	}

}

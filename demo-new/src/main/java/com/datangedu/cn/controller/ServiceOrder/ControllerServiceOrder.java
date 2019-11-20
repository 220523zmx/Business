package com.datangedu.cn.controller.ServiceOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.Service.ServiceOrder.ServiceOrderServlet;
import com.datangedu.cn.model.order.Allorder;

@Controller
@RequestMapping(value = "/service")
public class ControllerServiceOrder {
	@Resource
	ServiceOrderServlet serviceOrderServlet;

	@ResponseBody
	@RequestMapping(value = "/countorder", method = RequestMethod.GET)
	public Map<String, Object> countorder(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(request.getParameter("serid")+"121"+request.getParameter("finish"));
		long i = serviceOrderServlet.countorder(request.getParameter("serid"),request.getParameter("likename"),Integer.parseInt(request.getParameter("finish")));
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
		List<Allorder> list = serviceOrderServlet.topage(request);
		if(list.size()!=0)
		{
		map.put("orderlist", list);
		for(int i = 0;i<list.size();i++)
		{
			String phone = serviceOrderServlet.findcustomerphone(list.get(i).getOrdeCustomername());
			map.put(list.get(i).getOrdeCustomername(), phone);
			map.put("code", 1);
			map.put("state", "成功");
		}
		}else {
			map.put("code", 0);
			map.put("state", "未搜索到结果");
		}
		
		return map;
	}

	

}

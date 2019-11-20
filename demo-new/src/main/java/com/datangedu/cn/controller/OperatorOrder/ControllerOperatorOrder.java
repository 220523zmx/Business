package com.datangedu.cn.controller.OperatorOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.Service.OperatorOrder.OperatorOrderServlet;
import com.datangedu.cn.dao.mapper.AllorderMapper;
import com.datangedu.cn.model.order.Allorder;


@Controller
public class ControllerOperatorOrder {

	@Resource
	AllorderMapper allorderMapper;
	@Resource
	OperatorOrderServlet OperatorOrderServlet;
	 
	 //查询功能
		//返回数据Json类型
		@ResponseBody
		//请求地址，请求类型
		@RequestMapping(value = "/getOrderInfo",method = RequestMethod.GET)
		public Map<String,Object> getOrderInfo(HttpServletRequest request) {
			
			System.out.println("查看携带ID=="+request.getParameter("id"));
			
			String orderId = request.getParameter("id");
			Map<String,Object>map = new HashMap<String,Object>();
			List<Allorder> orderInfo = OperatorOrderServlet.getOrderInfoByld(orderId);

			map.put("orderInfo", orderInfo);
			return map;
		}
		
		
		
		//按钮删除功能
		//返回数据Json类型
		@ResponseBody
		//请求地址，请求类型
		@RequestMapping(value = "/orderdelete",method = RequestMethod.POST)
		public Map<String,Object> orderDelete(HttpServletRequest request) {

			Map<String,Object>map = new HashMap<String,Object>();
			int orderInfo = OperatorOrderServlet.setOrderDelete(request);
          //判断返回结果 给前台返回信息
			map.put("msg", "恭喜删除成功");
			map.put("code", 1);
			return map;
		}
	
}

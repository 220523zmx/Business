package com.datangedu.cn.controller.OperatorUser;

import java.util.ArrayList;
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
import com.datangedu.cn.Service.OperatorUser.AdministratorService;
import com.datangedu.cn.model.administrator.Administrator;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;
import com.datangedu.cn.model.serviceprovider.Serviceprovider;
import com.datangedu.cn.model.serviceprovider.ServiceproviderWithBLOBs;

@Controller
@RequestMapping(value = "/operator")
public class ControllerOperatorUser {

	 
	 @Resource
	 AdministratorService AdministratorService;
		@ResponseBody
		@RequestMapping(value = "/countusers", method = RequestMethod.GET)
		public Map<String, Object> countorder(HttpServletRequest request) {
			Map<String, Object> map = new HashMap<String, Object>();
			long i = AdministratorService.countorder(request.getParameter("likename"),request.getParameter("from"));
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
		@RequestMapping(value = "/usertopage", method = RequestMethod.GET)
		public Map<String, Object> topage(HttpServletRequest request) {
			Map<String, Object> map = new HashMap<String, Object>();
			if(request.getParameter("from").equals("a")==true)
			{
				List<Customers> lista = AdministratorService.topagea(request);
				if(lista.size()!=0||lista !=null)
				{
				map.put("productlist", lista);
				map.put("from", 1);
				}else {
					map.put("code", 1);
					map.put("status","未搜索到结果");
					
				}
			}else {
				List<ServiceproviderWithBLOBs> listb = AdministratorService.topageb(request);
				if(listb.size()!=0||listb !=null)
				{
				map.put("productlist", listb);
				map.put("from", 2);
				}else {
					map.put("code", 1);
					map.put("status","未搜索到结果");
					
				}
			}
			return map;
		}
		
		
		
		//按钮删除功能
		//返回数据Json类型
		@ResponseBody
		//请求地址，请求类型
		@RequestMapping(value = "/userdelect",method = RequestMethod.GET)
		public Map<String,Object> userDelete(HttpServletRequest request) {
			int i = 0;
			Map<String,Object>map = new HashMap<String,Object>();
			if(request.getParameter("from").equals("a")==true)
			{
				i = AdministratorService.setUserDeletea(request);
			}
			else{
				i = AdministratorService.setUserDeleteb(request);
			}
			if(i != 0)
			{
				map.put("msg", "恭喜删除成功");
				map.put("code", 1);
			}else {
				map.put("msg", "删除失败");
				map.put("code", 0);
			}
			
          //判断返回结果 给前台返回信息
			return map;
		}
	
}

package com.datangedu.cn.controller.CusstomerEva;

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

import com.datangedu.cn.Service.CustomerEva.CustomerEvaServlet;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.order.Allorder;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;

@Controller
@RequestMapping("/customer")
public class ControllerCustomerEva {
	@Resource
	CustomerEvaServlet customerEvaServlet;
	@ResponseBody
	@RequestMapping(value= "/hasevaluate",method = RequestMethod.POST)
	public Map<String,Object> findhaseva(HttpServletRequest request)
	{
		Map<String,Object> map = new HashMap<String,Object> ();
		List<Allorder> list = customerEvaServlet.findhaseva(request);
		System.out.println(list);
		if(list.size() != 0) {
			for(int i = 0;i<list.size();i++)
			{
				String str = customerEvaServlet.findserinstruction(list.get(i));
				map.put(list.get(i).getOrdeProduct(), str);
			}
			map.put("list", list);
		}
		else{
			map.put("state","您还没有评价过哦");
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value= "notevaluate",method = RequestMethod.POST)
	public Map<String,Object> findnoteva(HttpServletRequest request)
	{
		Map<String,Object> map = new HashMap<String,Object> ();
		List<Allorder> list = customerEvaServlet.findnoteva(request);
		System.out.println(list);
		if(list.size() != 0) {
			for(int i = 0;i<list.size();i++)
			{
				String str =customerEvaServlet.findserinstruction(list.get(i));
				map.put(list.get(i).getOrdeProduct(), str);
			}
			map.put("list", list);
		
		}
		else{
			map.put("state","您都评价完了哦");
		}
		
		return map;
	}
	@RequestMapping(value = "/evaimgshow", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg(HttpServletRequest request) throws Exception {

		byte[] imageContent;
		// 根据id获取当前用户的信息
				
		String str = customerEvaServlet.findpcidbypcname(request.getParameter("pcname"));
		Serviceproduct pc = customerEvaServlet.findlinebypramarykey(str);
		imageContent = pc.getServProductimg();
		System.out.println("图片===" + pc.getServProductimg());

		// 设置http头部信息
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		// 返回响应实体
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}
	
	
	
	  @ResponseBody
	  
	  @RequestMapping(value= "saveevaluate",method = RequestMethod.POST) 
	  public Map<String,Object> updateevaluate(HttpServletRequest request) {
	  Map<String,Object> map = new HashMap<String, Object>();
	  int a = customerEvaServlet.updateevaluate(request);
	  if(a == 1)
	  {
		  map.put("state", "评价成功");
	  }
	  else {
		  map.put("state", "评价失败");
	  }
	  
	  return map;
	  
	  }
	 

}

package com.datangedu.cn.controller.OperatorFac;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.Service.OperatorFa.getListSelect;

@Controller
public class OperatorFacCon {
@Resource
getListSelect g;
	@ResponseBody
	@RequestMapping(value= "/operator",method = RequestMethod.GET)
	public Map<String,Object> getOperatorRequest(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object> ();
		g.MOHuFSelect(request);
		g.MOHuFSelectS(request).size();
		System.out.println("dkl"+g.MOHuFSelect(request).size());
		map.put("code",g.MOHuFSelect(request));
		map.put("codes",g.MOHuFSelectS(request).size());
		
		System.out.println("wjfawojfafdsaf"+g.MOHuFSelectS(request).size());
		return map;
	}
	@ResponseBody
	@RequestMapping(value= "/updatedown",method = RequestMethod.GET)
	public Map<String,Object> updatedown(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object> ();
		int i = g.updatedown(request);
		if(i == 1) {
			map.put("code", 1);
			map.put("state", "停用成功");
		}else {
			map.put("code", 0);
			map.put("state", "停用失败，请刷新");
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value= "/updateup",method = RequestMethod.GET)
	public Map<String,Object> updateup(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object> ();
		int i = g.updateup(request);
		if(i == 1) {
			map.put("code", 1);
			map.put("state", "启用成功");
		}else {
			map.put("code", 0);
			map.put("state", "启用失败，请刷新");
		}
		return map;
	}
	
	
	
	
	
	
}

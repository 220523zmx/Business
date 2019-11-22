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
		System.out.println("dkl"+g.MOHuFSelectS(request));
		map.put("code",g.MOHuFSelect(request));
		map.put("codes",g.MOHuFSelectS(request).size());
		
		
		return map;
		
		
		
	}
	
	
	
	
	
	
}

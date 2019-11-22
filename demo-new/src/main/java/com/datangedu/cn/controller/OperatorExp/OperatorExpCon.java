package com.datangedu.cn.controller.OperatorExp;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.Service.OperatorEx.OperatorExp;
@Controller
public class OperatorExpCon {
@Resource
OperatorExp operatorExp;
	
		@ResponseBody
		@RequestMapping(value= "/expenses",method = RequestMethod.GET)
		public Map<String,Object> getOperatorRequest(HttpServletRequest request){
			Map<String,Object> map = new HashMap<String,Object> ();
//			operatorExp.getExpSelDate(request);
			//operatorExp.getExpSelnum(request).size();
			map.put("code",operatorExp.getExpSelDate(request));
			
		map.put("codea",operatorExp.getExpSelnum(request).size());
        System.out.println("一共有"+operatorExp.getExpSelnum(request).size());	
			return map;
			
			
	
	
		}	
}

package com.datangedu.cn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class toPageController {
	 @RequestMapping(value = "/toPage",method = RequestMethod.GET)
	   public String toPage(HttpServletRequest request){
	       String url = request.getParameter("url");
	       return url;
	   }
}

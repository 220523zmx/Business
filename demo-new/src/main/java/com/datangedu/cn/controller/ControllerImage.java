package com.datangedu.cn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.datangedu.cn.image.Image;

@Controller
public class ControllerImage {

	@GetMapping(value = "/code")
	public String getCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("image/jpeg");
		// 禁止图像缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		HttpSession session = request.getSession();
		Image image = new Image(120, 40, 5, 30);
		System.out.println(image.getCode());
		session.setAttribute("code", image.getCode());
		image.write(response.getOutputStream());

		return null;
	}

}

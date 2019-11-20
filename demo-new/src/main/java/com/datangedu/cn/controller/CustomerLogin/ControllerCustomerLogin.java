package com.datangedu.cn.controller.CustomerLogin;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.MD5.MD5;
import com.datangedu.cn.Service.CustomerLogin.CustomerLoginServlet;
import com.datangedu.cn.Service.CustomerRegister.CustomerRegisterServlet;

@Controller
@RequestMapping("/customer")
public class ControllerCustomerLogin {
	@Resource
	CustomerLoginServlet customerLogin;
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> login(HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MD5 md5 = new MD5();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		session.getAttribute("vimg");
		String vimg = (String) session.getAttribute("code");
		String code = request.getParameter("code");
		System.out.println("输入验证码" + code);
		System.out.println("图片验证码" + vimg);
		System.out.println("验证码是否：" + code.equals(vimg));
		if (request.getParameter("phone").length() == 0) {
			map.put("state", "请输入11位的移动端电话号码~");
		} // 未填写电话
		else if (request.getParameter("password").length() == 0) {
			map.put("state", "请输入6-20位不包含中文字符的密码~");
		} // 未填写密码
		else if (request.getParameter("code").length() == 0) {
			map.put("state", "请输入验证码");
		} // 未输入验证码
		else {
			if (code.equals(vimg) == true) {
				if (request.getParameter("password").length() < 6) {
					map.put("state", "密码长度小于6位，请输入6-20位不包含中文字符的密码~");
				} // 密码小于6位
				else if (request.getParameter("password").length() > 20) {
					map.put("state", "密码长度大于20位，请输入6-20位不包含中文字符的密码~");
				} // 密码大于20位
				else if (request.getParameter("phone").length() != 11) {
					map.put("state", "请输入11位的移动端电话号码~");
				} // 电话非11位
				else if (customerLogin.findphone(request).equals("phonefalse")) {
					map.put("state", "该电话号未注册~");
				} // 电话号未注册
				else// 信息正确非空
				{
					if (customerLogin.findphone(request).equals(request.getParameter("phone")) == false) {
						map.put("state", "账号或密码不正确~");// 电话号不匹配
					} else if (customerLogin.findpassword(request)
							.equals(md5.EncoderByMd5(request.getParameter("password"))) == false) {
						map.put("state", "账号或密码不正确~");// 密码不匹配
					} else {
						if (customerLogin.upstatus(request) == true) {
							map.put("state", "登录成功");
							map.put("status",1);
							map.put("phone", customerLogin.findphone(request));
							map.put("id", customerLogin.findid(request));
						} else {
							map.put("state", "服务忙，请过一段时间在登录");
						}
					}

				}
			} else {
				map.put("state", "验证码错误");// 验证码错误
			}
		
		
		}
		return map;
	}
}
	

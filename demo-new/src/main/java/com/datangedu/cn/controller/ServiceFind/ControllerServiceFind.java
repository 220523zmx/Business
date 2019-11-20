package com.datangedu.cn.controller.ServiceFind;

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
import com.datangedu.cn.Service.ServiceFind.ServiceFindServlet;


@Controller
@RequestMapping("/service")
public class ControllerServiceFind {
	@Resource
	ServiceFindServlet serviceFind;
	@ResponseBody
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public Map<String, Object> find(HttpServletRequest request)
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
		else if (request.getParameter("newpassword").length() == 0
				|| request.getParameter("againpassword").length() == 0) {
			map.put("state", "请输入6-20位不包含中文字符的密码~");
		} // 未填写密码并再次确认
		else if (request.getParameter("code").length() == 0) {
			map.put("state", "请输入验证码");
		} // 未输入验证码
		else {
			if (code.equals(vimg) == true) {
				if (request.getParameter("newpassword").length() < 6) {
					map.put("state", "密码长度小于6位，请输入6-20位不包含中文字符的密码~");
				} // 密码小于6位
				else if (request.getParameter("newpassword").length() > 20) {
					map.put("state", "密码长度大于20位，请输入6-20位不包含中文字符的密码~");
				} // 密码大于20位
				else if (request.getParameter("phone").length() != 11) {
					map.put("state", "请输入11位的移动端电话号码~");
				} // 电话非11位
				else// 信息正确非空
				{
					if (serviceFind.findphone(request) == true) {
						if (md5.EncoderByMd5(request.getParameter("newpassword"))
								.equals(md5.EncoderByMd5(request.getParameter("againpassword")))) {
							int state = serviceFind.serviceFind(request);
							if(state ==1){
								map.put("state", "更改密码成功");
							}
							else
							{
								map.put("state", "更改密码失败~");
							}
						} else {
							map.put("state", "两次输入的密码不同~");// 两次输入的密码不同
						}
					} else {
						map.put("state", "该电话号已注册~");// 改该用户不存在
					}
				}
			} else {
				map.put("state", "验证码错误");// 验证码错误
			}

		}
	return map;
	}

}

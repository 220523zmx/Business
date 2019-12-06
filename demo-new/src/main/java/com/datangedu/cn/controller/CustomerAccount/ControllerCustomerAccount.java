package com.datangedu.cn.controller.CustomerAccount;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
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
import org.springframework.web.multipart.MultipartFile;

import com.datangedu.cn.MD5.MD5;
import com.datangedu.cn.Service.CustomerAccount.CustomerAccountServlet;
import com.datangedu.cn.model.customers.Customers;

@Controller
@RequestMapping("/customer")
public class ControllerCustomerAccount {
	@Resource
	CustomerAccountServlet customerAccount;

	@ResponseBody
	@RequestMapping(value = "/password", method = RequestMethod.POST)
	public Map<String, Object> Password(HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MD5 md5 = new MD5();
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(request.getParameter("oldpassword"));
		System.out.println(request.getParameter("newpassword"));
		System.out.println(request.getParameter("againpassword"));
		System.out.println(request.getParameter("phone"));
		if (request.getParameter("newpassword").length() == 0 || request.getParameter("againpassword").length() == 0) {
			map.put("state", "请输入6-20位不包含中文字符的密码~");
		} // 未填写密码并再次确认
		else if (request.getParameter("newpassword").length() < 6) {
			map.put("state", "密码长度小于6位，请输入6-20位不包含中文字符的密码~");
		} // 密码小于6位
		else if (request.getParameter("newpassword").length() > 20) {
			map.put("state", "密码长度大于20位，请输入6-20位不包含中文字符的密码~");
		} // 密码大于20位
		else {
			if (md5.EncoderByMd5(request.getParameter("oldpassword")).equals(customerAccount.findpassword(request))) {// 旧密码匹配
				if (md5.EncoderByMd5(request.getParameter("newpassword"))
						.equals(md5.EncoderByMd5(request.getParameter("againpassword")))) {
					int state = customerAccount.Password(request);
					if (state == 1) {
						map.put("state", "修改密码成功");
					} else {
						map.put("state", "修改密码失败");
					}

				} else {
					map.put("state", "两次输入的新密码不匹配");
				}
			} else {
				map.put("state", "旧密码不正确");
			}
		}

		return map;

	}

	@ResponseBody
	@RequestMapping(value = "/information", method = RequestMethod.POST)
	public Map<String, Object> information(HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MD5 md5 = new MD5();
		Map<String, Object> map = new HashMap<String, Object>();

		int state = customerAccount.Information(request);
		if (state == 1) {
			map.put("state", "修改信息成功");
		} else {
			map.put("state", "修改信息失败");
		}

		return map;

	}

	

	@RequestMapping(value = "/imgshow", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg(HttpServletRequest request) throws Exception {

		byte[] imageContent;
		// 根据id获取当前用户的信息
				
		Customers user = customerAccount.getUserInfo(request.getParameter("id"));

		imageContent = user.getCustPortrait();
		System.out.println("图片===" + user.getCustPortrait());

		// 设置http头部信息
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		// 返回响应实体
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}

}

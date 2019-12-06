package com.datangedu.cn.controller.CustomerAccount;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.datangedu.cn.Service.CustomerAccount.CustomerAccountServlet;
import com.datangedu.cn.model.customers.Customers;
@Controller

public class ControllerCustomerAccountIMG {
	@Resource
	CustomerAccountServlet customerAccount;
	@RequestMapping("/saveUserImg")
	public String saveUserImg(MultipartFile file, String id) {
		System.out.println(id);
		System.out.println(file);

		Map<Object, Object> result = new HashMap<Object, Object>();
		try {
			// 获取客户端传图图片的输入流
			InputStream ins = file.getInputStream();byte[] buffer = new byte[1024];// bit---byte---1k---1m
			int len = 0;// 字节输出流
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			while ((len = ins.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
			bos.flush();
			byte data[] = bos.toByteArray();
			// 调用接口对图片进行存储
			Customers customers = new Customers();
			customers.setCustPhone(id);
			customers.setCustPortrait(data);
			customerAccount.saveUserImg(customers);
			System.out.println(customers);
			result.put("code", 1);
			result.put("msg", "保存头像成功");
		} catch (Exception e) {
			result.put("code", 0);
			result.put("msg", "保存头像失败");
			return "uploaderror";
		}
		return "e-commerce_account";
	}
}

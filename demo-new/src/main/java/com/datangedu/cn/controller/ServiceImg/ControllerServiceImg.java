package com.datangedu.cn.controller.ServiceImg;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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
import org.springframework.web.multipart.MultipartFile;

import com.datangedu.cn.Service.ServiceImg.ServiceImgServlet;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;
import com.datangedu.cn.model.serviceprovider.ServiceproviderWithBLOBs;

@Controller
@RequestMapping("/service")
public class ControllerServiceImg {
	@Resource
	ServiceImgServlet serviceImg;

	@RequestMapping(value = "/headimgshow", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg(HttpServletRequest request) throws Exception {

		byte[] imageContent;
		// 根据id获取当前用户的信息
		ServiceproviderWithBLOBs serpv = serviceImg.getServiceLine(request.getParameter("id"));
		System.out.println("1!"+serpv.getServProviderId());
		imageContent = serpv.getServProviderImg();
		System.out.println("2!"+"头像图片===" + serpv.getServProviderImg());

		// 设置http头部信息
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		// 返回响应实体
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/storeimgshow", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> StoreImg(HttpServletRequest request) throws Exception {

		byte[] imageContent; // 根据id获取当前用户的信息
		ServiceproviderWithBLOBs serpv = serviceImg.getServiceLine(request.getParameter("id"));
		System.out.println("3!"+serpv.getServProviderId());
		imageContent = serpv.getServProviderBusinesslicense();
		System.out.println("4!"+"执照图片===" + serpv.getServProviderBusinesslicense());

		// 设置http头部信息
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG); // 返回响应实体
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}

	// 用户头像
	@RequestMapping("/saveServImg")
	public String saveServImg(MultipartFile file, String serid) {
		System.out.println("5!"+"头像" + file);
		System.out.println("6!"+serid);
		Map<Object, Object> result = new HashMap<Object, Object>();
		try {
			// 获取客户端传图图片的输入流
			InputStream ins = file.getInputStream();
			byte[] buffer = new byte[1024];// bit---byte---1k---1m
			int len = 0;// 字节输出流
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			while ((len = ins.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
			bos.flush();
			byte data[] = bos.toByteArray();
			// 调用接口对图片进行存储
			ServiceproviderWithBLOBs pv = new ServiceproviderWithBLOBs();
			pv.setServProviderId(serid);
			pv.setServProviderImg(data);
			serviceImg.saveServImg(pv);
			result.put("code", 1);
			result.put("msg", "保存头像成功");
		} catch (Exception e) {
			result.put("code", 0);
			result.put("msg", "保存头像失败");
			return "uploaderror";
		}
		return "service_setting";
	}
	// 营业执照

	@RequestMapping("/saveStorImg")
	public String saveStorImg(MultipartFile file, String serid) {
		System.out.println("执照" + file);
		System.out.println(serid);
		Map<Object, Object> result = new HashMap<Object, Object>();
		try { // 获取客户端传图图片的输入流
			InputStream ins = file.getInputStream();
			byte[] buffer = new byte[1024];// bit---byte---1k---1m
			int len = 0;// 字节输出流
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			while ((len = ins.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
			bos.flush();
			byte data[] = bos.toByteArray(); // 调用接口对图片进行存储
			ServiceproviderWithBLOBs pv = new ServiceproviderWithBLOBs();
			pv.setServProviderId(serid);
			pv.setServProviderBusinesslicense(data);
			serviceImg.saveStoreImg(pv);
			result.put("code", 1);
			result.put("msg", "保存头像成功");
		} catch (Exception e) {
			result.put("code", 0);
			result.put("msg", "保存头像失败");
			return "uploaderror";
		}
		return "service_store";
	}
	
}

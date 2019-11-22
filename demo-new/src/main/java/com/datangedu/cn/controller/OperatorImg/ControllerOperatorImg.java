package com.datangedu.cn.controller.OperatorImg;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.datangedu.cn.Service.OperatorImg.OperatorImgServlet;
import com.datangedu.cn.model.administrator.Administrator;
import com.datangedu.cn.model.serviceprovider.ServiceproviderWithBLOBs;


@Controller
@RequestMapping(value = "/operator")
public class ControllerOperatorImg {
	@Resource
	OperatorImgServlet operatorImgServlet;
	@RequestMapping(value = "/headimgshow", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg(HttpServletRequest request) throws Exception {

		byte[] imageContent;
		// 根据id获取当前用户的信息
		Administrator adm = operatorImgServlet.getAdministratorLine(request.getParameter("id"));
		System.out.println("1!"+adm.getAdmiPortrait());
		imageContent = adm.getAdmiPortrait();
		System.out.println("2!"+"头像图片===" + adm.getAdmiPortrait());

		// 设置http头部信息
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		// 返回响应实体
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}

}

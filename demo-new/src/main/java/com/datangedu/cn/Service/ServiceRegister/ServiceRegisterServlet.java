package com.datangedu.cn.Service.ServiceRegister;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

public interface ServiceRegisterServlet {
	public int serviceRegister(HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException ;
	public String serviceId();
	public boolean findphone(HttpServletRequest request);
}

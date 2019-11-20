package com.datangedu.cn.Service.CustomerRegister;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;


public interface CustomerRegisterServlet {

	public String customerId();
	public boolean findphone(HttpServletRequest request);
	int customerInsert(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException;
	
}

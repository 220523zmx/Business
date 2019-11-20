package com.datangedu.cn.Service.CustomerAccount;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.customers.Customers;

public interface CustomerAccountServlet {

	int Information(HttpServletRequest request);

	int Password(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException;
	
	public String findpassword(HttpServletRequest request);

	public void saveUserImg(Customers customers) throws Exception;

	public Customers getUserInfo(String id);

}

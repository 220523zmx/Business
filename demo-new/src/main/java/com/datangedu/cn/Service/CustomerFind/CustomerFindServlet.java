package com.datangedu.cn.Service.CustomerFind;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

public interface CustomerFindServlet {
	public int customerFind(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException;

	public boolean findphone(HttpServletRequest request);
}

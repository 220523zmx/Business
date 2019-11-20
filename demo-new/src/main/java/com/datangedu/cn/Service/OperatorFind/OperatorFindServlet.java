package com.datangedu.cn.Service.OperatorFind;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

public interface OperatorFindServlet {

	int operatorFind(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException;
	public boolean findphone(HttpServletRequest request) ;
}

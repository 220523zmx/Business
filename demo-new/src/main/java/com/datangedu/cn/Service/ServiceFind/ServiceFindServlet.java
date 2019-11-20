package com.datangedu.cn.Service.ServiceFind;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

public interface ServiceFindServlet {

	int serviceFind(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException;
	public boolean findphone(HttpServletRequest request);

}

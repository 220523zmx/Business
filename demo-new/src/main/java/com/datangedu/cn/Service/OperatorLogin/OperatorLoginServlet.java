package com.datangedu.cn.Service.OperatorLogin;

import javax.servlet.http.HttpServletRequest;

public interface OperatorLoginServlet {

	String findphone(HttpServletRequest request);

	String findpassword(HttpServletRequest request);

	boolean upstatus(HttpServletRequest request);

	String findid(HttpServletRequest request);

	public String findadmname(HttpServletRequest request);

}

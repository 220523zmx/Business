package com.datangedu.cn.Service.CustomerPay;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.order.Allorder;

public interface CustomerPayServlet {
	public List<Allorder> findorder(HttpServletRequest Request);
	public int updatepayway(HttpServletRequest request);
	public int updatestate(HttpServletRequest request);
}

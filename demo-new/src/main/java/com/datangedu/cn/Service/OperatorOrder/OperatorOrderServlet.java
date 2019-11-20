package com.datangedu.cn.Service.OperatorOrder;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.order.Allorder;



public interface OperatorOrderServlet {

	List<Allorder> getOrderInfoByld(String orderId);
	
	int setOrderDelete(HttpServletRequest request);
	
}

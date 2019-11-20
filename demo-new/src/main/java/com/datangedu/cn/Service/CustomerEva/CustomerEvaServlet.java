package com.datangedu.cn.Service.CustomerEva;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.order.Allorder;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;

public interface CustomerEvaServlet {
	public List<Allorder> findhaseva(HttpServletRequest request);
	public List<Allorder> findnoteva(HttpServletRequest request);
	public String findserinstruction(Allorder allorder);
	public String findpcidbypcname(String str);
	public Serviceproduct findlinebypramarykey(String str);
	public int updateevaluate(HttpServletRequest request);
}

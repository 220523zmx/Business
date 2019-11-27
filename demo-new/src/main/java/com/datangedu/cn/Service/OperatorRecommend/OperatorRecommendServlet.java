package com.datangedu.cn.Service.OperatorRecommend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.serviceproduct.Serviceproduct;

public interface OperatorRecommendServlet {
	public long countorder(String likename);
	public List<Serviceproduct> topage(HttpServletRequest request) ;
}

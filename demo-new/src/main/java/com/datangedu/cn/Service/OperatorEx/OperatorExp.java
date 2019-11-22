package com.datangedu.cn.Service.OperatorEx;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.order.Allorder;

public interface OperatorExp {
       public List<Allorder> getExpSelDate(HttpServletRequest request);
       public List<Allorder> getExpSelnum(HttpServletRequest request);
	
	
	
}

package com.datangedu.cn.Service.ServiceOrder;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.order.Allorder;

public interface ServiceOrderServlet {

	public long countorder(String serid,String likename,int finish);

	public List<Allorder> topage(HttpServletRequest request);

	public String findcustomerphone(String customername);

	public String findprovidername(String providerid);
}

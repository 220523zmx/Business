package com.datangedu.cn.Service.OperatorUser;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.administrator.Administrator;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.serviceprovider.ServiceproviderWithBLOBs;

public interface AdministratorService {


	public long countorder(String likename, String from) ;
	List<Customers> topagea(HttpServletRequest request);
	List<ServiceproviderWithBLOBs> topageb(HttpServletRequest request);
	public int setUserDeletea(HttpServletRequest request) ;
	public int setUserDeleteb(HttpServletRequest request) ;
	
}

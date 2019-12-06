package com.datangedu.cn.Service.OperatorUser;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.AdministratorMapper;
import com.datangedu.cn.dao.mapper.CustomersMapper;
import com.datangedu.cn.dao.mapper.ServiceproviderMapper;
import com.datangedu.cn.model.administrator.Administrator;
import com.datangedu.cn.model.administrator.AdministratorExample;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.serviceprovider.Serviceprovider;
import com.datangedu.cn.model.serviceprovider.ServiceproviderWithBLOBs;

@Service
public class AdministratorServiceImpl implements AdministratorService{

	@Resource
	AdministratorMapper administratorMapper;
	@Resource
	CustomersMapper customersMapper;
	@Resource
	ServiceproviderMapper serviceproviderMapper;



	@Override
	public long countorder(String likename, String from) {
		long i = 0;
		Customers customers = new Customers();
		ServiceproviderWithBLOBs serviceprovider = new ServiceproviderWithBLOBs();
		 
		if(from.equals("a")==true) {
			i = customersMapper.countBylikename(likename);
			System.out.println(i);
			int pasize =customers.getPagesize();
			if (((i % pasize) != 0) | (i / pasize != 0)) {
				if (i % pasize != 0) {
					i = (i / pasize) + 1;
					return i;
				} else {
					i = (i / pasize);
					return i;

				}
			} else {
				i = 0;
				return i;
			}
		}else {
			i = serviceproviderMapper.countBylikename(likename);
			int pasize =serviceprovider.getPagesize();
			System.out.println(i);
			if (((i % pasize) != 0) | (i / pasize != 0)) {
				if (i % pasize != 0) {
					i = (i / pasize) + 1;
					return i;
				} else {
					i = (i / pasize);
					return i;

				}
			} else {
				i = 0;
				return i;
			}
		}
		
	}

	@Override
	public List<ServiceproviderWithBLOBs> topageb(HttpServletRequest request) {
		String likename = request.getParameter("likename");
		int nowpage = Integer.parseInt(request.getParameter("nowpage"));
		ServiceproviderWithBLOBs serviceproviderWithBLOBs = new ServiceproviderWithBLOBs();
		serviceproviderWithBLOBs.setLikename(likename);
		serviceproviderWithBLOBs.setNowpage(nowpage); 
		return serviceproviderMapper.selectbynamenp(serviceproviderWithBLOBs);
	}



	@Override
	public List<Customers> topagea(HttpServletRequest request) {
		String likename = request.getParameter("likename");
		int nowpage = Integer.parseInt(request.getParameter("nowpage"));
		Customers customers = new Customers();
		customers.setLikename(likename);
		customers.setNowpage(nowpage);
		return  customersMapper.selectbynamenp(customers);
	}

	@Override
	public int setUserDeletea(HttpServletRequest request) {
		return customersMapper.deleteByPrimaryKey(request.getParameter("id"));
	} 
	public int setUserDeleteb(HttpServletRequest request) {
		
		return serviceproviderMapper.deleteByPrimaryKey(request.getParameter("id"));
	} 
}


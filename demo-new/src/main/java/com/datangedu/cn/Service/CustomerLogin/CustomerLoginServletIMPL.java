package com.datangedu.cn.Service.CustomerLogin;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.datangedu.cn.MD5.MD5;
import com.datangedu.cn.Service.ServiceRegister.ServiceRegisterServlet;
import com.datangedu.cn.dao.mapper.CustomersMapper;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.customers.CustomersExample;
import com.datangedu.cn.model.serviceprovider.Serviceprovider;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;

@Service
public class CustomerLoginServletIMPL implements CustomerLoginServlet {

	@Resource
	CustomersMapper customersMapper;
	public String findphone(HttpServletRequest request) {
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria Criteria = customersExample.createCriteria();
		Criteria.andCustPhoneEqualTo(request.getParameter("phone"));
		List<Customers> List = customersMapper.selectByExample(customersExample);
		System.out.println("findphoone-status" + List);
		int status = List.size();
		if(status==0)
		{
			return "phonefalse";
		}
		String phone = List.get(0).getCustPhone();
		if (phone == null) {
			return "phonefalse";
		} else {
			return phone;
		}
	}
	
	public String findid(HttpServletRequest request){
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria Criteria = customersExample.createCriteria();
		Criteria.andCustPhoneEqualTo(request.getParameter("phone"));
		List<Customers> List = customersMapper.selectByExample(customersExample);
		System.out.println("findphoone-status" + List);
		String id = List.get(0).getCustId();
		if (id.equals("")) {
			return "passwordfalse";
		} else {
			return id;
		}
		
	}

	public String findpassword(HttpServletRequest request) {
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria Criteria = customersExample.createCriteria();
		Criteria.andCustPhoneEqualTo(request.getParameter("phone"));
		List<Customers> List = customersMapper.selectByExample(customersExample);
		System.out.println("findphoone-status" + List);
		String password = List.get(0).getCustPassword();
		if (password.equals("")) {
			return "passwordfalse";
		} else {
			return password;
		}
	}

	public boolean upstatus(HttpServletRequest request) {
		Customers customers = new Customers();
		customers.setCustState(1);
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria Criteria = customersExample.createCriteria();
		Criteria.andCustPhoneEqualTo(request.getParameter("phone"));
		int status = customersMapper.updateByExampleSelective(customers, customersExample);
		if (status == 1) {
			return true;
		} else {
			return false;
		}

	}

}

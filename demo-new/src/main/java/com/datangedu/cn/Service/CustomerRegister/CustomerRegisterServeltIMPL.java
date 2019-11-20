package com.datangedu.cn.Service.CustomerRegister;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.datangedu.cn.MD5.MD5;
import com.datangedu.cn.Random.ServletRandom;
import com.datangedu.cn.Random.ServletRandomIMPL;
import com.datangedu.cn.dao.mapper.CustomersMapper;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.customers.CustomersExample;

@Service
public class CustomerRegisterServeltIMPL implements CustomerRegisterServlet {
	@Resource
	CustomersMapper customersMapper;
	ServletRandom servletRandom;

	@Override
	public int customerInsert(HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MD5 md5 = new MD5();
		java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
		String id = customerId();
		System.out.println("顾客id：" + id);
		Customers customers = new Customers();
		customers.setCustPhone(request.getParameter("phone"));
		customers.setCustPassword(md5.EncoderByMd5(request.getParameter("password")));				
		customers.setCustRegion(request.getParameter("area"));
		customers.setCustId(id);
		customers.setCustStarttime(now);
		return customersMapper.insert(customers);
				

	}

	public String customerId() {
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria criteria = customersExample.createCriteria();
		boolean i = true;
		do {
			ServletRandomIMPL sRandom = new ServletRandomIMPL();
			String id = sRandom.getRandomCode(11);
			criteria.andCustIdEqualTo(id);
			Long findid = customersMapper.countByExample(customersExample);
			System.out.println("customeId-findid" + findid);
			if (findid == 0) {
				i = false;
				return id.toString();
			} else {
				i = true;
			}
		} while (i == false);
		return "false";
	}
	
	public boolean findphone(HttpServletRequest request) {
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria criteria = customersExample.createCriteria();
		criteria.andCustPhoneEqualTo(request.getParameter("phone"));
		Long status = customersMapper.countByExample(customersExample);
		System.out.println("findphoone-status" + status);
		if (status == 0) {
			return true;
		} else {
			return false;
		}
	}

}

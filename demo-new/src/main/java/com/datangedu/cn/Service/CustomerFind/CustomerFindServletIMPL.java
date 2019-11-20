package com.datangedu.cn.Service.CustomerFind;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.datangedu.cn.MD5.MD5;
import com.datangedu.cn.dao.mapper.CustomersMapper;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.customers.CustomersExample;

@Service
public class CustomerFindServletIMPL implements CustomerFindServlet {
	@Resource
	CustomersMapper customersMapper;

	@Override
	public int customerFind(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MD5 md5 = new MD5();
		Customers customers = new Customers();
		customers.setCustPassword(md5.EncoderByMd5(request.getParameter("newpassword")));
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria criteria = customersExample.createCriteria();
		criteria.andCustPhoneEqualTo(request.getParameter("phone"));
		return customersMapper.updateByExampleSelective(customers, customersExample);
	}

	public boolean findphone(HttpServletRequest request) {
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria criteria = customersExample.createCriteria();
		criteria.andCustPhoneEqualTo(request.getParameter("phone"));
		Long status = customersMapper.countByExample(customersExample);
		System.out.println("findphoone-status" + status);
		if (status != 0) {
			return true;
		} else {
			return false;
		}
	}
}

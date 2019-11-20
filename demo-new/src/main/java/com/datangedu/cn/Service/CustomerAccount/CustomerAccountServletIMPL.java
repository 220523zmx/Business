package com.datangedu.cn.Service.CustomerAccount;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.MD5.MD5;
import com.datangedu.cn.Random.ServletRandom;
import com.datangedu.cn.dao.mapper.CustomersMapper;
import com.datangedu.cn.dao.mapper.ServiceproviderMapper;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.customers.CustomersExample;

@Service
public class CustomerAccountServletIMPL implements CustomerAccountServlet {
	@Resource
	CustomersMapper customersMapper;

	public int Information(HttpServletRequest request) {
		Customers customers = new Customers();	
		if(request.getParameter("name").equals("")==false){
			customers.setCustName(request.getParameter("name"));
		}
		if(request.getParameter("email").equals("")==false){
			customers.setCustEmail(request.getParameter("email"));
		}
		if(request.getParameter("sex").equals("")==false){
			customers.setCustSex(request.getParameter("sex"));
		}
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria criteria = customersExample.createCriteria();
		criteria.andCustPhoneEqualTo(request.getParameter("phone"));
		int state = customersMapper.updateByExampleSelective(customers, customersExample);
		return state;
	}

	public int Password(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MD5 md5 = new MD5();
		Customers customers = new Customers();
		customers.setCustPassword(md5.EncoderByMd5(request.getParameter("newpassword")));
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria criteria = customersExample.createCriteria();
		criteria.andCustPhoneEqualTo(request.getParameter("phone"));
		return customersMapper.updateByExampleSelective(customers, customersExample);
		
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
	public void saveUserImg(Customers costomer) throws Exception {
		int i = customersMapper.saveCuImg(costomer);
		if(i!=1) {
			throw new Exception("更新用户头像失败");
		}
	}

	@Override
	public Customers getUserInfo(String id) {
		return customersMapper.selectByPrimaryKey(id);
	}

}

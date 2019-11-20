package com.datangedu.cn.Service.OperatorFind;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.MD5.MD5;
import com.datangedu.cn.dao.mapper.AdministratorMapper;
import com.datangedu.cn.dao.mapper.CustomersMapper;
import com.datangedu.cn.model.administrator.Administrator;
import com.datangedu.cn.model.administrator.AdministratorExample;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.customers.CustomersExample;

@Service
public class OperatorFindServletIMPL implements OperatorFindServlet {
	@Resource
	AdministratorMapper administratorMapper;

	@Override
	public int operatorFind(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MD5 md5 = new MD5();
		Administrator administrator = new Administrator();
		administrator.setAdmiPassword(md5.EncoderByMd5(request.getParameter("newpassword")));
		AdministratorExample administratorExample = new AdministratorExample();
		AdministratorExample.Criteria criteria = administratorExample.createCriteria();
		criteria.andAdmiPhoneEqualTo(request.getParameter("phone"));
		return administratorMapper.updateByExampleSelective(administrator, administratorExample);
	}

	public boolean findphone(HttpServletRequest request) {
		AdministratorExample administratorExample = new AdministratorExample();
		AdministratorExample.Criteria criteria = administratorExample.createCriteria();
		criteria.andAdmiPhoneEqualTo(request.getParameter("phone"));
		Long status = administratorMapper.countByExample(administratorExample);
		System.out.println("findphoone-status" + status);
		if (status != 0) {
			return true;
		} else {
			return false;
		}
	}
}
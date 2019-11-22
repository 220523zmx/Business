package com.datangedu.cn.Service.OperatorLogin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.AdministratorMapper;
import com.datangedu.cn.dao.mapper.CustomersMapper;
import com.datangedu.cn.model.administrator.Administrator;
import com.datangedu.cn.model.administrator.AdministratorExample;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.customers.CustomersExample;

@Service
public class OperatorLoginServletIMPL implements OperatorLoginServlet {

	@Resource
	AdministratorMapper administratorMapper;

	public String findphone(HttpServletRequest request) {
		AdministratorExample administratorExample = new AdministratorExample();
		AdministratorExample.Criteria Criteria = administratorExample.createCriteria();
		Criteria.andAdmiPhoneEqualTo(request.getParameter("phone"));
		List<Administrator> List = administratorMapper.selectByExample(administratorExample);
		System.out.println("findphoone-status" + List);
		int status = List.size();
		if (status == 0) {
			return "phonefalse";
		}
		String phone = List.get(0).getAdmiPhone();
		if (phone == null) {
			return "phonefalse";
		} else {
			return phone;
		}
	}

	public String findid(HttpServletRequest request) {
		AdministratorExample administratorExample = new AdministratorExample();
		AdministratorExample.Criteria Criteria = administratorExample.createCriteria();
		Criteria.andAdmiPhoneEqualTo(request.getParameter("phone"));
		List<Administrator> List = administratorMapper.selectByExample(administratorExample);
		System.out.println("findphoone-status" + List);
		String id = List.get(0).getAdmiId();
		if (id.equals("")) {
			return "idfalse";
		} else {
			return id;
		}
	}

	public String findpassword(HttpServletRequest request) {
		AdministratorExample administratorExample = new AdministratorExample();
		AdministratorExample.Criteria Criteria = administratorExample.createCriteria();
		Criteria.andAdmiPhoneEqualTo(request.getParameter("phone"));
		List<Administrator> List = administratorMapper.selectByExample(administratorExample);
		System.out.println("findphoone-status" + List);
		String password = List.get(0).getAdmiPassword();
		if (password.equals("")) {
			return "passwordfalse";
		} else {
			return password;
		}
	}

	public boolean upstatus(HttpServletRequest request) {
		Administrator administrator = new Administrator();
		administrator.setAdmiState(1);
		AdministratorExample administratorExample = new AdministratorExample();
		AdministratorExample.Criteria Criteria = administratorExample.createCriteria();
		Criteria.andAdmiPhoneEqualTo(request.getParameter("phone"));
		int status = administratorMapper.updateByExampleSelective(administrator, administratorExample);
		if (status == 1) {
			return true;
		} else {
			return false;
		}
	}
	public String findadmname(HttpServletRequest request)
	{
		return administratorMapper.selectByPrimaryKey(findid(request)).getAdmiName();
		
	}
}

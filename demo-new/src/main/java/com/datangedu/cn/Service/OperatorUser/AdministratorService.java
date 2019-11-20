package com.datangedu.cn.Service.OperatorUser;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.administrator.Administrator;

public interface AdministratorService {

	 List<Administrator> getUserInfoByld(String iadmiNamed);
		
		
		int setUserRegister(HttpServletRequest request);

		int setUserDelete(HttpServletRequest request);
	
}

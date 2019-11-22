package com.datangedu.cn.Service.OperatorImg;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.AdministratorMapper;
import com.datangedu.cn.model.administrator.Administrator;

@Service
public class OperatorImgServletIMPL implements OperatorImgServlet {
	@Resource
	AdministratorMapper administrator;
	public Administrator getAdministratorLine(String adid)
	{
		return administrator.selectByPrimaryKey(adid);
	}

}

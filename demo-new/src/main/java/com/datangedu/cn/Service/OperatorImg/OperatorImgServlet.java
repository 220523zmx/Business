package com.datangedu.cn.Service.OperatorImg;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.datangedu.cn.dao.mapper.AdministratorMapper;
import com.datangedu.cn.model.administrator.Administrator;

public interface OperatorImgServlet {
	
	public Administrator getAdministratorLine(String adid);

}

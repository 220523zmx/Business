package com.datangedu.cn.Service.OperatorUser;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.AdministratorMapper;
import com.datangedu.cn.model.administrator.Administrator;
import com.datangedu.cn.model.administrator.AdministratorExample;

@Service
public class AdministratorServiceImpl implements AdministratorService{

	@Resource
	AdministratorMapper administratorMapper;
	

	@Override
	public int setUserRegister(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setUserDelete(HttpServletRequest request) {
        String id = request.getParameter("admiId");
		
        AdministratorExample administratorExample = new AdministratorExample();
        AdministratorExample.Criteria criteria = administratorExample.createCriteria();
  	    criteria.andAdmiIdEqualTo(id);
  	    
		return administratorMapper.deleteByExample(administratorExample);
	}

	@Override
	public List<Administrator> getUserInfoByld(String iadmiNamed) {
		
		System.out.println("查询用户姓名== "+ iadmiNamed);
		
		//调用查询方法
		AdministratorExample administratorExample = new AdministratorExample();
		AdministratorExample.Criteria criteria = administratorExample.createCriteria();
		
		
		administratorExample.setOrderByClause("ADMI_NAME");
		
		administratorExample.setPageSize(1);
		administratorExample.getPageNum(4);
		administratorExample.setLikeName(iadmiNamed);
		
		return administratorMapper.selectBylike(administratorExample);

	}
	 
}

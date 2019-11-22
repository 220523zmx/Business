package com.datangedu.cn.Serviceimpl.OperatorFa;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.Service.OperatorFa.getListSelect;
import com.datangedu.cn.dao.mapper.ServiceproviderMapper;
import com.datangedu.cn.model.serviceprovider.Serviceprovider;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;
@Service
public class getListSelectImpl implements getListSelect {

	@Resource
	ServiceproviderMapper serviceproviderMapper;
	@Resource
	ServiceproviderExample serviceproviderExample;
	@Override
	public List<Serviceprovider> MOHuFSelect(HttpServletRequest request) {
		// TODO Auto-generated method stub
		serviceproviderExample.setPagesize(Integer.parseInt(request.getParameter("pagesize")));
		serviceproviderExample.setPagesnum(Integer.parseInt(request.getParameter("pagenum")));
		serviceproviderExample.setName(request.getParameter("name"));
		
		
		return serviceproviderMapper.selectByExampleO(serviceproviderExample);
	}

	public List<Serviceprovider> MOHuFSelectS(HttpServletRequest request){
		
		
		serviceproviderExample.setPagesize(Integer.parseInt(request.getParameter("pagesize")));
		serviceproviderExample.setPagesnum(Integer.parseInt(request.getParameter("pagenum")));
		serviceproviderExample.setName(request.getParameter("name"));
		
		
		return serviceproviderMapper.selectByExampleOall(serviceproviderExample);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

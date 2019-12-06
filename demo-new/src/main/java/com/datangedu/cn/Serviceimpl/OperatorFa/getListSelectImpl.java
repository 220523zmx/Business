package com.datangedu.cn.Serviceimpl.OperatorFa;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.Service.OperatorFa.getListSelect;
import com.datangedu.cn.dao.mapper.ServiceproviderMapper;
import com.datangedu.cn.model.serviceprovider.Serviceprovider;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;
import com.datangedu.cn.model.serviceprovider.ServiceproviderWithBLOBs;
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
		serviceproviderExample.setFindstate(Integer.parseInt(request.getParameter("findstate")));
		return serviceproviderMapper.selectByExampleO(serviceproviderExample);
	}
	public List<Serviceprovider> MOHuFSelectS(HttpServletRequest request){
		serviceproviderExample.setPagesize(Integer.parseInt(request.getParameter("pagesize")));
		serviceproviderExample.setPagesnum(Integer.parseInt(request.getParameter("pagenum")));
		serviceproviderExample.setName(request.getParameter("name"));
		serviceproviderExample.setFindstate(Integer.parseInt(request.getParameter("findstate")));
		return serviceproviderMapper.selectByExampleOall(serviceproviderExample);

	}
	public int updatedown(HttpServletRequest request) {
		ServiceproviderWithBLOBs serviceproviderWithBLOBs = new ServiceproviderWithBLOBs();
		ServiceproviderExample  serviceproviderExample =new ServiceproviderExample();
		ServiceproviderExample.Criteria criteria= serviceproviderExample.createCriteria();
		criteria.andServProviderIdEqualTo(request.getParameter("id"));
		serviceproviderWithBLOBs.setServProviderState(0);
		return serviceproviderMapper.updateByExampleSelective(serviceproviderWithBLOBs, serviceproviderExample);
	}
	public int updateup(HttpServletRequest request) {
		ServiceproviderWithBLOBs serviceproviderWithBLOBs = new ServiceproviderWithBLOBs();
		ServiceproviderExample  serviceproviderExample =new ServiceproviderExample();
		ServiceproviderExample.Criteria criteria= serviceproviderExample.createCriteria();
		criteria.andServProviderIdEqualTo(request.getParameter("id"));
		serviceproviderWithBLOBs.setServProviderState(1);
		return serviceproviderMapper.updateByExampleSelective(serviceproviderWithBLOBs, serviceproviderExample);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

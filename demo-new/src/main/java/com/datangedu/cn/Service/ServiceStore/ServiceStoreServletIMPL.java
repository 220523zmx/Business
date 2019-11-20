package com.datangedu.cn.Service.ServiceStore;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.ServiceproviderMapper;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;
import com.datangedu.cn.model.serviceprovider.ServiceproviderWithBLOBs;

@Service
public class ServiceStoreServletIMPL implements ServiceStoreServlet {
	@Resource
	ServiceproviderMapper serviceproviderMapper ;
	public int updateintpv(ServiceproviderWithBLOBs serv,String pvid) {
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria criteria  = serviceproviderExample.createCriteria(); 
		criteria.andServProviderIdEqualTo(pvid);
		return serviceproviderMapper.updateByExampleSelective(serv, serviceproviderExample);
		
	}

}

package com.datangedu.cn.Service.ServiceProduct;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.ServiceproductMapper;
import com.datangedu.cn.dao.mapper.ServiceproviderMapper;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;
import com.datangedu.cn.model.serviceproduct.ServiceproductExample;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;

@Service
public class ServiceProductServletIMPL implements ServiceProductServlet {
	@Resource
	ServiceproductMapper serviceproductMapper;
	@Resource
	ServiceproviderMapper serviceproviderMapper;
	
	public int insertproduct(Serviceproduct product)
	{
		/*ServiceproductExample serviceproductExample = new ServiceproductExample();
		ServiceproductExample.Criteria criteria = serviceproductExample .createCriteria();*/
		
		return serviceproductMapper.insertSelective(product);
	}
	public String findsername(String serid)
	{
		return serviceproviderMapper.selectByPrimaryKey(serid).getServProviderName();
	}
	public List<Serviceproduct> productshow(String serid)
	{
		ServiceproductExample serviceproductExample = new ServiceproductExample();
		ServiceproductExample.Criteria criteria = serviceproductExample .createCriteria();
		criteria.andServProvideridEqualTo(serid);
		return serviceproductMapper.selectByExample(serviceproductExample);
		
	}
	@Override
	public int prodelete(String pvid, String pcid) {
		ServiceproductExample serviceproductExample = new ServiceproductExample();
		ServiceproductExample.Criteria criteria = serviceproductExample .createCriteria();
		criteria.andServProvideridEqualTo(pvid);
		criteria.andServProductidEqualTo(pcid);
		return serviceproductMapper.deleteByExample(serviceproductExample);
	}
	@Override
	public int stateup(String pvid, String pcid) {
		Serviceproduct pc = new Serviceproduct();
		pc.setServState(1);
		ServiceproductExample serviceproductExample = new ServiceproductExample();
		ServiceproductExample.Criteria criteria = serviceproductExample .createCriteria();
		criteria.andServProvideridEqualTo(pvid);
		criteria.andServProductidEqualTo(pcid);
		return serviceproductMapper.updateByExampleSelective(pc, serviceproductExample);
	}
	@Override
	public int statedown(String pvid, String pcid) {
		Serviceproduct pc = new Serviceproduct();
		pc.setServState(0);
		ServiceproductExample serviceproductExample = new ServiceproductExample();
		ServiceproductExample.Criteria criteria = serviceproductExample .createCriteria();
		criteria.andServProvideridEqualTo(pvid);
		criteria.andServProductidEqualTo(pcid);
		return serviceproductMapper.updateByExampleSelective(pc, serviceproductExample);
	}
	@Override
	public List<Serviceproduct> productnamelike(String namelike, String pvid) {
		
		return serviceproductMapper.findproductnamelike(namelike, pvid);
	}
}

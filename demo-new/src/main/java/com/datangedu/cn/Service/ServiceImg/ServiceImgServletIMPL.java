package com.datangedu.cn.Service.ServiceImg;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.ServiceproductMapper;
import com.datangedu.cn.dao.mapper.ServiceproviderMapper;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;
import com.datangedu.cn.model.serviceproduct.ServiceproductExample;
import com.datangedu.cn.model.serviceprovider.ServiceproviderWithBLOBs;

@Service
public class ServiceImgServletIMPL implements ServiceImgServlet {

	
	@Resource
	ServiceproviderMapper serviceprovider;
	@Resource
	ServiceproductMapper serviceproductMapper;
	@Override
	public ServiceproviderWithBLOBs getServiceLine(String pvid) {
		
		return serviceprovider.selectByPrimaryKey(pvid);
	}
	@Override
	public void saveServImg(ServiceproviderWithBLOBs service) throws Exception {
		int i = serviceprovider.savePvImg(service);
		System.out.println(i);
		if(i!=1) {
			throw new Exception("更新服务商头像失败");
		}
	}
	@Override
	public void saveStoreImg(ServiceproviderWithBLOBs service) throws Exception {
		int i = serviceprovider.saveStImg(service);
		System.out.println(i);
		if(i!=1) {
			throw new Exception("更新营业执照失败");
		}
		
	}
	@Override
	public int findbypcid(String pcid) {
		ServiceproductExample serviceproductExample = new ServiceproductExample();
		ServiceproductExample.Criteria criteria = serviceproductExample.createCriteria();
		if(serviceproductMapper.selectByPrimaryKey(pcid)==null)
		{
			return 0;
		}
		else {
			return 1;
		}
		
	}
	@Override
	public void updatebypcid(Serviceproduct serviceproduct,String pcid) throws Exception {
		ServiceproductExample serviceproductExample = new ServiceproductExample();
		ServiceproductExample.Criteria criteria = serviceproductExample.createCriteria();
		criteria.andServProductidEqualTo(pcid);
		int i = serviceproductMapper.updateByExampleSelective(serviceproduct, serviceproductExample);
		if(i!=1) {
			throw new Exception("插入商品头像失败");
		}
		
	}
	@Override
	public void insertbypcid(Serviceproduct serviceproduct) throws Exception {
		ServiceproductExample serviceproductExample = new ServiceproductExample();
		ServiceproductExample.Criteria criteria = serviceproductExample.createCriteria();
		int i = serviceproductMapper.insertSelective(serviceproduct);
		if(i!=1) {
			throw new Exception("插入商品头像失败");
		}
		
	}

}

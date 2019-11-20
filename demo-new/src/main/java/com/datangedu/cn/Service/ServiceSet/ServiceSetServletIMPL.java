package com.datangedu.cn.Service.ServiceSet;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.AreaMapper;
import com.datangedu.cn.dao.mapper.CitysMapper;
import com.datangedu.cn.dao.mapper.ProvinceMapper;
import com.datangedu.cn.dao.mapper.ServiceproviderMapper;
import com.datangedu.cn.model.area.Area;
import com.datangedu.cn.model.area.AreaExample;
import com.datangedu.cn.model.city.Citys;
import com.datangedu.cn.model.city.CitysExample;
import com.datangedu.cn.model.province.Province;
import com.datangedu.cn.model.province.ProvinceExample;
import com.datangedu.cn.model.serviceprovider.Serviceprovider;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;
import com.datangedu.cn.model.serviceprovider.ServiceproviderWithBLOBs;

@Service
public class ServiceSetServletIMPL implements ServiceSetServlet {

	@Resource
	ServiceproviderMapper serviceproviderMapper;
	@Resource
	AreaMapper areaMapper;
	@Resource
	CitysMapper citysMapper;
	@Resource
	ProvinceMapper provinceMapper;

	public int updateserinformation(ServiceproviderWithBLOBs service,String pvid) {
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria criteria = serviceproviderExample.createCriteria();
		criteria.andServProviderIdEqualTo(pvid);
		return serviceproviderMapper.updateByExampleSelective(service, serviceproviderExample);
	}

	@Override
	public Serviceprovider listshow(String pvid) {
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria criteria = serviceproviderExample.createCriteria();
		criteria.andServProviderIdEqualTo(pvid);
		return serviceproviderMapper.selectByPrimaryKey(pvid);
	}

	public List<Province> findprovince(String citycode) {
		ProvinceExample provinceExample = new ProvinceExample();
		ProvinceExample.Criteria  criteria = provinceExample.createCriteria();
		criteria.andCodeEqualTo(citycode);
		return provinceMapper.selectByExample(provinceExample);
	}

	public List<Citys> findcity(String citycode) {
		CitysExample citysExample = new CitysExample();
		CitysExample.Criteria criteria = citysExample .createCriteria();
		criteria.andCodeEqualTo(citycode);
		return citysMapper.selectByExample(citysExample);

	}

	public List<Area>findarea(String areacode) {
		AreaExample areaExample = new AreaExample();
		AreaExample.Criteria criteria = areaExample.createCriteria();
		criteria.andCodeEqualTo(areacode);
		return  areaMapper.selectByExample(areaExample);
	}
	public boolean findphone(String phone)
	{
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria criteria = serviceproviderExample.createCriteria();
		criteria.andServProviderPhoneEqualTo(phone);
		List<Serviceprovider> list = serviceproviderMapper.selectByExample(serviceproviderExample);
		if(list.size()==0)
		{
			return true;
		}
		else {
			return false;
		}
	}

}

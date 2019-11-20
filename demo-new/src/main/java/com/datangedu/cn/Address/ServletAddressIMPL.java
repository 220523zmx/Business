package com.datangedu.cn.Address;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.AreaMapper;
import com.datangedu.cn.dao.mapper.CitysMapper;
import com.datangedu.cn.dao.mapper.ProvinceMapper;
import com.datangedu.cn.model.area.Area;
import com.datangedu.cn.model.area.AreaExample;
import com.datangedu.cn.model.city.Citys;
import com.datangedu.cn.model.city.CitysExample;
import com.datangedu.cn.model.province.Province;
import com.datangedu.cn.model.province.ProvinceExample;
@Service
public class ServletAddressIMPL implements ServletAddress {
	@Resource
	ProvinceMapper provinceMapper; 
	public List<Province> getAllProvince()
	{
		ProvinceExample provinceExample = new ProvinceExample();
		ProvinceExample.Criteria criteria = provinceExample.createCriteria();
		return provinceMapper.selectByExample(provinceExample);
	}
	@Resource
	CitysMapper citysMapper; 
	@Override
	public List<Citys> getCityOfProvience(HttpServletRequest request) {
		
		CitysExample citysExample = new CitysExample();
		CitysExample.Criteria criteria = citysExample.createCriteria();
		criteria.andProvincecodeEqualTo(request.getParameter("provCode")); 
		return citysMapper.selectByExample(citysExample);
		
	}
	@Resource
	AreaMapper areaMapper; 
	@Override
	public List<Area> getAreaOfCity(HttpServletRequest request) {
		AreaExample areaExample = new AreaExample();
		AreaExample.Criteria criteria = areaExample.createCriteria();
		criteria.andCitycodeEqualTo(request.getParameter("citysCode"));
		return areaMapper.selectByExample(areaExample);
	}
}

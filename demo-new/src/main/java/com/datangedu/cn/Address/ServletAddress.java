package com.datangedu.cn.Address;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.area.Area;
import com.datangedu.cn.model.city.Citys;
import com.datangedu.cn.model.province.Province;

public interface ServletAddress {
	public List<Province> getAllProvince();

	public List<Citys> getCityOfProvience(HttpServletRequest request);

	public List<Area> getAreaOfCity(HttpServletRequest request);

}

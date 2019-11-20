package com.datangedu.cn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.Address.ServletAddress;
import com.datangedu.cn.model.area.Area;
import com.datangedu.cn.model.city.Citys;
import com.datangedu.cn.model.province.Province;


@Controller
@RequestMapping("/Address")
public class ControllerAddress {
	
	  @Resource
	  ServletAddress servletAddress;
	  @ResponseBody
	  @RequestMapping(value= "/init",method = RequestMethod.POST)
	  public Map<String,Object> initAddress(HttpServletRequest request) {
		  Map<String,Object> map = new HashMap<String,Object>();
		  List<Province> provinceList = servletAddress.getAllProvince();
		  map.put("provinceList", provinceList);
		  return map;
	  }
	
	  @ResponseBody
	  @RequestMapping(value= "/city",method = RequestMethod.POST) 
	  public Map<String,Object> findCitysByProvinceCode(HttpServletRequest request) {
		  Map<String,Object> map = new HashMap<String,Object>(); 
		  List<Citys> citysList = servletAddress.getCityOfProvience(request); 
		  map.put("citysList",citysList); 
		  return map; 
	  }
	  @ResponseBody
	  @RequestMapping(value= "/area",method = RequestMethod.POST) 
	  public Map<String,Object> findAreaByCitysCode(HttpServletRequest request) {
		  Map<String,Object> map = new HashMap<String,Object>(); 
		  List<Area> areaList = servletAddress.getAreaOfCity(request); 
		  map.put("areaList",areaList); 
		  return map; 
	  }
	 
}



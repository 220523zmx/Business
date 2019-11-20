package com.datangedu.cn.Service.ServiceSet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.area.Area;
import com.datangedu.cn.model.city.Citys;
import com.datangedu.cn.model.province.Province;
import com.datangedu.cn.model.serviceprovider.Serviceprovider;
import com.datangedu.cn.model.serviceprovider.ServiceproviderWithBLOBs;

public interface ServiceSetServlet {

	public int updateserinformation(ServiceproviderWithBLOBs service,String pvid) ;
	public Serviceprovider listshow(String pvid);
	public List<Province> findprovince(String citycode) ;
	public List<Citys> findcity(String citycode) ;
	public List<Area>findarea(String areacode) ;
	public boolean findphone(String phone);

}

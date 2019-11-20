package com.datangedu.cn.controller.ServiceSet;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.Service.ServiceSet.ServiceSetServlet;
import com.datangedu.cn.model.area.Area;
import com.datangedu.cn.model.city.Citys;
import com.datangedu.cn.model.province.Province;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;
import com.datangedu.cn.model.serviceprovider.Serviceprovider;
import com.datangedu.cn.model.serviceprovider.ServiceproviderWithBLOBs;

@Controller
@RequestMapping("/service")
public class ControllerServiceproviderSet {
	@Resource
	ServiceSetServlet serviceExpServlet;

	@ResponseBody
	@RequestMapping(value = "/information", method = RequestMethod.POST)
	public Map<String, Object> updateserviceprodiver(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		ServiceproviderWithBLOBs service = new ServiceproviderWithBLOBs();
		String pvproname = request.getParameter("pvproname");
		String pvphone = request.getParameter("pvphone");
		String pvwechart = request.getParameter("pvwechart");
		String pvqq = request.getParameter("pvqq");
		String pvemail = request.getParameter("pvemail");
		String pvid = request.getParameter("pvid");
		String area = request.getParameter("area");
		if (pvphone.equals("") == false) {
			service.setServProviderPhone(pvphone);
		} else if (area.equals("-1")) {
			service.setServProviderRegion(area);

		} else if (pvproname.equals("") == false) {
			service.setServProviderName(pvproname);

		} else if (pvwechart.equals("") == false) {
			service.setServProviderWeichart(pvwechart);

		} else if (pvqq.equals("") == false) {
			service.setServProviderQq(pvqq);

		} else if (pvemail.equals("") == false) {
			service.setServProviderEmail(pvemail);
		}
		if (pvphone.equals("") == false) {
			if (pvphone.length() != 11) {// 输入电话号但是格式不对
				map.put("code", 2);
				map.put("status", "请输入11位电话号码");
			} else if (serviceExpServlet.findphone(pvphone) == false) {
				map.put("code", 2);
				map.put("status", "输入的电话号码已存在");
			} else {// 电话号码允许更改
				int a = serviceExpServlet.updateserinformation(service, pvid);
				if (a == 0) {
					map.put("code", 2);
					map.put("status", "更新失败");
				} else {
					map.put("code", 1);
					map.put("status", "更新成功");
				}
			}
		}

		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/lineshow", method = RequestMethod.GET)
	public Map<String, Object> listshow(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		Serviceprovider a = serviceExpServlet.listshow(request.getParameter("pvid"));
		Area area = serviceExpServlet.findarea(a.getServProviderRegion()).get(0);
		Citys citys = serviceExpServlet.findcity(area.getCitycode()).get(0);
		Province province = serviceExpServlet.findprovince(citys.getProvincecode()).get(0);
		String areaname = area.getName();
		String citysname = citys.getName();
		String provincename = province.getName();
		String space = "-";
		String newarea = new String();
		System.out.println(areaname + "--" + citysname + "--" + provincename);
		if (provincename.equals(citysname) == true) {
			newarea = (provincename + space + areaname);
			System.out.println("same" + newarea);
		} else {
			newarea = (provincename + space + citysname + space + areaname);
			System.out.println("diffrent" + newarea);
		}
		a.setServProviderRegion(newarea);
		System.out.println(a);
		if (a.getServProviderId().equals("") == false) {
			map.put("line", a);

		} else {
			map.put("code", 2);
			map.put("status", "更改 失败");
		}

		return map;
	}

}

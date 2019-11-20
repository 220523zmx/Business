package com.datangedu.cn.controller.ServiceStore;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.Service.ServiceStore.ServiceStoreServlet;
import com.datangedu.cn.model.serviceprovider.ServiceproviderWithBLOBs;

@Controller
@RequestMapping("/service")
public class ControllerServiceStore {
	@Resource
	ServiceStoreServlet serviceStoreServlet;

	@ResponseBody
	@RequestMapping(value = "updatepvint", method = RequestMethod.POST)
	public Map<String, Object> updatepvint(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		ServiceproviderWithBLOBs sevp = new ServiceproviderWithBLOBs();
		sevp.setServProviderId(request.getParameter("pvid"));
		System.out.println(request.getParameter("pvid"));
		String pvin = request.getParameter("pvintrduction");
		String pvqq = request.getParameter("pvqq");
		String work = request.getParameter("worktime");
		String pvtel = request.getParameter("pvtell");
		System.out.println(pvin+" "+pvqq+" "+work+" "+pvtel);
		if (request.getParameter("pvintrduction").equals("") == false) {
			sevp.setServCompanyIntrduction(request.getParameter("pvintrduction"));
		} 
		if (request.getParameter("pvqq").equals("") == false) {
			sevp.setServProviderQq(request.getParameter("pvqq"));
		}
		if (request.getParameter("worktime").equals("") == false) {
			sevp.setServProviderWorktime(request.getParameter("worktime"));
		} 
		if (request.getParameter("pvtell").equals("") == false) {
			sevp.setServProviderCsphone(request.getParameter("pvtell"));
		}
		int i = serviceStoreServlet.updateintpv(sevp,request.getParameter("pvid"));
		System.out.println(i);
		if (i == 0) {
			map.put("code", 0);
			map.put("status", "更新失败");
		} else {

			map.put("code", 1);
			map.put("status", "更新成功");
		}
		return map;
	}
}

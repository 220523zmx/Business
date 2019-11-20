package com.datangedu.cn.Service.ServiceRegister;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.datangedu.cn.MD5.MD5;
import com.datangedu.cn.Random.ServletRandom;
import com.datangedu.cn.Random.ServletRandomIMPL;
import com.datangedu.cn.dao.mapper.CustomersMapper;
import com.datangedu.cn.dao.mapper.ServiceproviderMapper;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.customers.CustomersExample;
import com.datangedu.cn.model.serviceprovider.Serviceprovider;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;
import com.datangedu.cn.model.serviceprovider.ServiceproviderWithBLOBs;
@Service
public class ServiceRegisterServletIMPL implements ServiceRegisterServlet {
	@Resource
	ServiceproviderMapper serviceproviderMapper;
	ServletRandom servletRandom;

	public int serviceRegister(HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MD5 md5 = new MD5();
		java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
		String id = serviceId();
		System.out.println("服务商id：" + id);
		ServiceproviderWithBLOBs serviceproviderWithBLOBs= new ServiceproviderWithBLOBs();
		serviceproviderWithBLOBs.setServProviderPhone(request.getParameter("phone"));
		serviceproviderWithBLOBs.setServProviderPassword(md5.EncoderByMd5(request.getParameter("password")));
		serviceproviderWithBLOBs.setServProviderRegion(request.getParameter("area"));
		serviceproviderWithBLOBs.setServProviderId(id);
		serviceproviderWithBLOBs.setServProviderStarttime(now);
		return serviceproviderMapper.insert(serviceproviderWithBLOBs);
	}

	public String serviceId() {
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria criteria = serviceproviderExample.createCriteria();
		boolean i = true;
		do {
			ServletRandomIMPL sRandom = new ServletRandomIMPL();
			String id = sRandom.getRandomCode(11);
			criteria.andServProviderIdEqualTo(id);
			Long findid = serviceproviderMapper.countByExample(serviceproviderExample);
			System.out.println("customeId-findid" + findid);
			if (findid == 0) {
				i = false;
				return id.toString();
			} else {
				i = true;
			}
		} while (i == false);
		return "false";
	}

	public boolean findphone(HttpServletRequest request) {
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria criteria = serviceproviderExample.createCriteria();
		criteria.andServProviderPhoneEqualTo(request.getParameter("phone"));
		Long status = serviceproviderMapper.countByExample(serviceproviderExample);
		System.out.println("findphoone-status" + status);
		if (status == 0) {
			return true;
		} else {
			return false;
		}
	}
}

package com.datangedu.cn.Service.ServiceFind;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.datangedu.cn.MD5.MD5;
import com.datangedu.cn.Service.CustomerFind.CustomerFindServlet;
import com.datangedu.cn.dao.mapper.CustomersMapper;
import com.datangedu.cn.dao.mapper.ServiceproviderMapper;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.customers.CustomersExample;
import com.datangedu.cn.model.serviceprovider.Serviceprovider;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;
import com.datangedu.cn.model.serviceprovider.ServiceproviderWithBLOBs;

@Service
public class ServiceFindServletIMPL implements ServiceFindServlet {

	@Resource
	ServiceproviderMapper serviceproviderMapper; 

	@Override
	public int serviceFind(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MD5 md5 = new MD5();
		ServiceproviderWithBLOBs serviceproviderWithBLOBs = new ServiceproviderWithBLOBs();
		serviceproviderWithBLOBs.setServProviderPassword(md5.EncoderByMd5(request.getParameter("newpassword")));
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria criteria = serviceproviderExample.createCriteria();
		criteria.andServProviderPhoneEqualTo(request.getParameter("phone"));
		return serviceproviderMapper.updateByExampleSelective(serviceproviderWithBLOBs, serviceproviderExample);
		

		
	}

	public boolean findphone(HttpServletRequest request) {
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria criteria = serviceproviderExample.createCriteria();
		criteria.andServProviderPhoneEqualTo(request.getParameter("phone"));
		Long status = serviceproviderMapper.countByExample(serviceproviderExample);
		System.out.println("findphoone-status" + status);
		if (status != 0) {
			return true;
		} else {
			return false;
		}
	}
}


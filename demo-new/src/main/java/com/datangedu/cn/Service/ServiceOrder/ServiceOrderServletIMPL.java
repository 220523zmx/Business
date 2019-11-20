package com.datangedu.cn.Service.ServiceOrder;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.DefaultEditorKit.CutAction;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.AllorderMapper;
import com.datangedu.cn.dao.mapper.CustomersMapper;
import com.datangedu.cn.dao.mapper.ServiceproviderMapper;
import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.customers.CustomersExample;
import com.datangedu.cn.model.order.Allorder;
import com.datangedu.cn.model.order.AllorderExample;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;

@Service
public class ServiceOrderServletIMPL implements ServiceOrderServlet {
	@Resource
	AllorderMapper allorderMapper;
	@Resource
	ServiceproviderMapper ServiceproviderMapper;
	@Resource
	CustomersMapper customersMapper;

	@Override
	public long countorder(String serid,String likename,int finish) {
		String sername = findprovidername(serid);
		System.out.println(sername);
		Allorder allorder = new Allorder();
		AllorderExample allorderExample = new AllorderExample();
		AllorderExample.Criteria criteria = allorderExample.createCriteria();
		allorder.setFinish(finish);
		allorder.setLikename(likename);
		allorder.setSername(sername);
		long i = allorderMapper.countBylikenameExample(allorder);
		System.out.println(i);
		if (((i % allorderExample.getPagesize()) != 0) & (i / allorderExample.getPagesize() != 0)) {
			if (i % allorderExample.getPagesize() != 0) {
				i = (i / allorderExample.getPagesize()) + 1;
				return i;
			} else {
				i = (i / allorderExample.getPagesize());
				return i;

			}
		} else {
			i = 0;
			return i;
		}

	}

	public String findprovidername(String providerid) {
		ServiceproviderExample serviceproviderExample = new ServiceproviderExample();
		ServiceproviderExample.Criteria criteria = serviceproviderExample.createCriteria();
		criteria.andServProviderIdEqualTo(providerid);
		return ServiceproviderMapper.selectByExample(serviceproviderExample).get(0).getServProviderName();
	}

	@Override
	public List<Allorder> topage(HttpServletRequest request) {// 跳转页
		
		String sername = findprovidername(request.getParameter("serid"));
		System.out.println("123");
		String likename = request.getParameter("likename");
		String nowpage = request.getParameter("nowpage");
		String finish = request.getParameter("finish");
		
		AllorderExample allorderExample = new AllorderExample();
		AllorderExample.Criteria criteria = allorderExample.createCriteria();
		System.out.println(sername+"---"+finish+"--"+allorderExample.getLikename());
		
		allorderExample.setNowpage(Integer.parseInt(nowpage));
		allorderExample.setFinish(Integer.parseInt(finish));
		allorderExample.setSername(sername);
		allorderExample.setLikename("");
		
		return allorderMapper.selectAllorderbyServiceid(allorderExample);

	}

	public String findcustomerphone(String customername) {// 数据渲染用的顾客电话
		CustomersExample customersExample = new CustomersExample();
		CustomersExample.Criteria criteria = customersExample.createCriteria();
		criteria.andCustNameEqualTo(customername);
		return customersMapper.selectByExample(customersExample).get(0).getCustPhone();

	}

}

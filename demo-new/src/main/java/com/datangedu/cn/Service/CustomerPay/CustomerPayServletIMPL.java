package com.datangedu.cn.Service.CustomerPay;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.AllorderMapper;
import com.datangedu.cn.model.order.Allorder;
import com.datangedu.cn.model.order.AllorderExample;

@Service
public class CustomerPayServletIMPL implements CustomerPayServlet {

	@Resource
	AllorderMapper allorderMapper;
	public List<Allorder> findorder(HttpServletRequest request)
	{
		AllorderExample allorderExample = new AllorderExample();
		AllorderExample.Criteria criteria= allorderExample.createCriteria();
		criteria.andOrdeCustomeridEqualTo(request.getParameter("id"));
		criteria.andOrdeIdEqualTo(request.getParameter("orid"));
		return allorderMapper.selectByExample(allorderExample);
		
	}
	public int updatepayway(HttpServletRequest request)
	{
		Allorder allorder = new Allorder();
		allorder.setOrdePayway(Integer.parseInt(request.getParameter("payway")));
		AllorderExample allorderExample = new AllorderExample();
		AllorderExample.Criteria criteria= allorderExample.createCriteria();
		criteria.andOrdeIdEqualTo(request.getParameter("orid"));
		return allorderMapper.updateByExampleSelective(allorder, allorderExample);
	}
	public int updatestate(HttpServletRequest request) {
		Allorder allorder = new Allorder();
		allorder.setOrdeState(1);
		AllorderExample allorderExample = new AllorderExample();
		AllorderExample.Criteria criteria= allorderExample.createCriteria();
		criteria.andOrdeIdEqualTo(request.getParameter("orid"));
		return allorderMapper.updateByExampleSelective(allorder, allorderExample);
	}
}

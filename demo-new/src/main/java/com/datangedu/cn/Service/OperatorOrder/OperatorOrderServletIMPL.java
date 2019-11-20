package com.datangedu.cn.Service.OperatorOrder;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.AllorderMapper;
import com.datangedu.cn.model.order.Allorder;
import com.datangedu.cn.model.order.AllorderExample;



@Service
public class OperatorOrderServletIMPL implements OperatorOrderServlet{

	@Resource
	AllorderMapper allorderMapper;
	

	@Override
	public int setOrderDelete(HttpServletRequest request) {
        String id = request.getParameter("orderId");
		
        AllorderExample allorderExample = new AllorderExample();
        AllorderExample.Criteria criteria = allorderExample.createCriteria();
  	    criteria.andOrdeIdEqualTo(id);
  	    
		return allorderMapper.deleteByExample(allorderExample);
	}

	@Override
	public List<Allorder> getOrderInfoByld(String orderId) {
		// TODO Auto-generated method stub
		
		System.out.println("查询订单ID== "+ orderId);
		
		//调用查询方法
		AllorderExample allorderExample = new AllorderExample();
		AllorderExample.Criteria criteria = allorderExample.createCriteria();
		
		

		
		allorderExample.setNowpage(1);
		allorderExample.setPagesize(6);
		allorderExample.setLikeId(orderId);
		
		return allorderMapper.selectBylike(allorderExample);

	}
	
	
}

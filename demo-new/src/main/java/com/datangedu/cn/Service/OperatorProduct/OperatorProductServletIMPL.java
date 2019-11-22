package com.datangedu.cn.Service.OperatorProduct;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.ServiceproductMapper;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;
import com.datangedu.cn.model.serviceproduct.ServiceproductExample;

@Service
public class OperatorProductServletIMPL implements OperatorProductServlet {
	@Resource
	ServiceproductMapper serviceproductMapper;
	public List<Serviceproduct> findbylikename(String likename,String orderby)
	{
		System.out.println("\""+likename+"\""+" "+"\""+orderby+"\"");
		return serviceproductMapper.findbylikename(likename, orderby);
	}
	@Override
	public int stateup(String pcid) {
		Serviceproduct serviceproduct= new Serviceproduct();
		serviceproduct.setServState(1);
		ServiceproductExample serviceproductExample = new ServiceproductExample();
		ServiceproductExample.Criteria criteria= serviceproductExample.createCriteria();
		criteria.andServProductidEqualTo(pcid);
		return serviceproductMapper.updateByExampleSelective(serviceproduct, serviceproductExample);
	}
	@Override
	public int statedown(String pcid) {
		Serviceproduct serviceproduct= new Serviceproduct();
		serviceproduct.setServState(0);
		ServiceproductExample serviceproductExample = new ServiceproductExample();
		ServiceproductExample.Criteria criteria= serviceproductExample.createCriteria();
		criteria.andServProductidEqualTo(pcid);
		return serviceproductMapper.updateByExampleSelective(serviceproduct, serviceproductExample);
	}
	@Override
	public int productdelect(String pcid) {
	
		return serviceproductMapper.deleteByPrimaryKey(pcid);
	}
}

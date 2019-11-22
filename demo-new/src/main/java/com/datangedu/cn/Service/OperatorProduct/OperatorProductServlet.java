package com.datangedu.cn.Service.OperatorProduct;

import java.util.List;

import com.datangedu.cn.model.serviceproduct.Serviceproduct;

public interface OperatorProductServlet {
	public List<Serviceproduct> findbylikename(String likename, String orderby);

	public int stateup(String pcid);

	public int statedown(String pcid);

	public int productdelect(String pcid);

}

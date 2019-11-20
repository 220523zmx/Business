package com.datangedu.cn.Service.ServiceProduct;

import java.util.List;

import com.datangedu.cn.model.serviceproduct.Serviceproduct;

public interface ServiceProductServlet {
	public int insertproduct(Serviceproduct product);

	public String findsername(String serid);

	public List<Serviceproduct> productshow(String serid);
	public int prodelete(String pvid,String pcid);
	public int stateup(String pvid,String pcid);
	public int statedown(String pvid,String pcid);
	public List<Serviceproduct> productnamelike(String namelike,String pvid);
}

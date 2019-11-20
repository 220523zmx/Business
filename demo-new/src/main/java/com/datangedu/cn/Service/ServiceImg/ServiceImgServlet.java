package com.datangedu.cn.Service.ServiceImg;

import com.datangedu.cn.model.serviceproduct.Serviceproduct;
import com.datangedu.cn.model.serviceprovider.ServiceproviderWithBLOBs;

public interface ServiceImgServlet {

	

	public void saveStoreImg(ServiceproviderWithBLOBs service)throws Exception;

	public void saveServImg(ServiceproviderWithBLOBs service)throws Exception;

	public ServiceproviderWithBLOBs getServiceLine(String pvid);
	
	public int findbypcid(String pcid);

	

	public void updatebypcid(Serviceproduct serviceproduct,String pcid)throws Exception;

	public void insertbypcid(Serviceproduct serviceproduct)throws Exception; 

}

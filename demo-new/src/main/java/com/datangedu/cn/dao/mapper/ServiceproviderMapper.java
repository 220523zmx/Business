package com.datangedu.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.serviceprovider.Serviceprovider;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;
import com.datangedu.cn.model.serviceprovider.ServiceproviderWithBLOBs;

@Mapper
public interface ServiceproviderMapper {
	long countByExample(ServiceproviderExample example);

	int deleteByExample(ServiceproviderExample example);

	int deleteByPrimaryKey(String servProviderId);

	int insert(ServiceproviderWithBLOBs record);

	int insertSelective(ServiceproviderWithBLOBs record);

	List<ServiceproviderWithBLOBs> selectByExampleWithBLOBs(ServiceproviderExample example);

	List<Serviceprovider> selectByExample(ServiceproviderExample example);
	
	List<Serviceprovider> selectByExampleO(ServiceproviderExample example);
	List<Serviceprovider> selectByExampleOall(ServiceproviderExample example);
	
	
	
	
	

	ServiceproviderWithBLOBs selectByPrimaryKey(String servProviderId);

	int updateByExampleSelective(@Param("record") ServiceproviderWithBLOBs record,
			@Param("example") ServiceproviderExample example);

	int updateByExampleWithBLOBs(@Param("record") ServiceproviderWithBLOBs record,
			@Param("example") ServiceproviderExample example);

	int updateByExample(@Param("record") Serviceprovider record, @Param("example") ServiceproviderExample example);

	int updateByPrimaryKeySelective(ServiceproviderWithBLOBs record);

	int updateByPrimaryKeyWithBLOBs(ServiceproviderWithBLOBs record);

	int updateByPrimaryKey(Serviceprovider record);

	int savePvImg(ServiceproviderWithBLOBs record);

	int saveStImg(ServiceproviderWithBLOBs record);
}
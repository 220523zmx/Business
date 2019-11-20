package com.datangedu.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.datangedu.cn.model.customers.Customers;
import com.datangedu.cn.model.customers.CustomersExample;

@Mapper
public interface CustomersMapper {
	long countByExample(CustomersExample example);

	int deleteByExample(CustomersExample example);

	int deleteByPrimaryKey(String custId);

	int insert(Customers record);

	int insertSelective(Customers record);

	List<Customers> selectByExampleWithBLOBs(CustomersExample example);

	List<Customers> selectByExample(CustomersExample example);

	Customers selectByPrimaryKey(String custId);

	int updateByExampleSelective(@Param("record") Customers record, @Param("example") CustomersExample example);

	int updateByExampleWithBLOBs(@Param("record") Customers record, @Param("example") CustomersExample example);

	int updateByExample(@Param("record") Customers record, @Param("example") CustomersExample example);

	int updateByPrimaryKeySelective(Customers record);

	int updateByPrimaryKeyWithBLOBs(Customers record);

	int updateByPrimaryKey(Customers record);

	int saveCuImg(Customers record);
}
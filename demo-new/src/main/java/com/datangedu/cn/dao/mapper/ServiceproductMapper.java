package com.datangedu.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.datangedu.cn.model.serviceproduct.Serviceproduct;
import com.datangedu.cn.model.serviceproduct.ServiceproductExample;

@Mapper
public interface ServiceproductMapper {
	long countByExample(ServiceproductExample example);

	int deleteByExample(ServiceproductExample example);

	int deleteByPrimaryKey(String servProductid);

	int insert(Serviceproduct record);

	int insertSelective(Serviceproduct record);

	List<Serviceproduct> selectByExampleWithBLOBs(ServiceproductExample example);

	List<Serviceproduct> selectByExample(ServiceproductExample example);

	Serviceproduct selectByPrimaryKey(String servProductid);

	int updateByExampleSelective(@Param("record") Serviceproduct record,
			@Param("example") ServiceproductExample example);

	int updateByExampleWithBLOBs(@Param("record") Serviceproduct record,
			@Param("example") ServiceproductExample example);

	int updateByExample(@Param("record") Serviceproduct record, @Param("example") ServiceproductExample example);

	int updateByPrimaryKeySelective(Serviceproduct record);

	int updateByPrimaryKeyWithBLOBs(Serviceproduct record);

	int updateByPrimaryKey(Serviceproduct record);

	List<Serviceproduct> selectBypcname(String str);

	List<Serviceproduct> selectBypvname(String str);

	List<Serviceproduct> findproductnamelike(String namelike, String pvid);

	List<Serviceproduct> findbylikename(String likename, String state);

	long countBylikenameandorder(String likename);

	List<Serviceproduct> selectbynamenporderbytime(Serviceproduct record);

	List<Serviceproduct> selectbynamenporderbynum(Serviceproduct record);

	List<Serviceproduct> selectbynamenporderbyprice(Serviceproduct record);

}
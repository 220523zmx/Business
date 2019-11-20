package com.datangedu.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.datangedu.cn.model.administrator.Administrator;
import com.datangedu.cn.model.administrator.AdministratorExample;
@Mapper
public interface AdministratorMapper {
    long countByExample(AdministratorExample example);

    int deleteByExample(AdministratorExample example);

    int deleteByPrimaryKey(String admiId);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    List<Administrator> selectByExampleWithBLOBs(AdministratorExample example);

    List<Administrator> selectByExample(AdministratorExample example);

    Administrator selectByPrimaryKey(String admiId);

    int updateByExampleSelective(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByExampleWithBLOBs(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByExample(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKeyWithBLOBs(Administrator record);

    int updateByPrimaryKey(Administrator record);
    
    List<Administrator> selectBylike(AdministratorExample example);


    
    
}
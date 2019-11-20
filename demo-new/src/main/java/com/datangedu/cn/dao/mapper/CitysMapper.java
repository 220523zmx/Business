package com.datangedu.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.datangedu.cn.model.city.Citys;
import com.datangedu.cn.model.city.CitysExample;
@Mapper
public interface CitysMapper {
    long countByExample(CitysExample example);

    int deleteByExample(CitysExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Citys record);

    int insertSelective(Citys record);

    List<Citys> selectByExample(CitysExample example);

    Citys selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Citys record, @Param("example") CitysExample example);

    int updateByExample(@Param("record") Citys record, @Param("example") CitysExample example);

    int updateByPrimaryKeySelective(Citys record);

    int updateByPrimaryKey(Citys record);
}
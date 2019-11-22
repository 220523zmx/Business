package com.datangedu.cn.dao.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.datangedu.cn.model.order.Allorder;
import com.datangedu.cn.model.order.AllorderExample;

@Mapper
public interface AllorderMapper {
	long countByExample(AllorderExample example);

	int deleteByExample(AllorderExample example);

	int insert(Allorder record);

	int insertSelective(Allorder record);

	List<Allorder> selectByExample(AllorderExample example);
	
	List<Allorder> selectByExampleA(AllorderExample example);
	List<Allorder> selectByExampleNum(AllorderExample example);

	int updateByExampleSelective(@Param("record") Allorder record, @Param("example") AllorderExample example);

	int updateByExample(@Param("record") Allorder record, @Param("example") AllorderExample example);

	List<Allorder> selectByoridlike(String orid, String cuid);

	List<Allorder> selectAllorderbyServiceid(AllorderExample example);

	long countBylikenameExample(Allorder record);
	
	List<Allorder> selectBylike(AllorderExample allorderExample);

}
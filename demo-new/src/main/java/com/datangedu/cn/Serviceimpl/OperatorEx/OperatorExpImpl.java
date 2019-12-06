package com.datangedu.cn.Serviceimpl.OperatorEx;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.Service.OperatorEx.OperatorExp;
import com.datangedu.cn.dao.mapper.AllorderMapper;
import com.datangedu.cn.model.order.Allorder;
import com.datangedu.cn.model.order.AllorderExample;

@Service
public class OperatorExpImpl implements OperatorExp {
	@Resource
	AllorderMapper allorderMapper;
	@Resource
	AllorderExample example;

	@Override
	public List<Allorder> getExpSelDate(HttpServletRequest request) {
		// TODO Auto-generated method stub

		Calendar c = Calendar.getInstance();// 可以对每个时间域单独修改

		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int date = c.get(Calendar.DATE);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		System.out.println("余数"+date%7);
		System.out.println(year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second);
		int montha = month - 1;
		int datea = date - 1;
	
			int datese = date - 7;
		
				
			
			
			
			
		System.out.println("date"+date);
		example.setPageSizes(Integer.parseInt(request.getParameter("pagesize")));
		example.setPageNums(Integer.parseInt(request.getParameter("pagenum")));
		String data=year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
		System.out.println(Integer.parseInt(request.getParameter("time"))==0);
		if(Integer.parseInt(request.getParameter("time"))==0) {
	  //今天的
	  example.setId(0);
	  String dataa=year + "-" + month + "-" + datea+ " " + hour + ":" + minute + ":" + second;
	  example.setDataa(dataa);
	  example.setData(data);
	  System.out.println(example.getPageSizes()+"==="+example.getPageNums());
	  return allorderMapper.selectByExampleA(example);
	  
	  
  }else {
	  if(Integer.parseInt(request.getParameter("time"))==1) {
		  //近7天的
		  if(date<8) {
			    datese=31-7+date;
			    System.out.println("datese"+datese);
			    String dataa=year + "-" + montha + "-" + datese + " " + hour + ":" + minute + ":" + second;
			    System.out.println("近7天dataa"+dataa);
			    example.setId(1);
				  example.setDataa(dataa);
			    
			}else {
					datese = date - 7;
					  String dataa=year + "-" + month + "-" + datese + " " + hour + ":" + minute + ":" + second;
					  System.out.println("近7天dataa"+dataa);
					  example.setId(1);
					  example.setDataa(dataa);
			}
		  
		  
		  
		  
	  
	  int datee = c.get(Calendar.DATE)+1;
	  String dataaa=year + "-" + month + "-" + datee + " " + 00 + ":" + 00 + ":" + 00;
	  System.out.println("近7天dataaa"+dataaa);
	  example.setData(dataaa);
	 // example.setPageSizes(1);
	  System.out.println("近7天的數"+allorderMapper.selectByExampleA(example).size());
	
	  
	  
	  
	  return allorderMapper.selectByExampleA(example);
	  }
	  else {
		  if(Integer.parseInt(request.getParameter("time"))==2) {
			  //全部
			  example.setId(2);
			  System.out.println("全部"+allorderMapper.selectByExampleA(example).size());
			  return allorderMapper.selectByExampleA(example);
			  
		  }
		  else {
		  //近一个月的
		  String dataa=year + "-" + montha + "-" + date + " " + hour + ":" + minute + ":" + second;
		  example.setId(2);
		  example.setDataa(dataa);
		  example.setData(data);
		  System.out.println("近一个月的"+allorderMapper.selectByExampleA(example).size());
		  return allorderMapper.selectByExampleA(example);	}	  
	  }	  	  
  }															
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<Allorder> getExpSelnum(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();// 可以对每个时间域单独修改

		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int date = c.get(Calendar.DATE);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		System.out.println(year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second);
		int montha = month - 1;
		int datea = date - 1;
		int datese = date - 7;
		example.setPageSizes(Integer.parseInt(request.getParameter("pagesize")));
		example.setPageNums(Integer.parseInt(request.getParameter("pagenum")));
		String data=year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
		System.out.println(Integer.parseInt(request.getParameter("time"))==0);
		if(Integer.parseInt(request.getParameter("time"))==0) {
	  //今天的
	  example.setId(1);
	  String dataa=year + "-" + month + "-" + datea+ " " + hour + ":" + minute + ":" + second;
	  example.setDataa(dataa);
	  example.setData(data);
	  System.out.println(example.getPageSizes()+"==="+example.getPageNums());
	  return allorderMapper.selectByExampleNum(example);
	  
	  
  }else {
	  if(Integer.parseInt(request.getParameter("time"))==1) {
		  //近7天的
//	  String dataa=year + "-" + month + "-" + datese + " " + hour + ":" + minute + ":" + second;
//	  System.out.println("wi"+dataa);
//	  example.setId(1);
//	  example.setDataa(dataa);
//	  example.setData(data);
//	 // example.setPageSizes(1);
//	  System.out.println("nide"+allorderMapper.selectByExampleA(example).size());
//	  System.out.println(example.getPageSizes()+"--"+example.getPageNums());
		  if(date<8) {
			    datese=31-7+date;
			    System.out.println("datese"+datese);
			    String dataa=year + "-" + montha + "-" + datese + " " + hour + ":" + minute + ":" + second;
			    System.out.println("近7天dataa"+dataa);
			    example.setId(1);
				  example.setDataa(dataa);
			    
			}else {
					datese = date - 7;
					  String dataa=year + "-" + month + "-" + datese + " " + hour + ":" + minute + ":" + second;
					  System.out.println("近7天dataa"+dataa);
					  example.setId(1);
					  example.setDataa(dataa);
			}
		  
		  
		  
		  
	  
	  int datee = c.get(Calendar.DATE)+1;
	  String dataaa=year + "-" + month + "-" + datee + " " + 00 + ":" + 00 + ":" + 00;
	  System.out.println("近7天dataaa"+dataaa);
	  example.setData(dataaa);
	  return allorderMapper.selectByExampleNum(example);
	  }
	  else {
		  
		  if(Integer.parseInt(request.getParameter("time"))==2) {
			  //全部
			  example.setId(3);
			  return allorderMapper.selectByExampleNum(example);
			  
		  }else {
		  //近一个月的
		  String dataa=year + "-" + montha + "-" + date + " " + hour + ":" + minute + ":" + second;
		  example.setId(1);
		  example.setDataa(dataa);
		  example.setData(data);
		  System.out.println("近一個月"+allorderMapper.selectByExampleNum(example).size());
		  return allorderMapper.selectByExampleNum(example);
		  
	  }	}  	  
  }														
}}

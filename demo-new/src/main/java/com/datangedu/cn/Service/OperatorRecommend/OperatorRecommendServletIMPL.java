package com.datangedu.cn.Service.OperatorRecommend;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.ServiceproductMapper;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;

@Service
public class OperatorRecommendServletIMPL implements OperatorRecommendServlet {
	@Resource
	ServiceproductMapper serviceproductMapper;

	public long countorder(String likename) {
		Serviceproduct serviceproduct = new Serviceproduct();
		int pasize = serviceproduct.getPagesize();
		long i = serviceproductMapper.countBylikenameandorder(likename);
		System.out.println(i);
		System.out.println(pasize);
		if (((i % pasize) != 0) | (i / pasize != 0)) {
			if (i % pasize != 0) {
				i = (i / pasize) + 1;
				return i;
			} else {
				i = (i / pasize);
				return i;

			}
		} else {
			i = 0;
			return i;
		}

	}

	public List<Serviceproduct> topage(HttpServletRequest request) {// 跳转页
		Serviceproduct  serviceproduct  = new Serviceproduct ();
		String likename = request.getParameter("likename");
		int nowpage = Integer.parseInt(request.getParameter("nowpage"));
		int orderby = Integer.parseInt(request.getParameter("orderby"));
		if (orderby == 0 | orderby == 1) {
			if(orderby == 1) {
				serviceproduct.setState(" ASC");
			}else {
				serviceproduct.setState(" DESC");
			}
			serviceproduct.setLikename(likename);
			serviceproduct.setNowpage(nowpage);
			return serviceproductMapper.selectbynamenporderbytime(serviceproduct);
		} else if (orderby == 2 | orderby == 3) {
			if(orderby == 3) {
				serviceproduct.setState(" ASC");
			}else {
				serviceproduct.setState(" DESC");
			}
			serviceproduct.setLikename(likename);
			serviceproduct.setNowpage(nowpage);
			return serviceproductMapper.selectbynamenporderbynum(serviceproduct);
		} else if(orderby == 4 | orderby == 5){
			if(orderby == 5) {
				serviceproduct.setState(" ASC");
			}else {
				serviceproduct.setState(" DESC");
			}
			serviceproduct.setLikename(likename);
			serviceproduct.setNowpage(nowpage);
			return serviceproductMapper.selectbynamenporderbyprice(serviceproduct);
		}
		return null;

	}

}

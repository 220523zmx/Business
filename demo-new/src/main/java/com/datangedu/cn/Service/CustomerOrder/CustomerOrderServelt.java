package com.datangedu.cn.Service.CustomerOrder;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.order.Allorder;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;

public interface CustomerOrderServelt {

	/* public String findPvLine(String ordeProvidername); */

	public List<String> findOrderNo(String cuid);

	public List<Allorder> findOrderByOrderNo(String orid);

	public int removeorderline(HttpServletRequest request);

	public String findpcidbypcname(String str);

	public Serviceproduct findlinebypramarykey(String str);

	public List<String> findByoridlike(String orid, String cuid);

	public List<String> findByoridalltime(Date starttime, Date endtime, String cuid,List<String> list);

	public List<String> findByoridendtime(Date endtime, String cuid,List<String> list);

	public List<String> findByoridstarttime(Date starttime, String cuid,List<String> list);
}

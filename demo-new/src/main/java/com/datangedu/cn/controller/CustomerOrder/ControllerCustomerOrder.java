package com.datangedu.cn.controller.CustomerOrder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.Service.CustomerOrder.CustomerOrderServelt;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;

@Controller
@RequestMapping("/customer")
public class ControllerCustomerOrder {
	@Resource
	CustomerOrderServelt customerOrder;

	@ResponseBody
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public Map<String, Object> customerOrder(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> lists = new ArrayList<String>();
		lists = customerOrder.findOrderNo(request.getParameter("id"));
		map.put("orderid", lists);// 订单id集
		for (int i = 0; i < lists.size(); i++) {
			map.put(lists.get(i), customerOrder.findOrderByOrderNo(lists.get(i)));

		}

		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/deletepc", method = RequestMethod.POST)
	public Map<String, Object> removeorderline(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int a = customerOrder.removeorderline(request);
		System.out.println(a);
		if (a != 0) {
			map.put("status", "删除成功");
		} else {
			map.put("status", "删除失败");
		}

		return map;

	}

	@RequestMapping(value = "/ordimgshow", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg(HttpServletRequest request) throws Exception {

		byte[] imageContent;
		// 根据id获取当前用户的信息
		System.out.println(request.getParameter("pcname"));
		String str = customerOrder.findpcidbypcname(request.getParameter("pcname"));
		Serviceproduct pc = customerOrder.findlinebypramarykey(str);
		imageContent = pc.getServProductimg();
		System.out.println("图片===" + pc.getServProductimg());

		// 设置http头部信息
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		// 返回响应实体
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/ord_like", method = RequestMethod.POST)
	public Map<String, Object> findByoridlike(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> list = new ArrayList<String>();
		list = customerOrder.findByoridlike(request.getParameter("orid"), request.getParameter("cuid"));
		String start = request.getParameter("starttime");
		System.out.println(start);
		String end = request.getParameter("endtime");
		System.out.println(end);
		if (request.getParameter("starttime").equals("") == true
				& request.getParameter("endtime").equals("") == false) {
			List<String> lists = new ArrayList<String>();
			Date endtime = new Date(end);
			System.err.println(endtime);
			lists = customerOrder.findByoridendtime(endtime, request.getParameter("cuid"), list);
			if (lists!=null&&lists.size()!=0) {
				map.put("orderid", lists);// 订单id集
				for (int i = 0; i < lists.size(); i++) {
					map.put(lists.get(i), customerOrder.findOrderByOrderNo(lists.get(i)));

				}
				map.put("state", 1);
			} else {
				map.put("state", 0);
				map.put("status", "未搜索到结果，请刷新");
			}
		} else if (request.getParameter("endtime").equals("") == true
				& request.getParameter("starttime").equals("") == false) {
			List<String> lists = new ArrayList<String>();
			Date starttime = new Date(start);
			System.out.println(starttime);
			lists = customerOrder.findByoridstarttime(starttime, request.getParameter("cuid"), list);
			if (lists!=null||lists.size() != 0) {
				map.put("orderid", lists);// 订单id集
				for (int i = 0; i < lists.size(); i++) {
					map.put(lists.get(i), customerOrder.findOrderByOrderNo(lists.get(i)));
					System.out.println(customerOrder.findOrderByOrderNo(lists.get(i)).get(0).getOrdeStarttime());
				}
				map.put("state", 1);
			} else {
				map.put("state", 0);
				map.put("status", "未搜索到结果，请刷新");
			}
		} else if (request.getParameter("endtime").equals("") == false
				& request.getParameter("starttime").equals("") == false) {
			List<String> lists = new ArrayList<String>();
			Date starttime = new Date(start);
			System.out.println(starttime);
			Date endtime = new Date(end);
			System.err.println(endtime);
			lists = customerOrder.findByoridalltime(starttime, endtime, request.getParameter("cuid"), list);
			if (lists!=null&&lists.size()!=0) {
				map.put("orderid", lists);// 订单id集
				for (int i = 0; i < lists.size(); i++) {
					map.put(lists.get(i), customerOrder.findOrderByOrderNo(lists.get(i)));
				}
				map.put("state", 1);
			} else {
				map.put("state", 0);
				map.put("status", "未搜索到结果，请刷新");
			}
		} else {
			if (list!=null&&list.size()!=0) {
				map.put("orderid", list);// 订单id集
				for (int i = 0; i < list.size(); i++) {
					map.put(list.get(i), customerOrder.findOrderByOrderNo(list.get(i)));
				}
			} else {
				map.put("state", 0);
				map.put("status", "未搜索到结果，请刷新");
			}
		}
		return map;
	}

	
	
	@ResponseBody
	@RequestMapping(value = "/ord_time", method = RequestMethod.POST)
	public Map<String, Object> findBytime(HttpServletRequest request) throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();

		String start = request.getParameter("starttime");
		System.out.println(start);
		String end = request.getParameter("endtime");
		System.out.println(end);

		if (request.getParameter("starttime").equals("") == true
				& request.getParameter("endtime").equals("") == false) {
			List<String> lists = new ArrayList<String>();
			Date endtime = new Date(end);
			System.err.println(endtime);
			lists = customerOrder.findByoridendtime(endtime, request.getParameter("cuid"), null);
			if (lists!=null&&lists.size()!=0) {
				map.put("orderid", lists);// 订单id集
				for (int i = 0; i < lists.size(); i++) {
					map.put(lists.get(i), customerOrder.findOrderByOrderNo(lists.get(i)));

				}
				map.put("state", 1);
			} else {
				map.put("state", 0);
				map.put("status", "未搜索到结果，请刷新");
			}
		} else if (request.getParameter("endtime").equals("") == true
				& request.getParameter("starttime").equals("") == false) {
			List<String> lists = new ArrayList<String>();
			Date starttime = new Date(start);
			System.out.println(starttime);
			lists = customerOrder.findByoridstarttime(starttime, request.getParameter("cuid"), null);

			if (lists!=null&&lists.size()!=0) {
				map.put("orderid", lists);// 订单id集
				for (int i = 0; i < lists.size(); i++) {
					map.put(lists.get(i), customerOrder.findOrderByOrderNo(lists.get(i)));
					System.out.println(customerOrder.findOrderByOrderNo(lists.get(i)).get(0).getOrdeStarttime());
				}
				map.put("state", 1);
			} else {
				map.put("state", 0);
				map.put("status", "未搜索到结果，请刷新");
			}
		} else {
			List<String> lists = new ArrayList<String>();
			Date starttime = new Date(start);
			System.out.println(starttime);
			Date endtime = new Date(end);
			System.err.println(endtime);
			lists = customerOrder.findByoridalltime(starttime, endtime, request.getParameter("cuid"), null);

			if (lists!=null&&lists.size()!=0) {
				map.put("orderid", lists);// 订单id集
				for (int i = 0; i < lists.size(); i++) {
					map.put(lists.get(i), customerOrder.findOrderByOrderNo(lists.get(i)));
				}
				map.put("state", 1);
			} else {
				map.put("state", 0);
				map.put("status", "未搜索到结果，请刷新");
			}
		}
		return map;
	}
}

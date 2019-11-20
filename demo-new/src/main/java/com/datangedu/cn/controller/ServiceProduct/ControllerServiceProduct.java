package com.datangedu.cn.controller.ServiceProduct;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.datangedu.cn.Random.ServletRandomIMPL;
import com.datangedu.cn.Service.ServiceProduct.ServiceProductServlet;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;

@Controller
@RequestMapping(value = "/service")
public class ControllerServiceProduct {
	@Resource
	ServiceProductServlet serviceProductServlet;
	
	
	@RequestMapping("/saveProductImg")
	public String saveStorImg(MultipartFile file, String serid,String pcname,String pcintp,String pcprice) {
		ServletRandomIMPL  ran= new ServletRandomIMPL();
		Date date = new Date();
		System.out.println("执照" + file);
		System.out.println(serid);
		System.out.println(pcname);
		System.out.println(pcintp);
		System.out.println(pcprice);
		Map<Object, Object> result = new HashMap<Object, Object>();
		try { // 获取客户端传图图片的输入流
			InputStream ins = file.getInputStream();
			byte[] buffer = new byte[1024];// bit---byte---1k---1m
			int len = 0;// 字节输出流
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			while ((len = ins.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
			bos.flush();
			byte data[] = bos.toByteArray(); // 调用接口对图片进行存储
			Serviceproduct serviceproduct = new Serviceproduct();
			  serviceproduct.setServProductid(ran.getRandomNo(12));
			  serviceproduct.setServProviderid(serid);
			  serviceproduct.setServPrice(Integer.parseInt(pcprice));
			  serviceproduct.setServInstructions(pcintp);
			  serviceproduct.setServProductname(pcname);
			  serviceproduct.setServProductimg(data);
			  serviceproduct.setServProvidername(serviceProductServlet.findsername(serid));
			  serviceproduct.setServBumber(0);
			  serviceproduct.setServState(1);
			  serviceproduct.setServStarttime(date);
			  serviceProductServlet.insertproduct(serviceproduct);
			  
			result.put("code", 1);
			result.put("msg", "添加商品成功");
		} catch (Exception e) {
			result.put("code", 0);
			result.put("msg", "保存头像失败");
			return "uploaderror";
		}
		return "service_product";
	}
	@ResponseBody
	@RequestMapping(value = "/prodctshow",method = RequestMethod.GET)
	public Map<String ,Object> prodctshow(HttpServletRequest reques){
		Map<String, Object> map = new HashMap<String, Object>();
		String serid = reques.getParameter("serid");
		System.out.println(serid);
		List<Serviceproduct> list = serviceProductServlet.productshow(serid);
		System.out.println(list.size());
		map.put("productlist", list);
		
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/prodelete",method = RequestMethod.POST)
	public Map<String ,Object> prodelete(HttpServletRequest reques){
		Map<String, Object> map = new HashMap<String, Object>();
		int i = serviceProductServlet.prodelete(reques.getParameter("pvid"), reques.getParameter("pcid"));
		if(i==1)
		{
			map.put("code", 1);
			map.put("state", "删除成功");
		}else {
			map.put("code", 0);
			map.put("state", "删除失败");
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/stateup",method = RequestMethod.POST)
	public Map<String ,Object> stateup(HttpServletRequest reques){
		Map<String, Object> map = new HashMap<String, Object>();;
		int i = serviceProductServlet.stateup(reques.getParameter("pvid"), reques.getParameter("pcid"));
		if(i==1)
		{
			map.put("code", 1);
			map.put("state", "上线成功");
		}else {
			map.put("code", 0);
			map.put("state", "上线失败");
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/statedown",method = RequestMethod.POST)
	public Map<String ,Object> statedown(HttpServletRequest reques){
		Map<String, Object> map = new HashMap<String, Object>();
		int i = serviceProductServlet.statedown(reques.getParameter("pvid"), reques.getParameter("pcid"));
		if(i==1)
		{
			map.put("code", 1);
			map.put("state", "下线成功");
		}else {
			map.put("code", 0);
			map.put("state", "下线失败");
		}
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/productnamelike",method = RequestMethod.POST)
	public Map<String ,Object> productnamelike(HttpServletRequest reques){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Serviceproduct> list = serviceProductServlet.productnamelike(reques.getParameter("namelike"),reques.getParameter("pvid"));
		
		System.out.println(list.size());
		if(list.size()>=0)
		{
			map.put("code", 1);
			map.put("state", "查询成功");
			map.put("productlist", list);
		}else {
			map.put("code", 0);
			map.put("state", "未搜索的到关键字，请刷新");
		}
		return map;
	}
}

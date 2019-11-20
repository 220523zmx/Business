package com.datangedu.cn.Service.CustomerProduct;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.cart.Cart;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;

public interface CustomerProductServelt {

	public List<Serviceproduct> findProduct(HttpServletRequest request);

	public List<Serviceproduct> priceEsc(HttpServletRequest request);

	public List<Serviceproduct> priceDesc(HttpServletRequest request);

	public List<Serviceproduct> numberDesc(HttpServletRequest request);

	public int addCart(HttpServletRequest request);

	public int updateNum(HttpServletRequest request);

	public List<Cart> findCartline(HttpServletRequest request);

	public int insertOrderFromProc(HttpServletRequest request, String str, Date datetime);

	public Serviceproduct findlinebypramarykey(String str);

	public List<Serviceproduct> findlike(String brabch, String str);
}

package com.datangedu.cn.Service.CustomerCar;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.cart.Cart;
import com.datangedu.cn.model.cart.CartExample;
import com.datangedu.cn.model.serviceproduct.Serviceproduct;
import com.datangedu.cn.model.serviceproduct.ServiceproductExample;
import com.datangedu.cn.model.serviceprovider.ServiceproviderExample;

public interface CustomerCarServlet {
	public List<Cart> findListByCuId(HttpServletRequest request);// cart list

	public List<String> findPcIdListByPvId(String providerid);// cart list

	public String getPvNameDistinct(String providerid);// provider name list

	public List<String> getPvIdDistinct(List<Cart> listCart);// provider id list

	public List<String> getPvNameDistinct(List<String> idlist);// provider name list

	public List<String> getPcNameDistinct(List<String> idlist);// provider name list

	public String getPcNameDistinct(String productid);// provider name list

	public List<Cart> findPclineByPcId(String productid);// cart list

	public int updateCustomerCartNum(HttpServletRequest request);

	public int deleteCartline(HttpServletRequest request);

	public int insertOrderFromCart(Cart cart, String str, Date datetime);

	public String getCuNameDistinct(String customerid);// provider name list

	public int deCartByCuid(HttpServletRequest request);

	public Serviceproduct findlinebypramarykey(String str) ;

}

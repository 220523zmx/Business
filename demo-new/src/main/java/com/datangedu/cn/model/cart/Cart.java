package com.datangedu.cn.model.cart;

public class Cart {
	private String cartCustomerid;

    private String cartProviderid;

    private String cartProductid;

    private Integer cartPrice;

    private Integer cartNumber;

    private Integer cartAprice;

    public String getCartCustomerid() {
        return cartCustomerid;
    }

    public void setCartCustomerid(String cartCustomerid) {
        this.cartCustomerid = cartCustomerid == null ? null : cartCustomerid.trim();
    }

    public String getCartProviderid() {
        return cartProviderid;
    }

    public void setCartProviderid(String cartProviderid) {
        this.cartProviderid = cartProviderid == null ? null : cartProviderid.trim();
    }

    public String getCartProductid() {
        return cartProductid;
    }

    public void setCartProductid(String cartProductid) {
        this.cartProductid = cartProductid == null ? null : cartProductid.trim();
    }

    public Integer getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(Integer cartPrice) {
        this.cartPrice = cartPrice;
    }

    public Integer getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(Integer cartNumber) {
        this.cartNumber = cartNumber;
    }

    public Integer getCartAprice() {
        return cartAprice;
    }

    public void setCartAprice(Integer cartAprice) {
        this.cartAprice = cartAprice;
    }
}
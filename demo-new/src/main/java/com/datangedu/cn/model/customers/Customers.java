package com.datangedu.cn.model.customers;

import java.util.Date;

public class Customers {
    private String custId;

    private String custName;

    private String custSex;

    private String custPhone;

    private String custRegion;

    private Date custStarttime;

    private String custEmail;

    private Integer custNumber;

    private Integer custPrice;

    private Integer custState;

    private String custPassword;

    private byte[] custPortrait;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustSex() {
        return custSex;
    }

    public void setCustSex(String custSex) {
        this.custSex = custSex == null ? null : custSex.trim();
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    public String getCustRegion() {
        return custRegion;
    }

    public void setCustRegion(String custRegion) {
        this.custRegion = custRegion == null ? null : custRegion.trim();
    }

    public Date getCustStarttime() {
        return custStarttime;
    }

    public void setCustStarttime(Date custStarttime) {
        this.custStarttime = custStarttime;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail == null ? null : custEmail.trim();
    }

    public Integer getCustNumber() {
        return custNumber;
    }

    public void setCustNumber(Integer custNumber) {
        this.custNumber = custNumber;
    }

    public Integer getCustPrice() {
        return custPrice;
    }

    public void setCustPrice(Integer custPrice) {
        this.custPrice = custPrice;
    }

    public Integer getCustState() {
        return custState;
    }

    public void setCustState(Integer custState) {
        this.custState = custState;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword == null ? null : custPassword.trim();
    }

    public byte[] getCustPortrait() {
        return custPortrait;
    }

    public void setCustPortrait(byte[] custPortrait) {
        this.custPortrait = custPortrait;
    }
}
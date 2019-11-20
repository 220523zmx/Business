package com.datangedu.cn.model.administrator;

import java.util.Date;

public class Administrator {
    private String admiId;

    private String admiPhone;

    private String admiPassword;

    private String admiName;

    private String admiEmail;

    private Integer admiState;

    private Date admiCretime;

    private byte[] admiPortrait;

    public String getAdmiId() {
        return admiId;
    }

    public void setAdmiId(String admiId) {
        this.admiId = admiId == null ? null : admiId.trim();
    }

    public String getAdmiPhone() {
        return admiPhone;
    }

    public void setAdmiPhone(String admiPhone) {
        this.admiPhone = admiPhone == null ? null : admiPhone.trim();
    }

    public String getAdmiPassword() {
        return admiPassword;
    }

    public void setAdmiPassword(String admiPassword) {
        this.admiPassword = admiPassword == null ? null : admiPassword.trim();
    }

    public String getAdmiName() {
        return admiName;
    }

    public void setAdmiName(String admiName) {
        this.admiName = admiName == null ? null : admiName.trim();
    }

    public String getAdmiEmail() {
        return admiEmail;
    }

    public void setAdmiEmail(String admiEmail) {
        this.admiEmail = admiEmail == null ? null : admiEmail.trim();
    }

    public Integer getAdmiState() {
        return admiState;
    }

    public void setAdmiState(Integer admiState) {
        this.admiState = admiState;
    }

    public Date getAdmiCretime() {
        return admiCretime;
    }

    public void setAdmiCretime(Date admiCretime) {
        this.admiCretime = admiCretime;
    }

    public byte[] getAdmiPortrait() {
        return admiPortrait;
    }

    public void setAdmiPortrait(byte[] admiPortrait) {
        this.admiPortrait = admiPortrait;
    }
}
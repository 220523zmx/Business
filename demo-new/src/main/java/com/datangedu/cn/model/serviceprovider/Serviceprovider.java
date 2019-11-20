package com.datangedu.cn.model.serviceprovider;

import java.util.Date;

public class Serviceprovider {
    private String servProviderId;

    private String servProviderName;

    private String servProviderRegion;

    private String servProviderPhone;

    private String servProviderPassword;

    private Integer servProviderState;

    private String servProviderIntroduction;

    private String servProviderEmail;

    private Date servProviderStarttime;

    private String servCompanyIntrduction;

    private String servProviderWorktime;

    private String servProviderQq;

    private String servProviderWeichart;

    private String servProviderCsphone;

    public String getServProviderId() {
        return servProviderId;
    }

    public void setServProviderId(String servProviderId) {
        this.servProviderId = servProviderId == null ? null : servProviderId.trim();
    }

    public String getServProviderName() {
        return servProviderName;
    }

    public void setServProviderName(String servProviderName) {
        this.servProviderName = servProviderName == null ? null : servProviderName.trim();
    }

    public String getServProviderRegion() {
        return servProviderRegion;
    }

    public void setServProviderRegion(String servProviderRegion) {
        this.servProviderRegion = servProviderRegion == null ? null : servProviderRegion.trim();
    }

    public String getServProviderPhone() {
        return servProviderPhone;
    }

    public void setServProviderPhone(String servProviderPhone) {
        this.servProviderPhone = servProviderPhone == null ? null : servProviderPhone.trim();
    }

    public String getServProviderPassword() {
        return servProviderPassword;
    }

    public void setServProviderPassword(String servProviderPassword) {
        this.servProviderPassword = servProviderPassword == null ? null : servProviderPassword.trim();
    }

    public Integer getServProviderState() {
        return servProviderState;
    }

    public void setServProviderState(Integer servProviderState) {
        this.servProviderState = servProviderState;
    }

    public String getServProviderIntroduction() {
        return servProviderIntroduction;
    }

    public void setServProviderIntroduction(String servProviderIntroduction) {
        this.servProviderIntroduction = servProviderIntroduction == null ? null : servProviderIntroduction.trim();
    }

    public String getServProviderEmail() {
        return servProviderEmail;
    }

    public void setServProviderEmail(String servProviderEmail) {
        this.servProviderEmail = servProviderEmail == null ? null : servProviderEmail.trim();
    }

    public Date getServProviderStarttime() {
        return servProviderStarttime;
    }

    public void setServProviderStarttime(Date servProviderStarttime) {
        this.servProviderStarttime = servProviderStarttime;
    }

    public String getServCompanyIntrduction() {
        return servCompanyIntrduction;
    }

    public void setServCompanyIntrduction(String servCompanyIntrduction) {
        this.servCompanyIntrduction = servCompanyIntrduction == null ? null : servCompanyIntrduction.trim();
    }

    public String getServProviderWorktime() {
        return servProviderWorktime;
    }

    public void setServProviderWorktime(String servProviderWorktime) {
        this.servProviderWorktime = servProviderWorktime == null ? null : servProviderWorktime.trim();
    }

    public String getServProviderQq() {
        return servProviderQq;
    }

    public void setServProviderQq(String servProviderQq) {
        this.servProviderQq = servProviderQq == null ? null : servProviderQq.trim();
    }

    public String getServProviderWeichart() {
        return servProviderWeichart;
    }

    public void setServProviderWeichart(String servProviderWeichart) {
        this.servProviderWeichart = servProviderWeichart == null ? null : servProviderWeichart.trim();
    }

    public String getServProviderCsphone() {
        return servProviderCsphone;
    }

    public void setServProviderCsphone(String servProviderCsphone) {
        this.servProviderCsphone = servProviderCsphone == null ? null : servProviderCsphone.trim();
    }
}
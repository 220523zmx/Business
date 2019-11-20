package com.datangedu.cn.model.serviceprovider;

import java.util.Date;

public class ServiceproviderWithBLOBs extends Serviceprovider {
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
	public String getServProviderName() {
		return servProviderName;
	}

	public void setServProviderName(String servProviderName) {
		this.servProviderName = servProviderName;
	}

	public String getServProviderRegion() {
		return servProviderRegion;
	}

	public void setServProviderRegion(String servProviderRegion) {
		this.servProviderRegion = servProviderRegion;
	}

	public String getServProviderPhone() {
		return servProviderPhone;
	}

	public void setServProviderPhone(String servProviderPhone) {
		this.servProviderPhone = servProviderPhone;
	}

	public String getServProviderPassword() {
		return servProviderPassword;
	}

	public void setServProviderPassword(String servProviderPassword) {
		this.servProviderPassword = servProviderPassword;
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
		this.servProviderIntroduction = servProviderIntroduction;
	}

	public String getServProviderEmail() {
		return servProviderEmail;
	}

	public void setServProviderEmail(String servProviderEmail) {
		this.servProviderEmail = servProviderEmail;
	}

	public Date getServProviderStarttime() {
		return servProviderStarttime;
	}

	public void setServProviderStarttime(Date servProviderStarttime) {
		this.servProviderStarttime = servProviderStarttime;
	}

	public String getServProviderWorktime() {
		return servProviderWorktime;
	}

	public void setServProviderWorktime(String servProviderWorktime) {
		this.servProviderWorktime = servProviderWorktime;
	}

	public String getServProviderQq() {
		return servProviderQq;
	}

	public void setServProviderQq(String servProviderQq) {
		this.servProviderQq = servProviderQq;
	}

	public String getServProviderWeichart() {
		return servProviderWeichart;
	}

	public void setServProviderWeichart(String servProviderWeichart) {
		this.servProviderWeichart = servProviderWeichart;
	}

	public String getServProviderCsphone() {
		return servProviderCsphone;
	}

	public void setServProviderCsphone(String servProviderCsphone) {
		this.servProviderCsphone = servProviderCsphone;
	}

	private byte[] servProviderImg;

	private byte[] servProviderBusinesslicense;

	public byte[] getServProviderImg() {
		return servProviderImg;
	}

	public String getServProviderId() {
		return servProviderId;
	}

	public void setServProviderId(String servProviderId) {
		this.servProviderId = servProviderId;
	}

	public void setServProviderImg(byte[] servProviderImg) {
		this.servProviderImg = servProviderImg;
	}

	public byte[] getServProviderBusinesslicense() {
		return servProviderBusinesslicense;
	}

	public void setServProviderBusinesslicense(byte[] servProviderBusinesslicense) {
		this.servProviderBusinesslicense = servProviderBusinesslicense;
	}
}
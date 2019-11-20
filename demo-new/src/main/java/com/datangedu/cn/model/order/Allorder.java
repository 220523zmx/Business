package com.datangedu.cn.model.order;

import java.util.Date;

public class Allorder {
	private String ordeId;

	private String ordeCustomerid;

	private String ordeProduct;

	private Integer ordePrice;

	private Date ordeStarttime;

	private String ordeCustomername;

	private Integer ordePayway;

	private Integer ordeState;

	private String ordeEvaluation;

	private Integer ordeEvaluationstatus;

	private Integer ordeNum;

	private String ordeProvidername;
	
	private String sername;
	
	private String likename;
	
	private Integer finish;

	public String getSername() {
		return sername;
	}

	public void setSername(String sername) {
		this.sername = sername;
	}

	public String getLikename() {
		return likename;
	}

	public void setLikename(String likename) {
		this.likename = likename;
	}

	public Integer getFinish() {
		return finish;
	}

	public void setFinish(Integer finish) {
		this.finish = finish;
	}

	public String getOrdeId() {
		return ordeId;
	}

	public void setOrdeId(String ordeId) {
		this.ordeId = ordeId == null ? null : ordeId.trim();
	}

	public String getOrdeCustomerid() {
		return ordeCustomerid;
	}

	public void setOrdeCustomerid(String ordeCustomerid) {
		this.ordeCustomerid = ordeCustomerid == null ? null : ordeCustomerid.trim();
	}

	public String getOrdeProduct() {
		return ordeProduct;
	}

	public void setOrdeProduct(String ordeProduct) {
		this.ordeProduct = ordeProduct == null ? null : ordeProduct.trim();
	}

	public Integer getOrdePrice() {
		return ordePrice;
	}

	public void setOrdePrice(Integer ordePrice) {
		this.ordePrice = ordePrice;
	}

	public Date getOrdeStarttime() {
		return ordeStarttime;
	}

	public void setOrdeStarttime(Date ordeStarttime) {
		this.ordeStarttime = ordeStarttime;
	}

	public String getOrdeCustomername() {
		return ordeCustomername;
	}

	public void setOrdeCustomername(String ordeCustomername) {
		this.ordeCustomername = ordeCustomername == null ? null : ordeCustomername.trim();
	}

	public Integer getOrdePayway() {
		return ordePayway;
	}

	public void setOrdePayway(Integer ordePayway) {
		this.ordePayway = ordePayway;
	}

	public Integer getOrdeState() {
		return ordeState;
	}

	public void setOrdeState(Integer ordeState) {
		this.ordeState = ordeState;
	}

	public String getOrdeEvaluation() {
		return ordeEvaluation;
	}

	public void setOrdeEvaluation(String ordeEvaluation) {
		this.ordeEvaluation = ordeEvaluation == null ? null : ordeEvaluation.trim();
	}

	public Integer getOrdeEvaluationstatus() {
		return ordeEvaluationstatus;
	}

	public void setOrdeEvaluationstatus(Integer ordeEvaluationstatus) {
		this.ordeEvaluationstatus = ordeEvaluationstatus;
	}

	public Integer getOrdeNum() {
		return ordeNum;
	}

	public void setOrdeNum(Integer ordeNum) {
		this.ordeNum = ordeNum;
	}

	public String getOrdeProvidername() {
		return ordeProvidername;
	}

	public void setOrdeProvidername(String ordeProvidername) {
		this.ordeProvidername = ordeProvidername == null ? null : ordeProvidername.trim();
	}
}
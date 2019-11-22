package com.datangedu.cn.model.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AllorderExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;
	protected Integer Nowpage;
	protected Integer Pagesize = 4;

	protected String sername;
	protected String likename;
	protected Integer finish;
	protected String likeId;
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPageSizes() {
		return pageSizes;
	}

	public void setPageSizes(int pageSizes) {
		this.pageSizes = (pageSizes - 1) * pageNums;
	}

	public int getPageNums() {
		return pageNums;
	}

	public void setPageNums(int pageNums) {
		this.pageNums = pageNums;
	}

	public String getDataa() {
		return dataa;
	}

	public void setDataa(String dataa) {
		this.dataa = dataa;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	protected int pageSizes ;
	protected int pageNums ;
	protected String dataa;
	protected String data;

	public String getLikeId() {
		return likeId;
	}

	public void setLikeId(String likeId) {
		this.likeId = likeId;
	}

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

	public Integer getNowpage() {
		return Nowpage;
	}

	public void setNowpage(Integer nowpage) {

		this.Nowpage = (nowpage-1)*Pagesize;
	}

	public Integer getPagesize() {
		return Pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.Pagesize = pagesize;
	}

	public AllorderExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
		Nowpage = 1;
		Pagesize = 4;
		likename = "";
		pageSizes = 1;
		pageNums = 2;
		dataa = "";
		data = "";

	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andOrdeIdIsNull() {
			addCriterion("ORDE_ID is null");
			return (Criteria) this;
		}

		public Criteria andOrdeIdIsNotNull() {
			addCriterion("ORDE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andOrdeIdEqualTo(String value) {
			addCriterion("ORDE_ID =", value, "ordeId");
			return (Criteria) this;
		}

		public Criteria andOrdeIdNotEqualTo(String value) {
			addCriterion("ORDE_ID <>", value, "ordeId");
			return (Criteria) this;
		}

		public Criteria andOrdeIdGreaterThan(String value) {
			addCriterion("ORDE_ID >", value, "ordeId");
			return (Criteria) this;
		}

		public Criteria andOrdeIdGreaterThanOrEqualTo(String value) {
			addCriterion("ORDE_ID >=", value, "ordeId");
			return (Criteria) this;
		}

		public Criteria andOrdeIdLessThan(String value) {
			addCriterion("ORDE_ID <", value, "ordeId");
			return (Criteria) this;
		}

		public Criteria andOrdeIdLessThanOrEqualTo(String value) {
			addCriterion("ORDE_ID <=", value, "ordeId");
			return (Criteria) this;
		}

		public Criteria andOrdeIdLike(String value) {
			addCriterion("ORDE_ID like", value, "ordeId");
			return (Criteria) this;
		}

		public Criteria andOrdeIdNotLike(String value) {
			addCriterion("ORDE_ID not like", value, "ordeId");
			return (Criteria) this;
		}

		public Criteria andOrdeIdIn(List<String> values) {
			addCriterion("ORDE_ID in", values, "ordeId");
			return (Criteria) this;
		}

		public Criteria andOrdeIdNotIn(List<String> values) {
			addCriterion("ORDE_ID not in", values, "ordeId");
			return (Criteria) this;
		}

		public Criteria andOrdeIdBetween(String value1, String value2) {
			addCriterion("ORDE_ID between", value1, value2, "ordeId");
			return (Criteria) this;
		}

		public Criteria andOrdeIdNotBetween(String value1, String value2) {
			addCriterion("ORDE_ID not between", value1, value2, "ordeId");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomeridIsNull() {
			addCriterion("ORDE_CUSTOMERID is null");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomeridIsNotNull() {
			addCriterion("ORDE_CUSTOMERID is not null");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomeridEqualTo(String value) {
			addCriterion("ORDE_CUSTOMERID =", value, "ordeCustomerid");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomeridNotEqualTo(String value) {
			addCriterion("ORDE_CUSTOMERID <>", value, "ordeCustomerid");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomeridGreaterThan(String value) {
			addCriterion("ORDE_CUSTOMERID >", value, "ordeCustomerid");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomeridGreaterThanOrEqualTo(String value) {
			addCriterion("ORDE_CUSTOMERID >=", value, "ordeCustomerid");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomeridLessThan(String value) {
			addCriterion("ORDE_CUSTOMERID <", value, "ordeCustomerid");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomeridLessThanOrEqualTo(String value) {
			addCriterion("ORDE_CUSTOMERID <=", value, "ordeCustomerid");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomeridLike(String value) {
			addCriterion("ORDE_CUSTOMERID like", value, "ordeCustomerid");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomeridNotLike(String value) {
			addCriterion("ORDE_CUSTOMERID not like", value, "ordeCustomerid");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomeridIn(List<String> values) {
			addCriterion("ORDE_CUSTOMERID in", values, "ordeCustomerid");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomeridNotIn(List<String> values) {
			addCriterion("ORDE_CUSTOMERID not in", values, "ordeCustomerid");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomeridBetween(String value1, String value2) {
			addCriterion("ORDE_CUSTOMERID between", value1, value2, "ordeCustomerid");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomeridNotBetween(String value1, String value2) {
			addCriterion("ORDE_CUSTOMERID not between", value1, value2, "ordeCustomerid");
			return (Criteria) this;
		}

		public Criteria andOrdeProductIsNull() {
			addCriterion("ORDE_PRODUCT is null");
			return (Criteria) this;
		}

		public Criteria andOrdeProductIsNotNull() {
			addCriterion("ORDE_PRODUCT is not null");
			return (Criteria) this;
		}

		public Criteria andOrdeProductEqualTo(String value) {
			addCriterion("ORDE_PRODUCT =", value, "ordeProduct");
			return (Criteria) this;
		}

		public Criteria andOrdeProductNotEqualTo(String value) {
			addCriterion("ORDE_PRODUCT <>", value, "ordeProduct");
			return (Criteria) this;
		}

		public Criteria andOrdeProductGreaterThan(String value) {
			addCriterion("ORDE_PRODUCT >", value, "ordeProduct");
			return (Criteria) this;
		}

		public Criteria andOrdeProductGreaterThanOrEqualTo(String value) {
			addCriterion("ORDE_PRODUCT >=", value, "ordeProduct");
			return (Criteria) this;
		}

		public Criteria andOrdeProductLessThan(String value) {
			addCriterion("ORDE_PRODUCT <", value, "ordeProduct");
			return (Criteria) this;
		}

		public Criteria andOrdeProductLessThanOrEqualTo(String value) {
			addCriterion("ORDE_PRODUCT <=", value, "ordeProduct");
			return (Criteria) this;
		}

		public Criteria andOrdeProductLike(String value) {
			addCriterion("ORDE_PRODUCT like", value, "ordeProduct");
			return (Criteria) this;
		}

		public Criteria andOrdeProductNotLike(String value) {
			addCriterion("ORDE_PRODUCT not like", value, "ordeProduct");
			return (Criteria) this;
		}

		public Criteria andOrdeProductIn(List<String> values) {
			addCriterion("ORDE_PRODUCT in", values, "ordeProduct");
			return (Criteria) this;
		}

		public Criteria andOrdeProductNotIn(List<String> values) {
			addCriterion("ORDE_PRODUCT not in", values, "ordeProduct");
			return (Criteria) this;
		}

		public Criteria andOrdeProductBetween(String value1, String value2) {
			addCriterion("ORDE_PRODUCT between", value1, value2, "ordeProduct");
			return (Criteria) this;
		}

		public Criteria andOrdeProductNotBetween(String value1, String value2) {
			addCriterion("ORDE_PRODUCT not between", value1, value2, "ordeProduct");
			return (Criteria) this;
		}

		public Criteria andOrdePriceIsNull() {
			addCriterion("ORDE_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andOrdePriceIsNotNull() {
			addCriterion("ORDE_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andOrdePriceEqualTo(Integer value) {
			addCriterion("ORDE_PRICE =", value, "ordePrice");
			return (Criteria) this;
		}

		public Criteria andOrdePriceNotEqualTo(Integer value) {
			addCriterion("ORDE_PRICE <>", value, "ordePrice");
			return (Criteria) this;
		}

		public Criteria andOrdePriceGreaterThan(Integer value) {
			addCriterion("ORDE_PRICE >", value, "ordePrice");
			return (Criteria) this;
		}

		public Criteria andOrdePriceGreaterThanOrEqualTo(Integer value) {
			addCriterion("ORDE_PRICE >=", value, "ordePrice");
			return (Criteria) this;
		}

		public Criteria andOrdePriceLessThan(Integer value) {
			addCriterion("ORDE_PRICE <", value, "ordePrice");
			return (Criteria) this;
		}

		public Criteria andOrdePriceLessThanOrEqualTo(Integer value) {
			addCriterion("ORDE_PRICE <=", value, "ordePrice");
			return (Criteria) this;
		}

		public Criteria andOrdePriceIn(List<Integer> values) {
			addCriterion("ORDE_PRICE in", values, "ordePrice");
			return (Criteria) this;
		}

		public Criteria andOrdePriceNotIn(List<Integer> values) {
			addCriterion("ORDE_PRICE not in", values, "ordePrice");
			return (Criteria) this;
		}

		public Criteria andOrdePriceBetween(Integer value1, Integer value2) {
			addCriterion("ORDE_PRICE between", value1, value2, "ordePrice");
			return (Criteria) this;
		}

		public Criteria andOrdePriceNotBetween(Integer value1, Integer value2) {
			addCriterion("ORDE_PRICE not between", value1, value2, "ordePrice");
			return (Criteria) this;
		}

		public Criteria andOrdeStarttimeIsNull() {
			addCriterion("ORDE_STARTTIME is null");
			return (Criteria) this;
		}

		public Criteria andOrdeStarttimeIsNotNull() {
			addCriterion("ORDE_STARTTIME is not null");
			return (Criteria) this;
		}

		public Criteria andOrdeStarttimeEqualTo(Date value) {
			addCriterion("ORDE_STARTTIME =", value, "ordeStarttime");
			return (Criteria) this;
		}

		public Criteria andOrdeStarttimeNotEqualTo(Date value) {
			addCriterion("ORDE_STARTTIME <>", value, "ordeStarttime");
			return (Criteria) this;
		}

		public Criteria andOrdeStarttimeGreaterThan(Date value) {
			addCriterion("ORDE_STARTTIME >", value, "ordeStarttime");
			return (Criteria) this;
		}

		public Criteria andOrdeStarttimeGreaterThanOrEqualTo(Date value) {
			addCriterion("ORDE_STARTTIME >=", value, "ordeStarttime");
			return (Criteria) this;
		}

		public Criteria andOrdeStarttimeLessThan(Date value) {
			addCriterion("ORDE_STARTTIME <", value, "ordeStarttime");
			return (Criteria) this;
		}

		public Criteria andOrdeStarttimeLessThanOrEqualTo(Date value) {
			addCriterion("ORDE_STARTTIME <=", value, "ordeStarttime");
			return (Criteria) this;
		}

		public Criteria andOrdeStarttimeIn(List<Date> values) {
			addCriterion("ORDE_STARTTIME in", values, "ordeStarttime");
			return (Criteria) this;
		}

		public Criteria andOrdeStarttimeNotIn(List<Date> values) {
			addCriterion("ORDE_STARTTIME not in", values, "ordeStarttime");
			return (Criteria) this;
		}

		public Criteria andOrdeStarttimeBetween(Date value1, Date value2) {
			addCriterion("ORDE_STARTTIME between", value1, value2, "ordeStarttime");
			return (Criteria) this;
		}

		public Criteria andOrdeStarttimeNotBetween(Date value1, Date value2) {
			addCriterion("ORDE_STARTTIME not between", value1, value2, "ordeStarttime");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomernameIsNull() {
			addCriterion("ORDE_CUSTOMERNAME is null");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomernameIsNotNull() {
			addCriterion("ORDE_CUSTOMERNAME is not null");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomernameEqualTo(String value) {
			addCriterion("ORDE_CUSTOMERNAME =", value, "ordeCustomername");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomernameNotEqualTo(String value) {
			addCriterion("ORDE_CUSTOMERNAME <>", value, "ordeCustomername");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomernameGreaterThan(String value) {
			addCriterion("ORDE_CUSTOMERNAME >", value, "ordeCustomername");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomernameGreaterThanOrEqualTo(String value) {
			addCriterion("ORDE_CUSTOMERNAME >=", value, "ordeCustomername");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomernameLessThan(String value) {
			addCriterion("ORDE_CUSTOMERNAME <", value, "ordeCustomername");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomernameLessThanOrEqualTo(String value) {
			addCriterion("ORDE_CUSTOMERNAME <=", value, "ordeCustomername");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomernameLike(String value) {
			addCriterion("ORDE_CUSTOMERNAME like", value, "ordeCustomername");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomernameNotLike(String value) {
			addCriterion("ORDE_CUSTOMERNAME not like", value, "ordeCustomername");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomernameIn(List<String> values) {
			addCriterion("ORDE_CUSTOMERNAME in", values, "ordeCustomername");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomernameNotIn(List<String> values) {
			addCriterion("ORDE_CUSTOMERNAME not in", values, "ordeCustomername");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomernameBetween(String value1, String value2) {
			addCriterion("ORDE_CUSTOMERNAME between", value1, value2, "ordeCustomername");
			return (Criteria) this;
		}

		public Criteria andOrdeCustomernameNotBetween(String value1, String value2) {
			addCriterion("ORDE_CUSTOMERNAME not between", value1, value2, "ordeCustomername");
			return (Criteria) this;
		}

		public Criteria andOrdePaywayIsNull() {
			addCriterion("ORDE_PAYWAY is null");
			return (Criteria) this;
		}

		public Criteria andOrdePaywayIsNotNull() {
			addCriterion("ORDE_PAYWAY is not null");
			return (Criteria) this;
		}

		public Criteria andOrdePaywayEqualTo(Integer value) {
			addCriterion("ORDE_PAYWAY =", value, "ordePayway");
			return (Criteria) this;
		}

		public Criteria andOrdePaywayNotEqualTo(Integer value) {
			addCriterion("ORDE_PAYWAY <>", value, "ordePayway");
			return (Criteria) this;
		}

		public Criteria andOrdePaywayGreaterThan(Integer value) {
			addCriterion("ORDE_PAYWAY >", value, "ordePayway");
			return (Criteria) this;
		}

		public Criteria andOrdePaywayGreaterThanOrEqualTo(Integer value) {
			addCriterion("ORDE_PAYWAY >=", value, "ordePayway");
			return (Criteria) this;
		}

		public Criteria andOrdePaywayLessThan(Integer value) {
			addCriterion("ORDE_PAYWAY <", value, "ordePayway");
			return (Criteria) this;
		}

		public Criteria andOrdePaywayLessThanOrEqualTo(Integer value) {
			addCriterion("ORDE_PAYWAY <=", value, "ordePayway");
			return (Criteria) this;
		}

		public Criteria andOrdePaywayIn(List<Integer> values) {
			addCriterion("ORDE_PAYWAY in", values, "ordePayway");
			return (Criteria) this;
		}

		public Criteria andOrdePaywayNotIn(List<Integer> values) {
			addCriterion("ORDE_PAYWAY not in", values, "ordePayway");
			return (Criteria) this;
		}

		public Criteria andOrdePaywayBetween(Integer value1, Integer value2) {
			addCriterion("ORDE_PAYWAY between", value1, value2, "ordePayway");
			return (Criteria) this;
		}

		public Criteria andOrdePaywayNotBetween(Integer value1, Integer value2) {
			addCriterion("ORDE_PAYWAY not between", value1, value2, "ordePayway");
			return (Criteria) this;
		}

		public Criteria andOrdeStateIsNull() {
			addCriterion("ORDE_STATE is null");
			return (Criteria) this;
		}

		public Criteria andOrdeStateIsNotNull() {
			addCriterion("ORDE_STATE is not null");
			return (Criteria) this;
		}

		public Criteria andOrdeStateEqualTo(Integer value) {
			addCriterion("ORDE_STATE =", value, "ordeState");
			return (Criteria) this;
		}

		public Criteria andOrdeStateNotEqualTo(Integer value) {
			addCriterion("ORDE_STATE <>", value, "ordeState");
			return (Criteria) this;
		}

		public Criteria andOrdeStateGreaterThan(Integer value) {
			addCriterion("ORDE_STATE >", value, "ordeState");
			return (Criteria) this;
		}

		public Criteria andOrdeStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("ORDE_STATE >=", value, "ordeState");
			return (Criteria) this;
		}

		public Criteria andOrdeStateLessThan(Integer value) {
			addCriterion("ORDE_STATE <", value, "ordeState");
			return (Criteria) this;
		}

		public Criteria andOrdeStateLessThanOrEqualTo(Integer value) {
			addCriterion("ORDE_STATE <=", value, "ordeState");
			return (Criteria) this;
		}

		public Criteria andOrdeStateIn(List<Integer> values) {
			addCriterion("ORDE_STATE in", values, "ordeState");
			return (Criteria) this;
		}

		public Criteria andOrdeStateNotIn(List<Integer> values) {
			addCriterion("ORDE_STATE not in", values, "ordeState");
			return (Criteria) this;
		}

		public Criteria andOrdeStateBetween(Integer value1, Integer value2) {
			addCriterion("ORDE_STATE between", value1, value2, "ordeState");
			return (Criteria) this;
		}

		public Criteria andOrdeStateNotBetween(Integer value1, Integer value2) {
			addCriterion("ORDE_STATE not between", value1, value2, "ordeState");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationIsNull() {
			addCriterion("ORDE_EVALUATION is null");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationIsNotNull() {
			addCriterion("ORDE_EVALUATION is not null");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationEqualTo(String value) {
			addCriterion("ORDE_EVALUATION =", value, "ordeEvaluation");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationNotEqualTo(String value) {
			addCriterion("ORDE_EVALUATION <>", value, "ordeEvaluation");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationGreaterThan(String value) {
			addCriterion("ORDE_EVALUATION >", value, "ordeEvaluation");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationGreaterThanOrEqualTo(String value) {
			addCriterion("ORDE_EVALUATION >=", value, "ordeEvaluation");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationLessThan(String value) {
			addCriterion("ORDE_EVALUATION <", value, "ordeEvaluation");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationLessThanOrEqualTo(String value) {
			addCriterion("ORDE_EVALUATION <=", value, "ordeEvaluation");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationLike(String value) {
			addCriterion("ORDE_EVALUATION like", value, "ordeEvaluation");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationNotLike(String value) {
			addCriterion("ORDE_EVALUATION not like", value, "ordeEvaluation");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationIn(List<String> values) {
			addCriterion("ORDE_EVALUATION in", values, "ordeEvaluation");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationNotIn(List<String> values) {
			addCriterion("ORDE_EVALUATION not in", values, "ordeEvaluation");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationBetween(String value1, String value2) {
			addCriterion("ORDE_EVALUATION between", value1, value2, "ordeEvaluation");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationNotBetween(String value1, String value2) {
			addCriterion("ORDE_EVALUATION not between", value1, value2, "ordeEvaluation");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationstatusIsNull() {
			addCriterion("ORDE_EVALUATIONSTATUS is null");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationstatusIsNotNull() {
			addCriterion("ORDE_EVALUATIONSTATUS is not null");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationstatusEqualTo(Integer value) {
			addCriterion("ORDE_EVALUATIONSTATUS =", value, "ordeEvaluationstatus");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationstatusNotEqualTo(Integer value) {
			addCriterion("ORDE_EVALUATIONSTATUS <>", value, "ordeEvaluationstatus");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationstatusGreaterThan(Integer value) {
			addCriterion("ORDE_EVALUATIONSTATUS >", value, "ordeEvaluationstatus");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationstatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("ORDE_EVALUATIONSTATUS >=", value, "ordeEvaluationstatus");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationstatusLessThan(Integer value) {
			addCriterion("ORDE_EVALUATIONSTATUS <", value, "ordeEvaluationstatus");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationstatusLessThanOrEqualTo(Integer value) {
			addCriterion("ORDE_EVALUATIONSTATUS <=", value, "ordeEvaluationstatus");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationstatusIn(List<Integer> values) {
			addCriterion("ORDE_EVALUATIONSTATUS in", values, "ordeEvaluationstatus");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationstatusNotIn(List<Integer> values) {
			addCriterion("ORDE_EVALUATIONSTATUS not in", values, "ordeEvaluationstatus");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationstatusBetween(Integer value1, Integer value2) {
			addCriterion("ORDE_EVALUATIONSTATUS between", value1, value2, "ordeEvaluationstatus");
			return (Criteria) this;
		}

		public Criteria andOrdeEvaluationstatusNotBetween(Integer value1, Integer value2) {
			addCriterion("ORDE_EVALUATIONSTATUS not between", value1, value2, "ordeEvaluationstatus");
			return (Criteria) this;
		}

		public Criteria andOrdeNumIsNull() {
			addCriterion("ORDE_NUM is null");
			return (Criteria) this;
		}

		public Criteria andOrdeNumIsNotNull() {
			addCriterion("ORDE_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andOrdeNumEqualTo(Integer value) {
			addCriterion("ORDE_NUM =", value, "ordeNum");
			return (Criteria) this;
		}

		public Criteria andOrdeNumNotEqualTo(Integer value) {
			addCriterion("ORDE_NUM <>", value, "ordeNum");
			return (Criteria) this;
		}

		public Criteria andOrdeNumGreaterThan(Integer value) {
			addCriterion("ORDE_NUM >", value, "ordeNum");
			return (Criteria) this;
		}

		public Criteria andOrdeNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("ORDE_NUM >=", value, "ordeNum");
			return (Criteria) this;
		}

		public Criteria andOrdeNumLessThan(Integer value) {
			addCriterion("ORDE_NUM <", value, "ordeNum");
			return (Criteria) this;
		}

		public Criteria andOrdeNumLessThanOrEqualTo(Integer value) {
			addCriterion("ORDE_NUM <=", value, "ordeNum");
			return (Criteria) this;
		}

		public Criteria andOrdeNumIn(List<Integer> values) {
			addCriterion("ORDE_NUM in", values, "ordeNum");
			return (Criteria) this;
		}

		public Criteria andOrdeNumNotIn(List<Integer> values) {
			addCriterion("ORDE_NUM not in", values, "ordeNum");
			return (Criteria) this;
		}

		public Criteria andOrdeNumBetween(Integer value1, Integer value2) {
			addCriterion("ORDE_NUM between", value1, value2, "ordeNum");
			return (Criteria) this;
		}

		public Criteria andOrdeNumNotBetween(Integer value1, Integer value2) {
			addCriterion("ORDE_NUM not between", value1, value2, "ordeNum");
			return (Criteria) this;
		}

		public Criteria andOrdeProvidernameIsNull() {
			addCriterion("ORDE_PROVIDERNAME is null");
			return (Criteria) this;
		}

		public Criteria andOrdeProvidernameIsNotNull() {
			addCriterion("ORDE_PROVIDERNAME is not null");
			return (Criteria) this;
		}

		public Criteria andOrdeProvidernameEqualTo(String value) {
			addCriterion("ORDE_PROVIDERNAME =", value, "ordeProvidername");
			return (Criteria) this;
		}

		public Criteria andOrdeProvidernameNotEqualTo(String value) {
			addCriterion("ORDE_PROVIDERNAME <>", value, "ordeProvidername");
			return (Criteria) this;
		}

		public Criteria andOrdeProvidernameGreaterThan(String value) {
			addCriterion("ORDE_PROVIDERNAME >", value, "ordeProvidername");
			return (Criteria) this;
		}

		public Criteria andOrdeProvidernameGreaterThanOrEqualTo(String value) {
			addCriterion("ORDE_PROVIDERNAME >=", value, "ordeProvidername");
			return (Criteria) this;
		}

		public Criteria andOrdeProvidernameLessThan(String value) {
			addCriterion("ORDE_PROVIDERNAME <", value, "ordeProvidername");
			return (Criteria) this;
		}

		public Criteria andOrdeProvidernameLessThanOrEqualTo(String value) {
			addCriterion("ORDE_PROVIDERNAME <=", value, "ordeProvidername");
			return (Criteria) this;
		}

		public Criteria andOrdeProvidernameLike(String value) {
			addCriterion("ORDE_PROVIDERNAME like", value, "ordeProvidername");
			return (Criteria) this;
		}

		public Criteria andOrdeProvidernameNotLike(String value) {
			addCriterion("ORDE_PROVIDERNAME not like", value, "ordeProvidername");
			return (Criteria) this;
		}

		public Criteria andOrdeProvidernameIn(List<String> values) {
			addCriterion("ORDE_PROVIDERNAME in", values, "ordeProvidername");
			return (Criteria) this;
		}

		public Criteria andOrdeProvidernameNotIn(List<String> values) {
			addCriterion("ORDE_PROVIDERNAME not in", values, "ordeProvidername");
			return (Criteria) this;
		}

		public Criteria andOrdeProvidernameBetween(String value1, String value2) {
			addCriterion("ORDE_PROVIDERNAME between", value1, value2, "ordeProvidername");
			return (Criteria) this;
		}

		public Criteria andOrdeProvidernameNotBetween(String value1, String value2) {
			addCriterion("ORDE_PROVIDERNAME not between", value1, value2, "ordeProvidername");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}
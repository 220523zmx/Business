package com.datangedu.cn.model.customers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomersExample() {
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

        public Criteria andCustIdIsNull() {
            addCriterion("CUST_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("CUST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(String value) {
            addCriterion("CUST_ID =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(String value) {
            addCriterion("CUST_ID <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(String value) {
            addCriterion("CUST_ID >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_ID >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(String value) {
            addCriterion("CUST_ID <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(String value) {
            addCriterion("CUST_ID <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLike(String value) {
            addCriterion("CUST_ID like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotLike(String value) {
            addCriterion("CUST_ID not like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<String> values) {
            addCriterion("CUST_ID in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<String> values) {
            addCriterion("CUST_ID not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(String value1, String value2) {
            addCriterion("CUST_ID between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(String value1, String value2) {
            addCriterion("CUST_ID not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNull() {
            addCriterion("CUST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("CUST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("CUST_NAME =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("CUST_NAME <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("CUST_NAME >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_NAME >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("CUST_NAME <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("CUST_NAME <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("CUST_NAME like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("CUST_NAME not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("CUST_NAME in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("CUST_NAME not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("CUST_NAME between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("CUST_NAME not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustSexIsNull() {
            addCriterion("CUST_SEX is null");
            return (Criteria) this;
        }

        public Criteria andCustSexIsNotNull() {
            addCriterion("CUST_SEX is not null");
            return (Criteria) this;
        }

        public Criteria andCustSexEqualTo(String value) {
            addCriterion("CUST_SEX =", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexNotEqualTo(String value) {
            addCriterion("CUST_SEX <>", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexGreaterThan(String value) {
            addCriterion("CUST_SEX >", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_SEX >=", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexLessThan(String value) {
            addCriterion("CUST_SEX <", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexLessThanOrEqualTo(String value) {
            addCriterion("CUST_SEX <=", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexLike(String value) {
            addCriterion("CUST_SEX like", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexNotLike(String value) {
            addCriterion("CUST_SEX not like", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexIn(List<String> values) {
            addCriterion("CUST_SEX in", values, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexNotIn(List<String> values) {
            addCriterion("CUST_SEX not in", values, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexBetween(String value1, String value2) {
            addCriterion("CUST_SEX between", value1, value2, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexNotBetween(String value1, String value2) {
            addCriterion("CUST_SEX not between", value1, value2, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIsNull() {
            addCriterion("CUST_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIsNotNull() {
            addCriterion("CUST_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andCustPhoneEqualTo(String value) {
            addCriterion("CUST_PHONE =", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotEqualTo(String value) {
            addCriterion("CUST_PHONE <>", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneGreaterThan(String value) {
            addCriterion("CUST_PHONE >", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_PHONE >=", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLessThan(String value) {
            addCriterion("CUST_PHONE <", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLessThanOrEqualTo(String value) {
            addCriterion("CUST_PHONE <=", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLike(String value) {
            addCriterion("CUST_PHONE like", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotLike(String value) {
            addCriterion("CUST_PHONE not like", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIn(List<String> values) {
            addCriterion("CUST_PHONE in", values, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotIn(List<String> values) {
            addCriterion("CUST_PHONE not in", values, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneBetween(String value1, String value2) {
            addCriterion("CUST_PHONE between", value1, value2, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotBetween(String value1, String value2) {
            addCriterion("CUST_PHONE not between", value1, value2, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustRegionIsNull() {
            addCriterion("CUST_REGION is null");
            return (Criteria) this;
        }

        public Criteria andCustRegionIsNotNull() {
            addCriterion("CUST_REGION is not null");
            return (Criteria) this;
        }

        public Criteria andCustRegionEqualTo(String value) {
            addCriterion("CUST_REGION =", value, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionNotEqualTo(String value) {
            addCriterion("CUST_REGION <>", value, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionGreaterThan(String value) {
            addCriterion("CUST_REGION >", value, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_REGION >=", value, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionLessThan(String value) {
            addCriterion("CUST_REGION <", value, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionLessThanOrEqualTo(String value) {
            addCriterion("CUST_REGION <=", value, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionLike(String value) {
            addCriterion("CUST_REGION like", value, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionNotLike(String value) {
            addCriterion("CUST_REGION not like", value, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionIn(List<String> values) {
            addCriterion("CUST_REGION in", values, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionNotIn(List<String> values) {
            addCriterion("CUST_REGION not in", values, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionBetween(String value1, String value2) {
            addCriterion("CUST_REGION between", value1, value2, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustRegionNotBetween(String value1, String value2) {
            addCriterion("CUST_REGION not between", value1, value2, "custRegion");
            return (Criteria) this;
        }

        public Criteria andCustStarttimeIsNull() {
            addCriterion("CUST_STARTTIME is null");
            return (Criteria) this;
        }

        public Criteria andCustStarttimeIsNotNull() {
            addCriterion("CUST_STARTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andCustStarttimeEqualTo(Date value) {
            addCriterion("CUST_STARTTIME =", value, "custStarttime");
            return (Criteria) this;
        }

        public Criteria andCustStarttimeNotEqualTo(Date value) {
            addCriterion("CUST_STARTTIME <>", value, "custStarttime");
            return (Criteria) this;
        }

        public Criteria andCustStarttimeGreaterThan(Date value) {
            addCriterion("CUST_STARTTIME >", value, "custStarttime");
            return (Criteria) this;
        }

        public Criteria andCustStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CUST_STARTTIME >=", value, "custStarttime");
            return (Criteria) this;
        }

        public Criteria andCustStarttimeLessThan(Date value) {
            addCriterion("CUST_STARTTIME <", value, "custStarttime");
            return (Criteria) this;
        }

        public Criteria andCustStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("CUST_STARTTIME <=", value, "custStarttime");
            return (Criteria) this;
        }

        public Criteria andCustStarttimeIn(List<Date> values) {
            addCriterion("CUST_STARTTIME in", values, "custStarttime");
            return (Criteria) this;
        }

        public Criteria andCustStarttimeNotIn(List<Date> values) {
            addCriterion("CUST_STARTTIME not in", values, "custStarttime");
            return (Criteria) this;
        }

        public Criteria andCustStarttimeBetween(Date value1, Date value2) {
            addCriterion("CUST_STARTTIME between", value1, value2, "custStarttime");
            return (Criteria) this;
        }

        public Criteria andCustStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("CUST_STARTTIME not between", value1, value2, "custStarttime");
            return (Criteria) this;
        }

        public Criteria andCustEmailIsNull() {
            addCriterion("CUST_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andCustEmailIsNotNull() {
            addCriterion("CUST_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andCustEmailEqualTo(String value) {
            addCriterion("CUST_EMAIL =", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotEqualTo(String value) {
            addCriterion("CUST_EMAIL <>", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailGreaterThan(String value) {
            addCriterion("CUST_EMAIL >", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_EMAIL >=", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailLessThan(String value) {
            addCriterion("CUST_EMAIL <", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailLessThanOrEqualTo(String value) {
            addCriterion("CUST_EMAIL <=", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailLike(String value) {
            addCriterion("CUST_EMAIL like", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotLike(String value) {
            addCriterion("CUST_EMAIL not like", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailIn(List<String> values) {
            addCriterion("CUST_EMAIL in", values, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotIn(List<String> values) {
            addCriterion("CUST_EMAIL not in", values, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailBetween(String value1, String value2) {
            addCriterion("CUST_EMAIL between", value1, value2, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotBetween(String value1, String value2) {
            addCriterion("CUST_EMAIL not between", value1, value2, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustNumberIsNull() {
            addCriterion("CUST_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andCustNumberIsNotNull() {
            addCriterion("CUST_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andCustNumberEqualTo(Integer value) {
            addCriterion("CUST_NUMBER =", value, "custNumber");
            return (Criteria) this;
        }

        public Criteria andCustNumberNotEqualTo(Integer value) {
            addCriterion("CUST_NUMBER <>", value, "custNumber");
            return (Criteria) this;
        }

        public Criteria andCustNumberGreaterThan(Integer value) {
            addCriterion("CUST_NUMBER >", value, "custNumber");
            return (Criteria) this;
        }

        public Criteria andCustNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("CUST_NUMBER >=", value, "custNumber");
            return (Criteria) this;
        }

        public Criteria andCustNumberLessThan(Integer value) {
            addCriterion("CUST_NUMBER <", value, "custNumber");
            return (Criteria) this;
        }

        public Criteria andCustNumberLessThanOrEqualTo(Integer value) {
            addCriterion("CUST_NUMBER <=", value, "custNumber");
            return (Criteria) this;
        }

        public Criteria andCustNumberIn(List<Integer> values) {
            addCriterion("CUST_NUMBER in", values, "custNumber");
            return (Criteria) this;
        }

        public Criteria andCustNumberNotIn(List<Integer> values) {
            addCriterion("CUST_NUMBER not in", values, "custNumber");
            return (Criteria) this;
        }

        public Criteria andCustNumberBetween(Integer value1, Integer value2) {
            addCriterion("CUST_NUMBER between", value1, value2, "custNumber");
            return (Criteria) this;
        }

        public Criteria andCustNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("CUST_NUMBER not between", value1, value2, "custNumber");
            return (Criteria) this;
        }

        public Criteria andCustPriceIsNull() {
            addCriterion("CUST_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andCustPriceIsNotNull() {
            addCriterion("CUST_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andCustPriceEqualTo(Integer value) {
            addCriterion("CUST_PRICE =", value, "custPrice");
            return (Criteria) this;
        }

        public Criteria andCustPriceNotEqualTo(Integer value) {
            addCriterion("CUST_PRICE <>", value, "custPrice");
            return (Criteria) this;
        }

        public Criteria andCustPriceGreaterThan(Integer value) {
            addCriterion("CUST_PRICE >", value, "custPrice");
            return (Criteria) this;
        }

        public Criteria andCustPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("CUST_PRICE >=", value, "custPrice");
            return (Criteria) this;
        }

        public Criteria andCustPriceLessThan(Integer value) {
            addCriterion("CUST_PRICE <", value, "custPrice");
            return (Criteria) this;
        }

        public Criteria andCustPriceLessThanOrEqualTo(Integer value) {
            addCriterion("CUST_PRICE <=", value, "custPrice");
            return (Criteria) this;
        }

        public Criteria andCustPriceIn(List<Integer> values) {
            addCriterion("CUST_PRICE in", values, "custPrice");
            return (Criteria) this;
        }

        public Criteria andCustPriceNotIn(List<Integer> values) {
            addCriterion("CUST_PRICE not in", values, "custPrice");
            return (Criteria) this;
        }

        public Criteria andCustPriceBetween(Integer value1, Integer value2) {
            addCriterion("CUST_PRICE between", value1, value2, "custPrice");
            return (Criteria) this;
        }

        public Criteria andCustPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("CUST_PRICE not between", value1, value2, "custPrice");
            return (Criteria) this;
        }

        public Criteria andCustStateIsNull() {
            addCriterion("CUST_STATE is null");
            return (Criteria) this;
        }

        public Criteria andCustStateIsNotNull() {
            addCriterion("CUST_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andCustStateEqualTo(Integer value) {
            addCriterion("CUST_STATE =", value, "custState");
            return (Criteria) this;
        }

        public Criteria andCustStateNotEqualTo(Integer value) {
            addCriterion("CUST_STATE <>", value, "custState");
            return (Criteria) this;
        }

        public Criteria andCustStateGreaterThan(Integer value) {
            addCriterion("CUST_STATE >", value, "custState");
            return (Criteria) this;
        }

        public Criteria andCustStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("CUST_STATE >=", value, "custState");
            return (Criteria) this;
        }

        public Criteria andCustStateLessThan(Integer value) {
            addCriterion("CUST_STATE <", value, "custState");
            return (Criteria) this;
        }

        public Criteria andCustStateLessThanOrEqualTo(Integer value) {
            addCriterion("CUST_STATE <=", value, "custState");
            return (Criteria) this;
        }

        public Criteria andCustStateIn(List<Integer> values) {
            addCriterion("CUST_STATE in", values, "custState");
            return (Criteria) this;
        }

        public Criteria andCustStateNotIn(List<Integer> values) {
            addCriterion("CUST_STATE not in", values, "custState");
            return (Criteria) this;
        }

        public Criteria andCustStateBetween(Integer value1, Integer value2) {
            addCriterion("CUST_STATE between", value1, value2, "custState");
            return (Criteria) this;
        }

        public Criteria andCustStateNotBetween(Integer value1, Integer value2) {
            addCriterion("CUST_STATE not between", value1, value2, "custState");
            return (Criteria) this;
        }

        public Criteria andCustPasswordIsNull() {
            addCriterion("CUST_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andCustPasswordIsNotNull() {
            addCriterion("CUST_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andCustPasswordEqualTo(String value) {
            addCriterion("CUST_PASSWORD =", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordNotEqualTo(String value) {
            addCriterion("CUST_PASSWORD <>", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordGreaterThan(String value) {
            addCriterion("CUST_PASSWORD >", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_PASSWORD >=", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordLessThan(String value) {
            addCriterion("CUST_PASSWORD <", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordLessThanOrEqualTo(String value) {
            addCriterion("CUST_PASSWORD <=", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordLike(String value) {
            addCriterion("CUST_PASSWORD like", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordNotLike(String value) {
            addCriterion("CUST_PASSWORD not like", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordIn(List<String> values) {
            addCriterion("CUST_PASSWORD in", values, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordNotIn(List<String> values) {
            addCriterion("CUST_PASSWORD not in", values, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordBetween(String value1, String value2) {
            addCriterion("CUST_PASSWORD between", value1, value2, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordNotBetween(String value1, String value2) {
            addCriterion("CUST_PASSWORD not between", value1, value2, "custPassword");
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
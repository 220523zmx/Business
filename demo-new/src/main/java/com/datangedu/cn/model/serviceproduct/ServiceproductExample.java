package com.datangedu.cn.model.serviceproduct;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceproductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServiceproductExample() {
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

        public Criteria andServProductidIsNull() {
            addCriterion("SERV_PRODUCTID is null");
            return (Criteria) this;
        }

        public Criteria andServProductidIsNotNull() {
            addCriterion("SERV_PRODUCTID is not null");
            return (Criteria) this;
        }

        public Criteria andServProductidEqualTo(String value) {
            addCriterion("SERV_PRODUCTID =", value, "servProductid");
            return (Criteria) this;
        }

        public Criteria andServProductidNotEqualTo(String value) {
            addCriterion("SERV_PRODUCTID <>", value, "servProductid");
            return (Criteria) this;
        }

        public Criteria andServProductidGreaterThan(String value) {
            addCriterion("SERV_PRODUCTID >", value, "servProductid");
            return (Criteria) this;
        }

        public Criteria andServProductidGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_PRODUCTID >=", value, "servProductid");
            return (Criteria) this;
        }

        public Criteria andServProductidLessThan(String value) {
            addCriterion("SERV_PRODUCTID <", value, "servProductid");
            return (Criteria) this;
        }

        public Criteria andServProductidLessThanOrEqualTo(String value) {
            addCriterion("SERV_PRODUCTID <=", value, "servProductid");
            return (Criteria) this;
        }

        public Criteria andServProductidLike(String value) {
            addCriterion("SERV_PRODUCTID like", value, "servProductid");
            return (Criteria) this;
        }

        public Criteria andServProductidNotLike(String value) {
            addCriterion("SERV_PRODUCTID not like", value, "servProductid");
            return (Criteria) this;
        }

        public Criteria andServProductidIn(List<String> values) {
            addCriterion("SERV_PRODUCTID in", values, "servProductid");
            return (Criteria) this;
        }

        public Criteria andServProductidNotIn(List<String> values) {
            addCriterion("SERV_PRODUCTID not in", values, "servProductid");
            return (Criteria) this;
        }

        public Criteria andServProductidBetween(String value1, String value2) {
            addCriterion("SERV_PRODUCTID between", value1, value2, "servProductid");
            return (Criteria) this;
        }

        public Criteria andServProductidNotBetween(String value1, String value2) {
            addCriterion("SERV_PRODUCTID not between", value1, value2, "servProductid");
            return (Criteria) this;
        }

        public Criteria andServProvideridIsNull() {
            addCriterion("SERV_PROVIDERID is null");
            return (Criteria) this;
        }

        public Criteria andServProvideridIsNotNull() {
            addCriterion("SERV_PROVIDERID is not null");
            return (Criteria) this;
        }

        public Criteria andServProvideridEqualTo(String value) {
            addCriterion("SERV_PROVIDERID =", value, "servProviderid");
            return (Criteria) this;
        }

        public Criteria andServProvideridNotEqualTo(String value) {
            addCriterion("SERV_PROVIDERID <>", value, "servProviderid");
            return (Criteria) this;
        }

        public Criteria andServProvideridGreaterThan(String value) {
            addCriterion("SERV_PROVIDERID >", value, "servProviderid");
            return (Criteria) this;
        }

        public Criteria andServProvideridGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDERID >=", value, "servProviderid");
            return (Criteria) this;
        }

        public Criteria andServProvideridLessThan(String value) {
            addCriterion("SERV_PROVIDERID <", value, "servProviderid");
            return (Criteria) this;
        }

        public Criteria andServProvideridLessThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDERID <=", value, "servProviderid");
            return (Criteria) this;
        }

        public Criteria andServProvideridLike(String value) {
            addCriterion("SERV_PROVIDERID like", value, "servProviderid");
            return (Criteria) this;
        }

        public Criteria andServProvideridNotLike(String value) {
            addCriterion("SERV_PROVIDERID not like", value, "servProviderid");
            return (Criteria) this;
        }

        public Criteria andServProvideridIn(List<String> values) {
            addCriterion("SERV_PROVIDERID in", values, "servProviderid");
            return (Criteria) this;
        }

        public Criteria andServProvideridNotIn(List<String> values) {
            addCriterion("SERV_PROVIDERID not in", values, "servProviderid");
            return (Criteria) this;
        }

        public Criteria andServProvideridBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDERID between", value1, value2, "servProviderid");
            return (Criteria) this;
        }

        public Criteria andServProvideridNotBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDERID not between", value1, value2, "servProviderid");
            return (Criteria) this;
        }

        public Criteria andServProductnameIsNull() {
            addCriterion("SERV_PRODUCTNAME is null");
            return (Criteria) this;
        }

        public Criteria andServProductnameIsNotNull() {
            addCriterion("SERV_PRODUCTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andServProductnameEqualTo(String value) {
            addCriterion("SERV_PRODUCTNAME =", value, "servProductname");
            return (Criteria) this;
        }

        public Criteria andServProductnameNotEqualTo(String value) {
            addCriterion("SERV_PRODUCTNAME <>", value, "servProductname");
            return (Criteria) this;
        }

        public Criteria andServProductnameGreaterThan(String value) {
            addCriterion("SERV_PRODUCTNAME >", value, "servProductname");
            return (Criteria) this;
        }

        public Criteria andServProductnameGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_PRODUCTNAME >=", value, "servProductname");
            return (Criteria) this;
        }

        public Criteria andServProductnameLessThan(String value) {
            addCriterion("SERV_PRODUCTNAME <", value, "servProductname");
            return (Criteria) this;
        }

        public Criteria andServProductnameLessThanOrEqualTo(String value) {
            addCriterion("SERV_PRODUCTNAME <=", value, "servProductname");
            return (Criteria) this;
        }

        public Criteria andServProductnameLike(String value) {
            addCriterion("SERV_PRODUCTNAME like", value, "servProductname");
            return (Criteria) this;
        }

        public Criteria andServProductnameNotLike(String value) {
            addCriterion("SERV_PRODUCTNAME not like", value, "servProductname");
            return (Criteria) this;
        }

        public Criteria andServProductnameIn(List<String> values) {
            addCriterion("SERV_PRODUCTNAME in", values, "servProductname");
            return (Criteria) this;
        }

        public Criteria andServProductnameNotIn(List<String> values) {
            addCriterion("SERV_PRODUCTNAME not in", values, "servProductname");
            return (Criteria) this;
        }

        public Criteria andServProductnameBetween(String value1, String value2) {
            addCriterion("SERV_PRODUCTNAME between", value1, value2, "servProductname");
            return (Criteria) this;
        }

        public Criteria andServProductnameNotBetween(String value1, String value2) {
            addCriterion("SERV_PRODUCTNAME not between", value1, value2, "servProductname");
            return (Criteria) this;
        }

        public Criteria andServInstructionsIsNull() {
            addCriterion("SERV_INSTRUCTIONS is null");
            return (Criteria) this;
        }

        public Criteria andServInstructionsIsNotNull() {
            addCriterion("SERV_INSTRUCTIONS is not null");
            return (Criteria) this;
        }

        public Criteria andServInstructionsEqualTo(String value) {
            addCriterion("SERV_INSTRUCTIONS =", value, "servInstructions");
            return (Criteria) this;
        }

        public Criteria andServInstructionsNotEqualTo(String value) {
            addCriterion("SERV_INSTRUCTIONS <>", value, "servInstructions");
            return (Criteria) this;
        }

        public Criteria andServInstructionsGreaterThan(String value) {
            addCriterion("SERV_INSTRUCTIONS >", value, "servInstructions");
            return (Criteria) this;
        }

        public Criteria andServInstructionsGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_INSTRUCTIONS >=", value, "servInstructions");
            return (Criteria) this;
        }

        public Criteria andServInstructionsLessThan(String value) {
            addCriterion("SERV_INSTRUCTIONS <", value, "servInstructions");
            return (Criteria) this;
        }

        public Criteria andServInstructionsLessThanOrEqualTo(String value) {
            addCriterion("SERV_INSTRUCTIONS <=", value, "servInstructions");
            return (Criteria) this;
        }

        public Criteria andServInstructionsLike(String value) {
            addCriterion("SERV_INSTRUCTIONS like", value, "servInstructions");
            return (Criteria) this;
        }

        public Criteria andServInstructionsNotLike(String value) {
            addCriterion("SERV_INSTRUCTIONS not like", value, "servInstructions");
            return (Criteria) this;
        }

        public Criteria andServInstructionsIn(List<String> values) {
            addCriterion("SERV_INSTRUCTIONS in", values, "servInstructions");
            return (Criteria) this;
        }

        public Criteria andServInstructionsNotIn(List<String> values) {
            addCriterion("SERV_INSTRUCTIONS not in", values, "servInstructions");
            return (Criteria) this;
        }

        public Criteria andServInstructionsBetween(String value1, String value2) {
            addCriterion("SERV_INSTRUCTIONS between", value1, value2, "servInstructions");
            return (Criteria) this;
        }

        public Criteria andServInstructionsNotBetween(String value1, String value2) {
            addCriterion("SERV_INSTRUCTIONS not between", value1, value2, "servInstructions");
            return (Criteria) this;
        }

        public Criteria andServPriceIsNull() {
            addCriterion("SERV_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andServPriceIsNotNull() {
            addCriterion("SERV_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andServPriceEqualTo(Integer value) {
            addCriterion("SERV_PRICE =", value, "servPrice");
            return (Criteria) this;
        }

        public Criteria andServPriceNotEqualTo(Integer value) {
            addCriterion("SERV_PRICE <>", value, "servPrice");
            return (Criteria) this;
        }

        public Criteria andServPriceGreaterThan(Integer value) {
            addCriterion("SERV_PRICE >", value, "servPrice");
            return (Criteria) this;
        }

        public Criteria andServPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERV_PRICE >=", value, "servPrice");
            return (Criteria) this;
        }

        public Criteria andServPriceLessThan(Integer value) {
            addCriterion("SERV_PRICE <", value, "servPrice");
            return (Criteria) this;
        }

        public Criteria andServPriceLessThanOrEqualTo(Integer value) {
            addCriterion("SERV_PRICE <=", value, "servPrice");
            return (Criteria) this;
        }

        public Criteria andServPriceIn(List<Integer> values) {
            addCriterion("SERV_PRICE in", values, "servPrice");
            return (Criteria) this;
        }

        public Criteria andServPriceNotIn(List<Integer> values) {
            addCriterion("SERV_PRICE not in", values, "servPrice");
            return (Criteria) this;
        }

        public Criteria andServPriceBetween(Integer value1, Integer value2) {
            addCriterion("SERV_PRICE between", value1, value2, "servPrice");
            return (Criteria) this;
        }

        public Criteria andServPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("SERV_PRICE not between", value1, value2, "servPrice");
            return (Criteria) this;
        }

        public Criteria andServStarttimeIsNull() {
            addCriterion("SERV_STARTTIME is null");
            return (Criteria) this;
        }

        public Criteria andServStarttimeIsNotNull() {
            addCriterion("SERV_STARTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andServStarttimeEqualTo(Date value) {
            addCriterion("SERV_STARTTIME =", value, "servStarttime");
            return (Criteria) this;
        }

        public Criteria andServStarttimeNotEqualTo(Date value) {
            addCriterion("SERV_STARTTIME <>", value, "servStarttime");
            return (Criteria) this;
        }

        public Criteria andServStarttimeGreaterThan(Date value) {
            addCriterion("SERV_STARTTIME >", value, "servStarttime");
            return (Criteria) this;
        }

        public Criteria andServStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SERV_STARTTIME >=", value, "servStarttime");
            return (Criteria) this;
        }

        public Criteria andServStarttimeLessThan(Date value) {
            addCriterion("SERV_STARTTIME <", value, "servStarttime");
            return (Criteria) this;
        }

        public Criteria andServStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("SERV_STARTTIME <=", value, "servStarttime");
            return (Criteria) this;
        }

        public Criteria andServStarttimeIn(List<Date> values) {
            addCriterion("SERV_STARTTIME in", values, "servStarttime");
            return (Criteria) this;
        }

        public Criteria andServStarttimeNotIn(List<Date> values) {
            addCriterion("SERV_STARTTIME not in", values, "servStarttime");
            return (Criteria) this;
        }

        public Criteria andServStarttimeBetween(Date value1, Date value2) {
            addCriterion("SERV_STARTTIME between", value1, value2, "servStarttime");
            return (Criteria) this;
        }

        public Criteria andServStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("SERV_STARTTIME not between", value1, value2, "servStarttime");
            return (Criteria) this;
        }

        public Criteria andServStateIsNull() {
            addCriterion("SERV_STATE is null");
            return (Criteria) this;
        }

        public Criteria andServStateIsNotNull() {
            addCriterion("SERV_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andServStateEqualTo(Integer value) {
            addCriterion("SERV_STATE =", value, "servState");
            return (Criteria) this;
        }

        public Criteria andServStateNotEqualTo(Integer value) {
            addCriterion("SERV_STATE <>", value, "servState");
            return (Criteria) this;
        }

        public Criteria andServStateGreaterThan(Integer value) {
            addCriterion("SERV_STATE >", value, "servState");
            return (Criteria) this;
        }

        public Criteria andServStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERV_STATE >=", value, "servState");
            return (Criteria) this;
        }

        public Criteria andServStateLessThan(Integer value) {
            addCriterion("SERV_STATE <", value, "servState");
            return (Criteria) this;
        }

        public Criteria andServStateLessThanOrEqualTo(Integer value) {
            addCriterion("SERV_STATE <=", value, "servState");
            return (Criteria) this;
        }

        public Criteria andServStateIn(List<Integer> values) {
            addCriterion("SERV_STATE in", values, "servState");
            return (Criteria) this;
        }

        public Criteria andServStateNotIn(List<Integer> values) {
            addCriterion("SERV_STATE not in", values, "servState");
            return (Criteria) this;
        }

        public Criteria andServStateBetween(Integer value1, Integer value2) {
            addCriterion("SERV_STATE between", value1, value2, "servState");
            return (Criteria) this;
        }

        public Criteria andServStateNotBetween(Integer value1, Integer value2) {
            addCriterion("SERV_STATE not between", value1, value2, "servState");
            return (Criteria) this;
        }

        public Criteria andServBumberIsNull() {
            addCriterion("SERV_BUMBER is null");
            return (Criteria) this;
        }

        public Criteria andServBumberIsNotNull() {
            addCriterion("SERV_BUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andServBumberEqualTo(Integer value) {
            addCriterion("SERV_BUMBER =", value, "servBumber");
            return (Criteria) this;
        }

        public Criteria andServBumberNotEqualTo(Integer value) {
            addCriterion("SERV_BUMBER <>", value, "servBumber");
            return (Criteria) this;
        }

        public Criteria andServBumberGreaterThan(Integer value) {
            addCriterion("SERV_BUMBER >", value, "servBumber");
            return (Criteria) this;
        }

        public Criteria andServBumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERV_BUMBER >=", value, "servBumber");
            return (Criteria) this;
        }

        public Criteria andServBumberLessThan(Integer value) {
            addCriterion("SERV_BUMBER <", value, "servBumber");
            return (Criteria) this;
        }

        public Criteria andServBumberLessThanOrEqualTo(Integer value) {
            addCriterion("SERV_BUMBER <=", value, "servBumber");
            return (Criteria) this;
        }

        public Criteria andServBumberIn(List<Integer> values) {
            addCriterion("SERV_BUMBER in", values, "servBumber");
            return (Criteria) this;
        }

        public Criteria andServBumberNotIn(List<Integer> values) {
            addCriterion("SERV_BUMBER not in", values, "servBumber");
            return (Criteria) this;
        }

        public Criteria andServBumberBetween(Integer value1, Integer value2) {
            addCriterion("SERV_BUMBER between", value1, value2, "servBumber");
            return (Criteria) this;
        }

        public Criteria andServBumberNotBetween(Integer value1, Integer value2) {
            addCriterion("SERV_BUMBER not between", value1, value2, "servBumber");
            return (Criteria) this;
        }

        public Criteria andServProvidernameIsNull() {
            addCriterion("SERV_PROVIDERNAME is null");
            return (Criteria) this;
        }

        public Criteria andServProvidernameIsNotNull() {
            addCriterion("SERV_PROVIDERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andServProvidernameEqualTo(String value) {
            addCriterion("SERV_PROVIDERNAME =", value, "servProvidername");
            return (Criteria) this;
        }

        public Criteria andServProvidernameNotEqualTo(String value) {
            addCriterion("SERV_PROVIDERNAME <>", value, "servProvidername");
            return (Criteria) this;
        }

        public Criteria andServProvidernameGreaterThan(String value) {
            addCriterion("SERV_PROVIDERNAME >", value, "servProvidername");
            return (Criteria) this;
        }

        public Criteria andServProvidernameGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDERNAME >=", value, "servProvidername");
            return (Criteria) this;
        }

        public Criteria andServProvidernameLessThan(String value) {
            addCriterion("SERV_PROVIDERNAME <", value, "servProvidername");
            return (Criteria) this;
        }

        public Criteria andServProvidernameLessThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDERNAME <=", value, "servProvidername");
            return (Criteria) this;
        }

        public Criteria andServProvidernameLike(String value) {
            addCriterion("SERV_PROVIDERNAME like", value, "servProvidername");
            return (Criteria) this;
        }

        public Criteria andServProvidernameNotLike(String value) {
            addCriterion("SERV_PROVIDERNAME not like", value, "servProvidername");
            return (Criteria) this;
        }

        public Criteria andServProvidernameIn(List<String> values) {
            addCriterion("SERV_PROVIDERNAME in", values, "servProvidername");
            return (Criteria) this;
        }

        public Criteria andServProvidernameNotIn(List<String> values) {
            addCriterion("SERV_PROVIDERNAME not in", values, "servProvidername");
            return (Criteria) this;
        }

        public Criteria andServProvidernameBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDERNAME between", value1, value2, "servProvidername");
            return (Criteria) this;
        }

        public Criteria andServProvidernameNotBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDERNAME not between", value1, value2, "servProvidername");
            return (Criteria) this;
        }

        public Criteria andServRecommendedIsNull() {
            addCriterion("SERV_RECOMMENDED is null");
            return (Criteria) this;
        }

        public Criteria andServRecommendedIsNotNull() {
            addCriterion("SERV_RECOMMENDED is not null");
            return (Criteria) this;
        }

        public Criteria andServRecommendedEqualTo(Integer value) {
            addCriterion("SERV_RECOMMENDED =", value, "servRecommended");
            return (Criteria) this;
        }

        public Criteria andServRecommendedNotEqualTo(Integer value) {
            addCriterion("SERV_RECOMMENDED <>", value, "servRecommended");
            return (Criteria) this;
        }

        public Criteria andServRecommendedGreaterThan(Integer value) {
            addCriterion("SERV_RECOMMENDED >", value, "servRecommended");
            return (Criteria) this;
        }

        public Criteria andServRecommendedGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERV_RECOMMENDED >=", value, "servRecommended");
            return (Criteria) this;
        }

        public Criteria andServRecommendedLessThan(Integer value) {
            addCriterion("SERV_RECOMMENDED <", value, "servRecommended");
            return (Criteria) this;
        }

        public Criteria andServRecommendedLessThanOrEqualTo(Integer value) {
            addCriterion("SERV_RECOMMENDED <=", value, "servRecommended");
            return (Criteria) this;
        }

        public Criteria andServRecommendedIn(List<Integer> values) {
            addCriterion("SERV_RECOMMENDED in", values, "servRecommended");
            return (Criteria) this;
        }

        public Criteria andServRecommendedNotIn(List<Integer> values) {
            addCriterion("SERV_RECOMMENDED not in", values, "servRecommended");
            return (Criteria) this;
        }

        public Criteria andServRecommendedBetween(Integer value1, Integer value2) {
            addCriterion("SERV_RECOMMENDED between", value1, value2, "servRecommended");
            return (Criteria) this;
        }

        public Criteria andServRecommendedNotBetween(Integer value1, Integer value2) {
            addCriterion("SERV_RECOMMENDED not between", value1, value2, "servRecommended");
            return (Criteria) this;
        }

        public Criteria andServNecessaryIsNull() {
            addCriterion("SERV_NECESSARY is null");
            return (Criteria) this;
        }

        public Criteria andServNecessaryIsNotNull() {
            addCriterion("SERV_NECESSARY is not null");
            return (Criteria) this;
        }

        public Criteria andServNecessaryEqualTo(Integer value) {
            addCriterion("SERV_NECESSARY =", value, "servNecessary");
            return (Criteria) this;
        }

        public Criteria andServNecessaryNotEqualTo(Integer value) {
            addCriterion("SERV_NECESSARY <>", value, "servNecessary");
            return (Criteria) this;
        }

        public Criteria andServNecessaryGreaterThan(Integer value) {
            addCriterion("SERV_NECESSARY >", value, "servNecessary");
            return (Criteria) this;
        }

        public Criteria andServNecessaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERV_NECESSARY >=", value, "servNecessary");
            return (Criteria) this;
        }

        public Criteria andServNecessaryLessThan(Integer value) {
            addCriterion("SERV_NECESSARY <", value, "servNecessary");
            return (Criteria) this;
        }

        public Criteria andServNecessaryLessThanOrEqualTo(Integer value) {
            addCriterion("SERV_NECESSARY <=", value, "servNecessary");
            return (Criteria) this;
        }

        public Criteria andServNecessaryIn(List<Integer> values) {
            addCriterion("SERV_NECESSARY in", values, "servNecessary");
            return (Criteria) this;
        }

        public Criteria andServNecessaryNotIn(List<Integer> values) {
            addCriterion("SERV_NECESSARY not in", values, "servNecessary");
            return (Criteria) this;
        }

        public Criteria andServNecessaryBetween(Integer value1, Integer value2) {
            addCriterion("SERV_NECESSARY between", value1, value2, "servNecessary");
            return (Criteria) this;
        }

        public Criteria andServNecessaryNotBetween(Integer value1, Integer value2) {
            addCriterion("SERV_NECESSARY not between", value1, value2, "servNecessary");
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
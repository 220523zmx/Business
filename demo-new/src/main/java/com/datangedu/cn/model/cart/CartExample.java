package com.datangedu.cn.model.cart;

import java.util.ArrayList;
import java.util.List;

public class CartExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CartExample() {
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

        public Criteria andCartCustomeridIsNull() {
            addCriterion("CART_CUSTOMERID is null");
            return (Criteria) this;
        }

        public Criteria andCartCustomeridIsNotNull() {
            addCriterion("CART_CUSTOMERID is not null");
            return (Criteria) this;
        }

        public Criteria andCartCustomeridEqualTo(String value) {
            addCriterion("CART_CUSTOMERID =", value, "cartCustomerid");
            return (Criteria) this;
        }

        public Criteria andCartCustomeridNotEqualTo(String value) {
            addCriterion("CART_CUSTOMERID <>", value, "cartCustomerid");
            return (Criteria) this;
        }

        public Criteria andCartCustomeridGreaterThan(String value) {
            addCriterion("CART_CUSTOMERID >", value, "cartCustomerid");
            return (Criteria) this;
        }

        public Criteria andCartCustomeridGreaterThanOrEqualTo(String value) {
            addCriterion("CART_CUSTOMERID >=", value, "cartCustomerid");
            return (Criteria) this;
        }

        public Criteria andCartCustomeridLessThan(String value) {
            addCriterion("CART_CUSTOMERID <", value, "cartCustomerid");
            return (Criteria) this;
        }

        public Criteria andCartCustomeridLessThanOrEqualTo(String value) {
            addCriterion("CART_CUSTOMERID <=", value, "cartCustomerid");
            return (Criteria) this;
        }

        public Criteria andCartCustomeridLike(String value) {
            addCriterion("CART_CUSTOMERID like", value, "cartCustomerid");
            return (Criteria) this;
        }

        public Criteria andCartCustomeridNotLike(String value) {
            addCriterion("CART_CUSTOMERID not like", value, "cartCustomerid");
            return (Criteria) this;
        }

        public Criteria andCartCustomeridIn(List<String> values) {
            addCriterion("CART_CUSTOMERID in", values, "cartCustomerid");
            return (Criteria) this;
        }

        public Criteria andCartCustomeridNotIn(List<String> values) {
            addCriterion("CART_CUSTOMERID not in", values, "cartCustomerid");
            return (Criteria) this;
        }

        public Criteria andCartCustomeridBetween(String value1, String value2) {
            addCriterion("CART_CUSTOMERID between", value1, value2, "cartCustomerid");
            return (Criteria) this;
        }

        public Criteria andCartCustomeridNotBetween(String value1, String value2) {
            addCriterion("CART_CUSTOMERID not between", value1, value2, "cartCustomerid");
            return (Criteria) this;
        }

        public Criteria andCartProvideridIsNull() {
            addCriterion("CART_PROVIDERID is null");
            return (Criteria) this;
        }

        public Criteria andCartProvideridIsNotNull() {
            addCriterion("CART_PROVIDERID is not null");
            return (Criteria) this;
        }

        public Criteria andCartProvideridEqualTo(String value) {
            addCriterion("CART_PROVIDERID =", value, "cartProviderid");
            return (Criteria) this;
        }

        public Criteria andCartProvideridNotEqualTo(String value) {
            addCriterion("CART_PROVIDERID <>", value, "cartProviderid");
            return (Criteria) this;
        }

        public Criteria andCartProvideridGreaterThan(String value) {
            addCriterion("CART_PROVIDERID >", value, "cartProviderid");
            return (Criteria) this;
        }

        public Criteria andCartProvideridGreaterThanOrEqualTo(String value) {
            addCriterion("CART_PROVIDERID >=", value, "cartProviderid");
            return (Criteria) this;
        }

        public Criteria andCartProvideridLessThan(String value) {
            addCriterion("CART_PROVIDERID <", value, "cartProviderid");
            return (Criteria) this;
        }

        public Criteria andCartProvideridLessThanOrEqualTo(String value) {
            addCriterion("CART_PROVIDERID <=", value, "cartProviderid");
            return (Criteria) this;
        }

        public Criteria andCartProvideridLike(String value) {
            addCriterion("CART_PROVIDERID like", value, "cartProviderid");
            return (Criteria) this;
        }

        public Criteria andCartProvideridNotLike(String value) {
            addCriterion("CART_PROVIDERID not like", value, "cartProviderid");
            return (Criteria) this;
        }

        public Criteria andCartProvideridIn(List<String> values) {
            addCriterion("CART_PROVIDERID in", values, "cartProviderid");
            return (Criteria) this;
        }

        public Criteria andCartProvideridNotIn(List<String> values) {
            addCriterion("CART_PROVIDERID not in", values, "cartProviderid");
            return (Criteria) this;
        }

        public Criteria andCartProvideridBetween(String value1, String value2) {
            addCriterion("CART_PROVIDERID between", value1, value2, "cartProviderid");
            return (Criteria) this;
        }

        public Criteria andCartProvideridNotBetween(String value1, String value2) {
            addCriterion("CART_PROVIDERID not between", value1, value2, "cartProviderid");
            return (Criteria) this;
        }

        public Criteria andCartProductidIsNull() {
            addCriterion("CART_PRODUCTID is null");
            return (Criteria) this;
        }

        public Criteria andCartProductidIsNotNull() {
            addCriterion("CART_PRODUCTID is not null");
            return (Criteria) this;
        }

        public Criteria andCartProductidEqualTo(String value) {
            addCriterion("CART_PRODUCTID =", value, "cartProductid");
            return (Criteria) this;
        }

        public Criteria andCartProductidNotEqualTo(String value) {
            addCriterion("CART_PRODUCTID <>", value, "cartProductid");
            return (Criteria) this;
        }

        public Criteria andCartProductidGreaterThan(String value) {
            addCriterion("CART_PRODUCTID >", value, "cartProductid");
            return (Criteria) this;
        }

        public Criteria andCartProductidGreaterThanOrEqualTo(String value) {
            addCriterion("CART_PRODUCTID >=", value, "cartProductid");
            return (Criteria) this;
        }

        public Criteria andCartProductidLessThan(String value) {
            addCriterion("CART_PRODUCTID <", value, "cartProductid");
            return (Criteria) this;
        }

        public Criteria andCartProductidLessThanOrEqualTo(String value) {
            addCriterion("CART_PRODUCTID <=", value, "cartProductid");
            return (Criteria) this;
        }

        public Criteria andCartProductidLike(String value) {
            addCriterion("CART_PRODUCTID like", value, "cartProductid");
            return (Criteria) this;
        }

        public Criteria andCartProductidNotLike(String value) {
            addCriterion("CART_PRODUCTID not like", value, "cartProductid");
            return (Criteria) this;
        }

        public Criteria andCartProductidIn(List<String> values) {
            addCriterion("CART_PRODUCTID in", values, "cartProductid");
            return (Criteria) this;
        }

        public Criteria andCartProductidNotIn(List<String> values) {
            addCriterion("CART_PRODUCTID not in", values, "cartProductid");
            return (Criteria) this;
        }

        public Criteria andCartProductidBetween(String value1, String value2) {
            addCriterion("CART_PRODUCTID between", value1, value2, "cartProductid");
            return (Criteria) this;
        }

        public Criteria andCartProductidNotBetween(String value1, String value2) {
            addCriterion("CART_PRODUCTID not between", value1, value2, "cartProductid");
            return (Criteria) this;
        }

        public Criteria andCartPriceIsNull() {
            addCriterion("CART_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andCartPriceIsNotNull() {
            addCriterion("CART_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andCartPriceEqualTo(Integer value) {
            addCriterion("CART_PRICE =", value, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceNotEqualTo(Integer value) {
            addCriterion("CART_PRICE <>", value, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceGreaterThan(Integer value) {
            addCriterion("CART_PRICE >", value, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("CART_PRICE >=", value, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceLessThan(Integer value) {
            addCriterion("CART_PRICE <", value, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceLessThanOrEqualTo(Integer value) {
            addCriterion("CART_PRICE <=", value, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceIn(List<Integer> values) {
            addCriterion("CART_PRICE in", values, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceNotIn(List<Integer> values) {
            addCriterion("CART_PRICE not in", values, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceBetween(Integer value1, Integer value2) {
            addCriterion("CART_PRICE between", value1, value2, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("CART_PRICE not between", value1, value2, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartNumberIsNull() {
            addCriterion("CART_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andCartNumberIsNotNull() {
            addCriterion("CART_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andCartNumberEqualTo(Integer value) {
            addCriterion("CART_NUMBER =", value, "cartNumber");
            return (Criteria) this;
        }

        public Criteria andCartNumberNotEqualTo(Integer value) {
            addCriterion("CART_NUMBER <>", value, "cartNumber");
            return (Criteria) this;
        }

        public Criteria andCartNumberGreaterThan(Integer value) {
            addCriterion("CART_NUMBER >", value, "cartNumber");
            return (Criteria) this;
        }

        public Criteria andCartNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("CART_NUMBER >=", value, "cartNumber");
            return (Criteria) this;
        }

        public Criteria andCartNumberLessThan(Integer value) {
            addCriterion("CART_NUMBER <", value, "cartNumber");
            return (Criteria) this;
        }

        public Criteria andCartNumberLessThanOrEqualTo(Integer value) {
            addCriterion("CART_NUMBER <=", value, "cartNumber");
            return (Criteria) this;
        }

        public Criteria andCartNumberIn(List<Integer> values) {
            addCriterion("CART_NUMBER in", values, "cartNumber");
            return (Criteria) this;
        }

        public Criteria andCartNumberNotIn(List<Integer> values) {
            addCriterion("CART_NUMBER not in", values, "cartNumber");
            return (Criteria) this;
        }

        public Criteria andCartNumberBetween(Integer value1, Integer value2) {
            addCriterion("CART_NUMBER between", value1, value2, "cartNumber");
            return (Criteria) this;
        }

        public Criteria andCartNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("CART_NUMBER not between", value1, value2, "cartNumber");
            return (Criteria) this;
        }

        public Criteria andCartApriceIsNull() {
            addCriterion("CART_APRICE is null");
            return (Criteria) this;
        }

        public Criteria andCartApriceIsNotNull() {
            addCriterion("CART_APRICE is not null");
            return (Criteria) this;
        }

        public Criteria andCartApriceEqualTo(Integer value) {
            addCriterion("CART_APRICE =", value, "cartAprice");
            return (Criteria) this;
        }

        public Criteria andCartApriceNotEqualTo(Integer value) {
            addCriterion("CART_APRICE <>", value, "cartAprice");
            return (Criteria) this;
        }

        public Criteria andCartApriceGreaterThan(Integer value) {
            addCriterion("CART_APRICE >", value, "cartAprice");
            return (Criteria) this;
        }

        public Criteria andCartApriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("CART_APRICE >=", value, "cartAprice");
            return (Criteria) this;
        }

        public Criteria andCartApriceLessThan(Integer value) {
            addCriterion("CART_APRICE <", value, "cartAprice");
            return (Criteria) this;
        }

        public Criteria andCartApriceLessThanOrEqualTo(Integer value) {
            addCriterion("CART_APRICE <=", value, "cartAprice");
            return (Criteria) this;
        }

        public Criteria andCartApriceIn(List<Integer> values) {
            addCriterion("CART_APRICE in", values, "cartAprice");
            return (Criteria) this;
        }

        public Criteria andCartApriceNotIn(List<Integer> values) {
            addCriterion("CART_APRICE not in", values, "cartAprice");
            return (Criteria) this;
        }

        public Criteria andCartApriceBetween(Integer value1, Integer value2) {
            addCriterion("CART_APRICE between", value1, value2, "cartAprice");
            return (Criteria) this;
        }

        public Criteria andCartApriceNotBetween(Integer value1, Integer value2) {
            addCriterion("CART_APRICE not between", value1, value2, "cartAprice");
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
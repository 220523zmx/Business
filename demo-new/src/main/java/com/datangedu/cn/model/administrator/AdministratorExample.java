package com.datangedu.cn.model.administrator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdministratorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    
    
    protected int pageSize;
	
	protected int pageNum;
	
	protected String likeName;
    
	

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = (pageSize-1)*pageNum;
	}
	
	public int getPageNum() {
		return pageNum;
	}

	public void getPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
    
	public String getLikeName() {
		return likeName;
	}

	public void setLikeName(String likeName) {
		this.likeName = likeName;
	}

	
	
    public AdministratorExample() {
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
        likeName = null;
        pageSize = 1;
        pageNum = 20;
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

        public Criteria andAdmiIdIsNull() {
            addCriterion("ADMI_ID is null");
            return (Criteria) this;
        }

        public Criteria andAdmiIdIsNotNull() {
            addCriterion("ADMI_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAdmiIdEqualTo(String value) {
            addCriterion("ADMI_ID =", value, "admiId");
            return (Criteria) this;
        }

        public Criteria andAdmiIdNotEqualTo(String value) {
            addCriterion("ADMI_ID <>", value, "admiId");
            return (Criteria) this;
        }

        public Criteria andAdmiIdGreaterThan(String value) {
            addCriterion("ADMI_ID >", value, "admiId");
            return (Criteria) this;
        }

        public Criteria andAdmiIdGreaterThanOrEqualTo(String value) {
            addCriterion("ADMI_ID >=", value, "admiId");
            return (Criteria) this;
        }

        public Criteria andAdmiIdLessThan(String value) {
            addCriterion("ADMI_ID <", value, "admiId");
            return (Criteria) this;
        }

        public Criteria andAdmiIdLessThanOrEqualTo(String value) {
            addCriterion("ADMI_ID <=", value, "admiId");
            return (Criteria) this;
        }

        public Criteria andAdmiIdLike(String value) {
            addCriterion("ADMI_ID like", value, "admiId");
            return (Criteria) this;
        }

        public Criteria andAdmiIdNotLike(String value) {
            addCriterion("ADMI_ID not like", value, "admiId");
            return (Criteria) this;
        }

        public Criteria andAdmiIdIn(List<String> values) {
            addCriterion("ADMI_ID in", values, "admiId");
            return (Criteria) this;
        }

        public Criteria andAdmiIdNotIn(List<String> values) {
            addCriterion("ADMI_ID not in", values, "admiId");
            return (Criteria) this;
        }

        public Criteria andAdmiIdBetween(String value1, String value2) {
            addCriterion("ADMI_ID between", value1, value2, "admiId");
            return (Criteria) this;
        }

        public Criteria andAdmiIdNotBetween(String value1, String value2) {
            addCriterion("ADMI_ID not between", value1, value2, "admiId");
            return (Criteria) this;
        }

        public Criteria andAdmiPhoneIsNull() {
            addCriterion("ADMI_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andAdmiPhoneIsNotNull() {
            addCriterion("ADMI_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andAdmiPhoneEqualTo(String value) {
            addCriterion("ADMI_PHONE =", value, "admiPhone");
            return (Criteria) this;
        }

        public Criteria andAdmiPhoneNotEqualTo(String value) {
            addCriterion("ADMI_PHONE <>", value, "admiPhone");
            return (Criteria) this;
        }

        public Criteria andAdmiPhoneGreaterThan(String value) {
            addCriterion("ADMI_PHONE >", value, "admiPhone");
            return (Criteria) this;
        }

        public Criteria andAdmiPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("ADMI_PHONE >=", value, "admiPhone");
            return (Criteria) this;
        }

        public Criteria andAdmiPhoneLessThan(String value) {
            addCriterion("ADMI_PHONE <", value, "admiPhone");
            return (Criteria) this;
        }

        public Criteria andAdmiPhoneLessThanOrEqualTo(String value) {
            addCriterion("ADMI_PHONE <=", value, "admiPhone");
            return (Criteria) this;
        }

        public Criteria andAdmiPhoneLike(String value) {
            addCriterion("ADMI_PHONE like", value, "admiPhone");
            return (Criteria) this;
        }

        public Criteria andAdmiPhoneNotLike(String value) {
            addCriterion("ADMI_PHONE not like", value, "admiPhone");
            return (Criteria) this;
        }

        public Criteria andAdmiPhoneIn(List<String> values) {
            addCriterion("ADMI_PHONE in", values, "admiPhone");
            return (Criteria) this;
        }

        public Criteria andAdmiPhoneNotIn(List<String> values) {
            addCriterion("ADMI_PHONE not in", values, "admiPhone");
            return (Criteria) this;
        }

        public Criteria andAdmiPhoneBetween(String value1, String value2) {
            addCriterion("ADMI_PHONE between", value1, value2, "admiPhone");
            return (Criteria) this;
        }

        public Criteria andAdmiPhoneNotBetween(String value1, String value2) {
            addCriterion("ADMI_PHONE not between", value1, value2, "admiPhone");
            return (Criteria) this;
        }

        public Criteria andAdmiPasswordIsNull() {
            addCriterion("ADMI_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andAdmiPasswordIsNotNull() {
            addCriterion("ADMI_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andAdmiPasswordEqualTo(String value) {
            addCriterion("ADMI_PASSWORD =", value, "admiPassword");
            return (Criteria) this;
        }

        public Criteria andAdmiPasswordNotEqualTo(String value) {
            addCriterion("ADMI_PASSWORD <>", value, "admiPassword");
            return (Criteria) this;
        }

        public Criteria andAdmiPasswordGreaterThan(String value) {
            addCriterion("ADMI_PASSWORD >", value, "admiPassword");
            return (Criteria) this;
        }

        public Criteria andAdmiPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("ADMI_PASSWORD >=", value, "admiPassword");
            return (Criteria) this;
        }

        public Criteria andAdmiPasswordLessThan(String value) {
            addCriterion("ADMI_PASSWORD <", value, "admiPassword");
            return (Criteria) this;
        }

        public Criteria andAdmiPasswordLessThanOrEqualTo(String value) {
            addCriterion("ADMI_PASSWORD <=", value, "admiPassword");
            return (Criteria) this;
        }

        public Criteria andAdmiPasswordLike(String value) {
            addCriterion("ADMI_PASSWORD like", value, "admiPassword");
            return (Criteria) this;
        }

        public Criteria andAdmiPasswordNotLike(String value) {
            addCriterion("ADMI_PASSWORD not like", value, "admiPassword");
            return (Criteria) this;
        }

        public Criteria andAdmiPasswordIn(List<String> values) {
            addCriterion("ADMI_PASSWORD in", values, "admiPassword");
            return (Criteria) this;
        }

        public Criteria andAdmiPasswordNotIn(List<String> values) {
            addCriterion("ADMI_PASSWORD not in", values, "admiPassword");
            return (Criteria) this;
        }

        public Criteria andAdmiPasswordBetween(String value1, String value2) {
            addCriterion("ADMI_PASSWORD between", value1, value2, "admiPassword");
            return (Criteria) this;
        }

        public Criteria andAdmiPasswordNotBetween(String value1, String value2) {
            addCriterion("ADMI_PASSWORD not between", value1, value2, "admiPassword");
            return (Criteria) this;
        }

        public Criteria andAdmiNameIsNull() {
            addCriterion("ADMI_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAdmiNameIsNotNull() {
            addCriterion("ADMI_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAdmiNameEqualTo(String value) {
            addCriterion("ADMI_NAME =", value, "admiName");
            return (Criteria) this;
        }

        public Criteria andAdmiNameNotEqualTo(String value) {
            addCriterion("ADMI_NAME <>", value, "admiName");
            return (Criteria) this;
        }

        public Criteria andAdmiNameGreaterThan(String value) {
            addCriterion("ADMI_NAME >", value, "admiName");
            return (Criteria) this;
        }

        public Criteria andAdmiNameGreaterThanOrEqualTo(String value) {
            addCriterion("ADMI_NAME >=", value, "admiName");
            return (Criteria) this;
        }

        public Criteria andAdmiNameLessThan(String value) {
            addCriterion("ADMI_NAME <", value, "admiName");
            return (Criteria) this;
        }

        public Criteria andAdmiNameLessThanOrEqualTo(String value) {
            addCriterion("ADMI_NAME <=", value, "admiName");
            return (Criteria) this;
        }

        public Criteria andAdmiNameLike(String value) {
            addCriterion("ADMI_NAME like", value, "admiName");
            return (Criteria) this;
        }

        public Criteria andAdmiNameNotLike(String value) {
            addCriterion("ADMI_NAME not like", value, "admiName");
            return (Criteria) this;
        }

        public Criteria andAdmiNameIn(List<String> values) {
            addCriterion("ADMI_NAME in", values, "admiName");
            return (Criteria) this;
        }

        public Criteria andAdmiNameNotIn(List<String> values) {
            addCriterion("ADMI_NAME not in", values, "admiName");
            return (Criteria) this;
        }

        public Criteria andAdmiNameBetween(String value1, String value2) {
            addCriterion("ADMI_NAME between", value1, value2, "admiName");
            return (Criteria) this;
        }

        public Criteria andAdmiNameNotBetween(String value1, String value2) {
            addCriterion("ADMI_NAME not between", value1, value2, "admiName");
            return (Criteria) this;
        }

        public Criteria andAdmiEmailIsNull() {
            addCriterion("ADMI_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andAdmiEmailIsNotNull() {
            addCriterion("ADMI_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andAdmiEmailEqualTo(String value) {
            addCriterion("ADMI_EMAIL =", value, "admiEmail");
            return (Criteria) this;
        }

        public Criteria andAdmiEmailNotEqualTo(String value) {
            addCriterion("ADMI_EMAIL <>", value, "admiEmail");
            return (Criteria) this;
        }

        public Criteria andAdmiEmailGreaterThan(String value) {
            addCriterion("ADMI_EMAIL >", value, "admiEmail");
            return (Criteria) this;
        }

        public Criteria andAdmiEmailGreaterThanOrEqualTo(String value) {
            addCriterion("ADMI_EMAIL >=", value, "admiEmail");
            return (Criteria) this;
        }

        public Criteria andAdmiEmailLessThan(String value) {
            addCriterion("ADMI_EMAIL <", value, "admiEmail");
            return (Criteria) this;
        }

        public Criteria andAdmiEmailLessThanOrEqualTo(String value) {
            addCriterion("ADMI_EMAIL <=", value, "admiEmail");
            return (Criteria) this;
        }

        public Criteria andAdmiEmailLike(String value) {
            addCriterion("ADMI_EMAIL like", value, "admiEmail");
            return (Criteria) this;
        }

        public Criteria andAdmiEmailNotLike(String value) {
            addCriterion("ADMI_EMAIL not like", value, "admiEmail");
            return (Criteria) this;
        }

        public Criteria andAdmiEmailIn(List<String> values) {
            addCriterion("ADMI_EMAIL in", values, "admiEmail");
            return (Criteria) this;
        }

        public Criteria andAdmiEmailNotIn(List<String> values) {
            addCriterion("ADMI_EMAIL not in", values, "admiEmail");
            return (Criteria) this;
        }

        public Criteria andAdmiEmailBetween(String value1, String value2) {
            addCriterion("ADMI_EMAIL between", value1, value2, "admiEmail");
            return (Criteria) this;
        }

        public Criteria andAdmiEmailNotBetween(String value1, String value2) {
            addCriterion("ADMI_EMAIL not between", value1, value2, "admiEmail");
            return (Criteria) this;
        }

        public Criteria andAdmiStateIsNull() {
            addCriterion("ADMI_STATE is null");
            return (Criteria) this;
        }

        public Criteria andAdmiStateIsNotNull() {
            addCriterion("ADMI_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andAdmiStateEqualTo(Integer value) {
            addCriterion("ADMI_STATE =", value, "admiState");
            return (Criteria) this;
        }

        public Criteria andAdmiStateNotEqualTo(Integer value) {
            addCriterion("ADMI_STATE <>", value, "admiState");
            return (Criteria) this;
        }

        public Criteria andAdmiStateGreaterThan(Integer value) {
            addCriterion("ADMI_STATE >", value, "admiState");
            return (Criteria) this;
        }

        public Criteria andAdmiStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("ADMI_STATE >=", value, "admiState");
            return (Criteria) this;
        }

        public Criteria andAdmiStateLessThan(Integer value) {
            addCriterion("ADMI_STATE <", value, "admiState");
            return (Criteria) this;
        }

        public Criteria andAdmiStateLessThanOrEqualTo(Integer value) {
            addCriterion("ADMI_STATE <=", value, "admiState");
            return (Criteria) this;
        }

        public Criteria andAdmiStateIn(List<Integer> values) {
            addCriterion("ADMI_STATE in", values, "admiState");
            return (Criteria) this;
        }

        public Criteria andAdmiStateNotIn(List<Integer> values) {
            addCriterion("ADMI_STATE not in", values, "admiState");
            return (Criteria) this;
        }

        public Criteria andAdmiStateBetween(Integer value1, Integer value2) {
            addCriterion("ADMI_STATE between", value1, value2, "admiState");
            return (Criteria) this;
        }

        public Criteria andAdmiStateNotBetween(Integer value1, Integer value2) {
            addCriterion("ADMI_STATE not between", value1, value2, "admiState");
            return (Criteria) this;
        }

        public Criteria andAdmiCretimeIsNull() {
            addCriterion("ADMI_CRETIME is null");
            return (Criteria) this;
        }

        public Criteria andAdmiCretimeIsNotNull() {
            addCriterion("ADMI_CRETIME is not null");
            return (Criteria) this;
        }

        public Criteria andAdmiCretimeEqualTo(Date value) {
            addCriterion("ADMI_CRETIME =", value, "admiCretime");
            return (Criteria) this;
        }

        public Criteria andAdmiCretimeNotEqualTo(Date value) {
            addCriterion("ADMI_CRETIME <>", value, "admiCretime");
            return (Criteria) this;
        }

        public Criteria andAdmiCretimeGreaterThan(Date value) {
            addCriterion("ADMI_CRETIME >", value, "admiCretime");
            return (Criteria) this;
        }

        public Criteria andAdmiCretimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ADMI_CRETIME >=", value, "admiCretime");
            return (Criteria) this;
        }

        public Criteria andAdmiCretimeLessThan(Date value) {
            addCriterion("ADMI_CRETIME <", value, "admiCretime");
            return (Criteria) this;
        }

        public Criteria andAdmiCretimeLessThanOrEqualTo(Date value) {
            addCriterion("ADMI_CRETIME <=", value, "admiCretime");
            return (Criteria) this;
        }

        public Criteria andAdmiCretimeIn(List<Date> values) {
            addCriterion("ADMI_CRETIME in", values, "admiCretime");
            return (Criteria) this;
        }

        public Criteria andAdmiCretimeNotIn(List<Date> values) {
            addCriterion("ADMI_CRETIME not in", values, "admiCretime");
            return (Criteria) this;
        }

        public Criteria andAdmiCretimeBetween(Date value1, Date value2) {
            addCriterion("ADMI_CRETIME between", value1, value2, "admiCretime");
            return (Criteria) this;
        }

        public Criteria andAdmiCretimeNotBetween(Date value1, Date value2) {
            addCriterion("ADMI_CRETIME not between", value1, value2, "admiCretime");
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
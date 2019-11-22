package com.datangedu.cn.model.serviceprovider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class ServiceproviderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    protected int pagesize;
    public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = (pagesize-1)*pagesnum;
	}

	public int getPagesnum() {
		return pagesnum;
	}

	public void setPagesnum(int pagesnum) {
		this.pagesnum = pagesnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected int pagesnum;
    protected String name;
    

    public ServiceproviderExample() {
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
        pagesize=1;
        pagesnum=2;
        name=null;
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

        public Criteria andServProviderIdIsNull() {
            addCriterion("SERV_PROVIDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andServProviderIdIsNotNull() {
            addCriterion("SERV_PROVIDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andServProviderIdEqualTo(String value) {
            addCriterion("SERV_PROVIDER_ID =", value, "servProviderId");
            return (Criteria) this;
        }

        public Criteria andServProviderIdNotEqualTo(String value) {
            addCriterion("SERV_PROVIDER_ID <>", value, "servProviderId");
            return (Criteria) this;
        }

        public Criteria andServProviderIdGreaterThan(String value) {
            addCriterion("SERV_PROVIDER_ID >", value, "servProviderId");
            return (Criteria) this;
        }

        public Criteria andServProviderIdGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_ID >=", value, "servProviderId");
            return (Criteria) this;
        }

        public Criteria andServProviderIdLessThan(String value) {
            addCriterion("SERV_PROVIDER_ID <", value, "servProviderId");
            return (Criteria) this;
        }

        public Criteria andServProviderIdLessThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_ID <=", value, "servProviderId");
            return (Criteria) this;
        }

        public Criteria andServProviderIdLike(String value) {
            addCriterion("SERV_PROVIDER_ID like", value, "servProviderId");
            return (Criteria) this;
        }

        public Criteria andServProviderIdNotLike(String value) {
            addCriterion("SERV_PROVIDER_ID not like", value, "servProviderId");
            return (Criteria) this;
        }

        public Criteria andServProviderIdIn(List<String> values) {
            addCriterion("SERV_PROVIDER_ID in", values, "servProviderId");
            return (Criteria) this;
        }

        public Criteria andServProviderIdNotIn(List<String> values) {
            addCriterion("SERV_PROVIDER_ID not in", values, "servProviderId");
            return (Criteria) this;
        }

        public Criteria andServProviderIdBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_ID between", value1, value2, "servProviderId");
            return (Criteria) this;
        }

        public Criteria andServProviderIdNotBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_ID not between", value1, value2, "servProviderId");
            return (Criteria) this;
        }

        public Criteria andServProviderNameIsNull() {
            addCriterion("SERV_PROVIDER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andServProviderNameIsNotNull() {
            addCriterion("SERV_PROVIDER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andServProviderNameEqualTo(String value) {
            addCriterion("SERV_PROVIDER_NAME =", value, "servProviderName");
            return (Criteria) this;
        }

        public Criteria andServProviderNameNotEqualTo(String value) {
            addCriterion("SERV_PROVIDER_NAME <>", value, "servProviderName");
            return (Criteria) this;
        }

        public Criteria andServProviderNameGreaterThan(String value) {
            addCriterion("SERV_PROVIDER_NAME >", value, "servProviderName");
            return (Criteria) this;
        }

        public Criteria andServProviderNameGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_NAME >=", value, "servProviderName");
            return (Criteria) this;
        }

        public Criteria andServProviderNameLessThan(String value) {
            addCriterion("SERV_PROVIDER_NAME <", value, "servProviderName");
            return (Criteria) this;
        }

        public Criteria andServProviderNameLessThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_NAME <=", value, "servProviderName");
            return (Criteria) this;
        }

        public Criteria andServProviderNameLike(String value) {
            addCriterion("SERV_PROVIDER_NAME like", value, "servProviderName");
            return (Criteria) this;
        }

        public Criteria andServProviderNameNotLike(String value) {
            addCriterion("SERV_PROVIDER_NAME not like", value, "servProviderName");
            return (Criteria) this;
        }

        public Criteria andServProviderNameIn(List<String> values) {
            addCriterion("SERV_PROVIDER_NAME in", values, "servProviderName");
            return (Criteria) this;
        }

        public Criteria andServProviderNameNotIn(List<String> values) {
            addCriterion("SERV_PROVIDER_NAME not in", values, "servProviderName");
            return (Criteria) this;
        }

        public Criteria andServProviderNameBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_NAME between", value1, value2, "servProviderName");
            return (Criteria) this;
        }

        public Criteria andServProviderNameNotBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_NAME not between", value1, value2, "servProviderName");
            return (Criteria) this;
        }

        public Criteria andServProviderRegionIsNull() {
            addCriterion("SERV_PROVIDER_REGION is null");
            return (Criteria) this;
        }

        public Criteria andServProviderRegionIsNotNull() {
            addCriterion("SERV_PROVIDER_REGION is not null");
            return (Criteria) this;
        }

        public Criteria andServProviderRegionEqualTo(String value) {
            addCriterion("SERV_PROVIDER_REGION =", value, "servProviderRegion");
            return (Criteria) this;
        }

        public Criteria andServProviderRegionNotEqualTo(String value) {
            addCriterion("SERV_PROVIDER_REGION <>", value, "servProviderRegion");
            return (Criteria) this;
        }

        public Criteria andServProviderRegionGreaterThan(String value) {
            addCriterion("SERV_PROVIDER_REGION >", value, "servProviderRegion");
            return (Criteria) this;
        }

        public Criteria andServProviderRegionGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_REGION >=", value, "servProviderRegion");
            return (Criteria) this;
        }

        public Criteria andServProviderRegionLessThan(String value) {
            addCriterion("SERV_PROVIDER_REGION <", value, "servProviderRegion");
            return (Criteria) this;
        }

        public Criteria andServProviderRegionLessThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_REGION <=", value, "servProviderRegion");
            return (Criteria) this;
        }

        public Criteria andServProviderRegionLike(String value) {
            addCriterion("SERV_PROVIDER_REGION like", value, "servProviderRegion");
            return (Criteria) this;
        }

        public Criteria andServProviderRegionNotLike(String value) {
            addCriterion("SERV_PROVIDER_REGION not like", value, "servProviderRegion");
            return (Criteria) this;
        }

        public Criteria andServProviderRegionIn(List<String> values) {
            addCriterion("SERV_PROVIDER_REGION in", values, "servProviderRegion");
            return (Criteria) this;
        }

        public Criteria andServProviderRegionNotIn(List<String> values) {
            addCriterion("SERV_PROVIDER_REGION not in", values, "servProviderRegion");
            return (Criteria) this;
        }

        public Criteria andServProviderRegionBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_REGION between", value1, value2, "servProviderRegion");
            return (Criteria) this;
        }

        public Criteria andServProviderRegionNotBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_REGION not between", value1, value2, "servProviderRegion");
            return (Criteria) this;
        }

        public Criteria andServProviderPhoneIsNull() {
            addCriterion("SERV_PROVIDER_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andServProviderPhoneIsNotNull() {
            addCriterion("SERV_PROVIDER_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andServProviderPhoneEqualTo(String value) {
            addCriterion("SERV_PROVIDER_PHONE =", value, "servProviderPhone");
            return (Criteria) this;
        }

        public Criteria andServProviderPhoneNotEqualTo(String value) {
            addCriterion("SERV_PROVIDER_PHONE <>", value, "servProviderPhone");
            return (Criteria) this;
        }

        public Criteria andServProviderPhoneGreaterThan(String value) {
            addCriterion("SERV_PROVIDER_PHONE >", value, "servProviderPhone");
            return (Criteria) this;
        }

        public Criteria andServProviderPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_PHONE >=", value, "servProviderPhone");
            return (Criteria) this;
        }

        public Criteria andServProviderPhoneLessThan(String value) {
            addCriterion("SERV_PROVIDER_PHONE <", value, "servProviderPhone");
            return (Criteria) this;
        }

        public Criteria andServProviderPhoneLessThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_PHONE <=", value, "servProviderPhone");
            return (Criteria) this;
        }

        public Criteria andServProviderPhoneLike(String value) {
            addCriterion("SERV_PROVIDER_PHONE like", value, "servProviderPhone");
            return (Criteria) this;
        }

        public Criteria andServProviderPhoneNotLike(String value) {
            addCriterion("SERV_PROVIDER_PHONE not like", value, "servProviderPhone");
            return (Criteria) this;
        }

        public Criteria andServProviderPhoneIn(List<String> values) {
            addCriterion("SERV_PROVIDER_PHONE in", values, "servProviderPhone");
            return (Criteria) this;
        }

        public Criteria andServProviderPhoneNotIn(List<String> values) {
            addCriterion("SERV_PROVIDER_PHONE not in", values, "servProviderPhone");
            return (Criteria) this;
        }

        public Criteria andServProviderPhoneBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_PHONE between", value1, value2, "servProviderPhone");
            return (Criteria) this;
        }

        public Criteria andServProviderPhoneNotBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_PHONE not between", value1, value2, "servProviderPhone");
            return (Criteria) this;
        }

        public Criteria andServProviderPasswordIsNull() {
            addCriterion("SERV_PROVIDER_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andServProviderPasswordIsNotNull() {
            addCriterion("SERV_PROVIDER_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andServProviderPasswordEqualTo(String value) {
            addCriterion("SERV_PROVIDER_PASSWORD =", value, "servProviderPassword");
            return (Criteria) this;
        }

        public Criteria andServProviderPasswordNotEqualTo(String value) {
            addCriterion("SERV_PROVIDER_PASSWORD <>", value, "servProviderPassword");
            return (Criteria) this;
        }

        public Criteria andServProviderPasswordGreaterThan(String value) {
            addCriterion("SERV_PROVIDER_PASSWORD >", value, "servProviderPassword");
            return (Criteria) this;
        }

        public Criteria andServProviderPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_PASSWORD >=", value, "servProviderPassword");
            return (Criteria) this;
        }

        public Criteria andServProviderPasswordLessThan(String value) {
            addCriterion("SERV_PROVIDER_PASSWORD <", value, "servProviderPassword");
            return (Criteria) this;
        }

        public Criteria andServProviderPasswordLessThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_PASSWORD <=", value, "servProviderPassword");
            return (Criteria) this;
        }

        public Criteria andServProviderPasswordLike(String value) {
            addCriterion("SERV_PROVIDER_PASSWORD like", value, "servProviderPassword");
            return (Criteria) this;
        }

        public Criteria andServProviderPasswordNotLike(String value) {
            addCriterion("SERV_PROVIDER_PASSWORD not like", value, "servProviderPassword");
            return (Criteria) this;
        }

        public Criteria andServProviderPasswordIn(List<String> values) {
            addCriterion("SERV_PROVIDER_PASSWORD in", values, "servProviderPassword");
            return (Criteria) this;
        }

        public Criteria andServProviderPasswordNotIn(List<String> values) {
            addCriterion("SERV_PROVIDER_PASSWORD not in", values, "servProviderPassword");
            return (Criteria) this;
        }

        public Criteria andServProviderPasswordBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_PASSWORD between", value1, value2, "servProviderPassword");
            return (Criteria) this;
        }

        public Criteria andServProviderPasswordNotBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_PASSWORD not between", value1, value2, "servProviderPassword");
            return (Criteria) this;
        }

        public Criteria andServProviderStateIsNull() {
            addCriterion("SERV_PROVIDER_STATE is null");
            return (Criteria) this;
        }

        public Criteria andServProviderStateIsNotNull() {
            addCriterion("SERV_PROVIDER_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andServProviderStateEqualTo(Integer value) {
            addCriterion("SERV_PROVIDER_STATE =", value, "servProviderState");
            return (Criteria) this;
        }

        public Criteria andServProviderStateNotEqualTo(Integer value) {
            addCriterion("SERV_PROVIDER_STATE <>", value, "servProviderState");
            return (Criteria) this;
        }

        public Criteria andServProviderStateGreaterThan(Integer value) {
            addCriterion("SERV_PROVIDER_STATE >", value, "servProviderState");
            return (Criteria) this;
        }

        public Criteria andServProviderStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERV_PROVIDER_STATE >=", value, "servProviderState");
            return (Criteria) this;
        }

        public Criteria andServProviderStateLessThan(Integer value) {
            addCriterion("SERV_PROVIDER_STATE <", value, "servProviderState");
            return (Criteria) this;
        }

        public Criteria andServProviderStateLessThanOrEqualTo(Integer value) {
            addCriterion("SERV_PROVIDER_STATE <=", value, "servProviderState");
            return (Criteria) this;
        }

        public Criteria andServProviderStateIn(List<Integer> values) {
            addCriterion("SERV_PROVIDER_STATE in", values, "servProviderState");
            return (Criteria) this;
        }

        public Criteria andServProviderStateNotIn(List<Integer> values) {
            addCriterion("SERV_PROVIDER_STATE not in", values, "servProviderState");
            return (Criteria) this;
        }

        public Criteria andServProviderStateBetween(Integer value1, Integer value2) {
            addCriterion("SERV_PROVIDER_STATE between", value1, value2, "servProviderState");
            return (Criteria) this;
        }

        public Criteria andServProviderStateNotBetween(Integer value1, Integer value2) {
            addCriterion("SERV_PROVIDER_STATE not between", value1, value2, "servProviderState");
            return (Criteria) this;
        }

        public Criteria andServProviderIntroductionIsNull() {
            addCriterion("SERV_PROVIDER_INTRODUCTION is null");
            return (Criteria) this;
        }

        public Criteria andServProviderIntroductionIsNotNull() {
            addCriterion("SERV_PROVIDER_INTRODUCTION is not null");
            return (Criteria) this;
        }

        public Criteria andServProviderIntroductionEqualTo(String value) {
            addCriterion("SERV_PROVIDER_INTRODUCTION =", value, "servProviderIntroduction");
            return (Criteria) this;
        }

        public Criteria andServProviderIntroductionNotEqualTo(String value) {
            addCriterion("SERV_PROVIDER_INTRODUCTION <>", value, "servProviderIntroduction");
            return (Criteria) this;
        }

        public Criteria andServProviderIntroductionGreaterThan(String value) {
            addCriterion("SERV_PROVIDER_INTRODUCTION >", value, "servProviderIntroduction");
            return (Criteria) this;
        }

        public Criteria andServProviderIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_INTRODUCTION >=", value, "servProviderIntroduction");
            return (Criteria) this;
        }

        public Criteria andServProviderIntroductionLessThan(String value) {
            addCriterion("SERV_PROVIDER_INTRODUCTION <", value, "servProviderIntroduction");
            return (Criteria) this;
        }

        public Criteria andServProviderIntroductionLessThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_INTRODUCTION <=", value, "servProviderIntroduction");
            return (Criteria) this;
        }

        public Criteria andServProviderIntroductionLike(String value) {
            addCriterion("SERV_PROVIDER_INTRODUCTION like", value, "servProviderIntroduction");
            return (Criteria) this;
        }

        public Criteria andServProviderIntroductionNotLike(String value) {
            addCriterion("SERV_PROVIDER_INTRODUCTION not like", value, "servProviderIntroduction");
            return (Criteria) this;
        }

        public Criteria andServProviderIntroductionIn(List<String> values) {
            addCriterion("SERV_PROVIDER_INTRODUCTION in", values, "servProviderIntroduction");
            return (Criteria) this;
        }

        public Criteria andServProviderIntroductionNotIn(List<String> values) {
            addCriterion("SERV_PROVIDER_INTRODUCTION not in", values, "servProviderIntroduction");
            return (Criteria) this;
        }

        public Criteria andServProviderIntroductionBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_INTRODUCTION between", value1, value2, "servProviderIntroduction");
            return (Criteria) this;
        }

        public Criteria andServProviderIntroductionNotBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_INTRODUCTION not between", value1, value2, "servProviderIntroduction");
            return (Criteria) this;
        }

        public Criteria andServProviderEmailIsNull() {
            addCriterion("SERV_PROVIDER_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andServProviderEmailIsNotNull() {
            addCriterion("SERV_PROVIDER_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andServProviderEmailEqualTo(String value) {
            addCriterion("SERV_PROVIDER_EMAIL =", value, "servProviderEmail");
            return (Criteria) this;
        }

        public Criteria andServProviderEmailNotEqualTo(String value) {
            addCriterion("SERV_PROVIDER_EMAIL <>", value, "servProviderEmail");
            return (Criteria) this;
        }

        public Criteria andServProviderEmailGreaterThan(String value) {
            addCriterion("SERV_PROVIDER_EMAIL >", value, "servProviderEmail");
            return (Criteria) this;
        }

        public Criteria andServProviderEmailGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_EMAIL >=", value, "servProviderEmail");
            return (Criteria) this;
        }

        public Criteria andServProviderEmailLessThan(String value) {
            addCriterion("SERV_PROVIDER_EMAIL <", value, "servProviderEmail");
            return (Criteria) this;
        }

        public Criteria andServProviderEmailLessThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_EMAIL <=", value, "servProviderEmail");
            return (Criteria) this;
        }

        public Criteria andServProviderEmailLike(String value) {
            addCriterion("SERV_PROVIDER_EMAIL like", value, "servProviderEmail");
            return (Criteria) this;
        }

        public Criteria andServProviderEmailNotLike(String value) {
            addCriterion("SERV_PROVIDER_EMAIL not like", value, "servProviderEmail");
            return (Criteria) this;
        }

        public Criteria andServProviderEmailIn(List<String> values) {
            addCriterion("SERV_PROVIDER_EMAIL in", values, "servProviderEmail");
            return (Criteria) this;
        }

        public Criteria andServProviderEmailNotIn(List<String> values) {
            addCriterion("SERV_PROVIDER_EMAIL not in", values, "servProviderEmail");
            return (Criteria) this;
        }

        public Criteria andServProviderEmailBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_EMAIL between", value1, value2, "servProviderEmail");
            return (Criteria) this;
        }

        public Criteria andServProviderEmailNotBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_EMAIL not between", value1, value2, "servProviderEmail");
            return (Criteria) this;
        }

        public Criteria andServProviderStarttimeIsNull() {
            addCriterion("SERV_PROVIDER_STARTTIME is null");
            return (Criteria) this;
        }

        public Criteria andServProviderStarttimeIsNotNull() {
            addCriterion("SERV_PROVIDER_STARTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andServProviderStarttimeEqualTo(Date value) {
            addCriterion("SERV_PROVIDER_STARTTIME =", value, "servProviderStarttime");
            return (Criteria) this;
        }

        public Criteria andServProviderStarttimeNotEqualTo(Date value) {
            addCriterion("SERV_PROVIDER_STARTTIME <>", value, "servProviderStarttime");
            return (Criteria) this;
        }

        public Criteria andServProviderStarttimeGreaterThan(Date value) {
            addCriterion("SERV_PROVIDER_STARTTIME >", value, "servProviderStarttime");
            return (Criteria) this;
        }

        public Criteria andServProviderStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SERV_PROVIDER_STARTTIME >=", value, "servProviderStarttime");
            return (Criteria) this;
        }

        public Criteria andServProviderStarttimeLessThan(Date value) {
            addCriterion("SERV_PROVIDER_STARTTIME <", value, "servProviderStarttime");
            return (Criteria) this;
        }

        public Criteria andServProviderStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("SERV_PROVIDER_STARTTIME <=", value, "servProviderStarttime");
            return (Criteria) this;
        }

        public Criteria andServProviderStarttimeIn(List<Date> values) {
            addCriterion("SERV_PROVIDER_STARTTIME in", values, "servProviderStarttime");
            return (Criteria) this;
        }

        public Criteria andServProviderStarttimeNotIn(List<Date> values) {
            addCriterion("SERV_PROVIDER_STARTTIME not in", values, "servProviderStarttime");
            return (Criteria) this;
        }

        public Criteria andServProviderStarttimeBetween(Date value1, Date value2) {
            addCriterion("SERV_PROVIDER_STARTTIME between", value1, value2, "servProviderStarttime");
            return (Criteria) this;
        }

        public Criteria andServProviderStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("SERV_PROVIDER_STARTTIME not between", value1, value2, "servProviderStarttime");
            return (Criteria) this;
        }

        public Criteria andServCompanyIntrductionIsNull() {
            addCriterion("SERV_COMPANY_INTRDUCTION is null");
            return (Criteria) this;
        }

        public Criteria andServCompanyIntrductionIsNotNull() {
            addCriterion("SERV_COMPANY_INTRDUCTION is not null");
            return (Criteria) this;
        }

        public Criteria andServCompanyIntrductionEqualTo(String value) {
            addCriterion("SERV_COMPANY_INTRDUCTION =", value, "servCompanyIntrduction");
            return (Criteria) this;
        }

        public Criteria andServCompanyIntrductionNotEqualTo(String value) {
            addCriterion("SERV_COMPANY_INTRDUCTION <>", value, "servCompanyIntrduction");
            return (Criteria) this;
        }

        public Criteria andServCompanyIntrductionGreaterThan(String value) {
            addCriterion("SERV_COMPANY_INTRDUCTION >", value, "servCompanyIntrduction");
            return (Criteria) this;
        }

        public Criteria andServCompanyIntrductionGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_COMPANY_INTRDUCTION >=", value, "servCompanyIntrduction");
            return (Criteria) this;
        }

        public Criteria andServCompanyIntrductionLessThan(String value) {
            addCriterion("SERV_COMPANY_INTRDUCTION <", value, "servCompanyIntrduction");
            return (Criteria) this;
        }

        public Criteria andServCompanyIntrductionLessThanOrEqualTo(String value) {
            addCriterion("SERV_COMPANY_INTRDUCTION <=", value, "servCompanyIntrduction");
            return (Criteria) this;
        }

        public Criteria andServCompanyIntrductionLike(String value) {
            addCriterion("SERV_COMPANY_INTRDUCTION like", value, "servCompanyIntrduction");
            return (Criteria) this;
        }

        public Criteria andServCompanyIntrductionNotLike(String value) {
            addCriterion("SERV_COMPANY_INTRDUCTION not like", value, "servCompanyIntrduction");
            return (Criteria) this;
        }

        public Criteria andServCompanyIntrductionIn(List<String> values) {
            addCriterion("SERV_COMPANY_INTRDUCTION in", values, "servCompanyIntrduction");
            return (Criteria) this;
        }

        public Criteria andServCompanyIntrductionNotIn(List<String> values) {
            addCriterion("SERV_COMPANY_INTRDUCTION not in", values, "servCompanyIntrduction");
            return (Criteria) this;
        }

        public Criteria andServCompanyIntrductionBetween(String value1, String value2) {
            addCriterion("SERV_COMPANY_INTRDUCTION between", value1, value2, "servCompanyIntrduction");
            return (Criteria) this;
        }

        public Criteria andServCompanyIntrductionNotBetween(String value1, String value2) {
            addCriterion("SERV_COMPANY_INTRDUCTION not between", value1, value2, "servCompanyIntrduction");
            return (Criteria) this;
        }

        public Criteria andServProviderWorktimeIsNull() {
            addCriterion("SERV_PROVIDER_WORKTIME is null");
            return (Criteria) this;
        }

        public Criteria andServProviderWorktimeIsNotNull() {
            addCriterion("SERV_PROVIDER_WORKTIME is not null");
            return (Criteria) this;
        }

        public Criteria andServProviderWorktimeEqualTo(String value) {
            addCriterion("SERV_PROVIDER_WORKTIME =", value, "servProviderWorktime");
            return (Criteria) this;
        }

        public Criteria andServProviderWorktimeNotEqualTo(String value) {
            addCriterion("SERV_PROVIDER_WORKTIME <>", value, "servProviderWorktime");
            return (Criteria) this;
        }

        public Criteria andServProviderWorktimeGreaterThan(String value) {
            addCriterion("SERV_PROVIDER_WORKTIME >", value, "servProviderWorktime");
            return (Criteria) this;
        }

        public Criteria andServProviderWorktimeGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_WORKTIME >=", value, "servProviderWorktime");
            return (Criteria) this;
        }

        public Criteria andServProviderWorktimeLessThan(String value) {
            addCriterion("SERV_PROVIDER_WORKTIME <", value, "servProviderWorktime");
            return (Criteria) this;
        }

        public Criteria andServProviderWorktimeLessThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_WORKTIME <=", value, "servProviderWorktime");
            return (Criteria) this;
        }

        public Criteria andServProviderWorktimeLike(String value) {
            addCriterion("SERV_PROVIDER_WORKTIME like", value, "servProviderWorktime");
            return (Criteria) this;
        }

        public Criteria andServProviderWorktimeNotLike(String value) {
            addCriterion("SERV_PROVIDER_WORKTIME not like", value, "servProviderWorktime");
            return (Criteria) this;
        }

        public Criteria andServProviderWorktimeIn(List<String> values) {
            addCriterion("SERV_PROVIDER_WORKTIME in", values, "servProviderWorktime");
            return (Criteria) this;
        }

        public Criteria andServProviderWorktimeNotIn(List<String> values) {
            addCriterion("SERV_PROVIDER_WORKTIME not in", values, "servProviderWorktime");
            return (Criteria) this;
        }

        public Criteria andServProviderWorktimeBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_WORKTIME between", value1, value2, "servProviderWorktime");
            return (Criteria) this;
        }

        public Criteria andServProviderWorktimeNotBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_WORKTIME not between", value1, value2, "servProviderWorktime");
            return (Criteria) this;
        }

        public Criteria andServProviderQqIsNull() {
            addCriterion("SERV_PROVIDER_QQ is null");
            return (Criteria) this;
        }

        public Criteria andServProviderQqIsNotNull() {
            addCriterion("SERV_PROVIDER_QQ is not null");
            return (Criteria) this;
        }

        public Criteria andServProviderQqEqualTo(String value) {
            addCriterion("SERV_PROVIDER_QQ =", value, "servProviderQq");
            return (Criteria) this;
        }

        public Criteria andServProviderQqNotEqualTo(String value) {
            addCriterion("SERV_PROVIDER_QQ <>", value, "servProviderQq");
            return (Criteria) this;
        }

        public Criteria andServProviderQqGreaterThan(String value) {
            addCriterion("SERV_PROVIDER_QQ >", value, "servProviderQq");
            return (Criteria) this;
        }

        public Criteria andServProviderQqGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_QQ >=", value, "servProviderQq");
            return (Criteria) this;
        }

        public Criteria andServProviderQqLessThan(String value) {
            addCriterion("SERV_PROVIDER_QQ <", value, "servProviderQq");
            return (Criteria) this;
        }

        public Criteria andServProviderQqLessThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_QQ <=", value, "servProviderQq");
            return (Criteria) this;
        }

        public Criteria andServProviderQqLike(String value) {
            addCriterion("SERV_PROVIDER_QQ like", value, "servProviderQq");
            return (Criteria) this;
        }

        public Criteria andServProviderQqNotLike(String value) {
            addCriterion("SERV_PROVIDER_QQ not like", value, "servProviderQq");
            return (Criteria) this;
        }

        public Criteria andServProviderQqIn(List<String> values) {
            addCriterion("SERV_PROVIDER_QQ in", values, "servProviderQq");
            return (Criteria) this;
        }

        public Criteria andServProviderQqNotIn(List<String> values) {
            addCriterion("SERV_PROVIDER_QQ not in", values, "servProviderQq");
            return (Criteria) this;
        }

        public Criteria andServProviderQqBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_QQ between", value1, value2, "servProviderQq");
            return (Criteria) this;
        }

        public Criteria andServProviderQqNotBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_QQ not between", value1, value2, "servProviderQq");
            return (Criteria) this;
        }

        public Criteria andServProviderWeichartIsNull() {
            addCriterion("SERV_PROVIDER_WEICHART is null");
            return (Criteria) this;
        }

        public Criteria andServProviderWeichartIsNotNull() {
            addCriterion("SERV_PROVIDER_WEICHART is not null");
            return (Criteria) this;
        }

        public Criteria andServProviderWeichartEqualTo(String value) {
            addCriterion("SERV_PROVIDER_WEICHART =", value, "servProviderWeichart");
            return (Criteria) this;
        }

        public Criteria andServProviderWeichartNotEqualTo(String value) {
            addCriterion("SERV_PROVIDER_WEICHART <>", value, "servProviderWeichart");
            return (Criteria) this;
        }

        public Criteria andServProviderWeichartGreaterThan(String value) {
            addCriterion("SERV_PROVIDER_WEICHART >", value, "servProviderWeichart");
            return (Criteria) this;
        }

        public Criteria andServProviderWeichartGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_WEICHART >=", value, "servProviderWeichart");
            return (Criteria) this;
        }

        public Criteria andServProviderWeichartLessThan(String value) {
            addCriterion("SERV_PROVIDER_WEICHART <", value, "servProviderWeichart");
            return (Criteria) this;
        }

        public Criteria andServProviderWeichartLessThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_WEICHART <=", value, "servProviderWeichart");
            return (Criteria) this;
        }

        public Criteria andServProviderWeichartLike(String value) {
            addCriterion("SERV_PROVIDER_WEICHART like", value, "servProviderWeichart");
            return (Criteria) this;
        }

        public Criteria andServProviderWeichartNotLike(String value) {
            addCriterion("SERV_PROVIDER_WEICHART not like", value, "servProviderWeichart");
            return (Criteria) this;
        }

        public Criteria andServProviderWeichartIn(List<String> values) {
            addCriterion("SERV_PROVIDER_WEICHART in", values, "servProviderWeichart");
            return (Criteria) this;
        }

        public Criteria andServProviderWeichartNotIn(List<String> values) {
            addCriterion("SERV_PROVIDER_WEICHART not in", values, "servProviderWeichart");
            return (Criteria) this;
        }

        public Criteria andServProviderWeichartBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_WEICHART between", value1, value2, "servProviderWeichart");
            return (Criteria) this;
        }

        public Criteria andServProviderWeichartNotBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_WEICHART not between", value1, value2, "servProviderWeichart");
            return (Criteria) this;
        }

        public Criteria andServProviderCsphoneIsNull() {
            addCriterion("SERV_PROVIDER_CSPHONE is null");
            return (Criteria) this;
        }

        public Criteria andServProviderCsphoneIsNotNull() {
            addCriterion("SERV_PROVIDER_CSPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andServProviderCsphoneEqualTo(String value) {
            addCriterion("SERV_PROVIDER_CSPHONE =", value, "servProviderCsphone");
            return (Criteria) this;
        }

        public Criteria andServProviderCsphoneNotEqualTo(String value) {
            addCriterion("SERV_PROVIDER_CSPHONE <>", value, "servProviderCsphone");
            return (Criteria) this;
        }

        public Criteria andServProviderCsphoneGreaterThan(String value) {
            addCriterion("SERV_PROVIDER_CSPHONE >", value, "servProviderCsphone");
            return (Criteria) this;
        }

        public Criteria andServProviderCsphoneGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_CSPHONE >=", value, "servProviderCsphone");
            return (Criteria) this;
        }

        public Criteria andServProviderCsphoneLessThan(String value) {
            addCriterion("SERV_PROVIDER_CSPHONE <", value, "servProviderCsphone");
            return (Criteria) this;
        }

        public Criteria andServProviderCsphoneLessThanOrEqualTo(String value) {
            addCriterion("SERV_PROVIDER_CSPHONE <=", value, "servProviderCsphone");
            return (Criteria) this;
        }

        public Criteria andServProviderCsphoneLike(String value) {
            addCriterion("SERV_PROVIDER_CSPHONE like", value, "servProviderCsphone");
            return (Criteria) this;
        }

        public Criteria andServProviderCsphoneNotLike(String value) {
            addCriterion("SERV_PROVIDER_CSPHONE not like", value, "servProviderCsphone");
            return (Criteria) this;
        }

        public Criteria andServProviderCsphoneIn(List<String> values) {
            addCriterion("SERV_PROVIDER_CSPHONE in", values, "servProviderCsphone");
            return (Criteria) this;
        }

        public Criteria andServProviderCsphoneNotIn(List<String> values) {
            addCriterion("SERV_PROVIDER_CSPHONE not in", values, "servProviderCsphone");
            return (Criteria) this;
        }

        public Criteria andServProviderCsphoneBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_CSPHONE between", value1, value2, "servProviderCsphone");
            return (Criteria) this;
        }

        public Criteria andServProviderCsphoneNotBetween(String value1, String value2) {
            addCriterion("SERV_PROVIDER_CSPHONE not between", value1, value2, "servProviderCsphone");
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
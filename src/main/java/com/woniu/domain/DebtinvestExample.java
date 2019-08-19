package com.woniu.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DebtinvestExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table debtinvest
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table debtinvest
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table debtinvest
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debtinvest
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public DebtinvestExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debtinvest
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debtinvest
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debtinvest
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debtinvest
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debtinvest
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debtinvest
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debtinvest
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debtinvest
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debtinvest
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table debtinvest
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table debtinvest
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
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

        public Criteria andDebtinvestidIsNull() {
            addCriterion("debtinvestid is null");
            return (Criteria) this;
        }

        public Criteria andDebtinvestidIsNotNull() {
            addCriterion("debtinvestid is not null");
            return (Criteria) this;
        }

        public Criteria andDebtinvestidEqualTo(Integer value) {
            addCriterion("debtinvestid =", value, "debtinvestid");
            return (Criteria) this;
        }

        public Criteria andDebtinvestidNotEqualTo(Integer value) {
            addCriterion("debtinvestid <>", value, "debtinvestid");
            return (Criteria) this;
        }

        public Criteria andDebtinvestidGreaterThan(Integer value) {
            addCriterion("debtinvestid >", value, "debtinvestid");
            return (Criteria) this;
        }

        public Criteria andDebtinvestidGreaterThanOrEqualTo(Integer value) {
            addCriterion("debtinvestid >=", value, "debtinvestid");
            return (Criteria) this;
        }

        public Criteria andDebtinvestidLessThan(Integer value) {
            addCriterion("debtinvestid <", value, "debtinvestid");
            return (Criteria) this;
        }

        public Criteria andDebtinvestidLessThanOrEqualTo(Integer value) {
            addCriterion("debtinvestid <=", value, "debtinvestid");
            return (Criteria) this;
        }

        public Criteria andDebtinvestidIn(List<Integer> values) {
            addCriterion("debtinvestid in", values, "debtinvestid");
            return (Criteria) this;
        }

        public Criteria andDebtinvestidNotIn(List<Integer> values) {
            addCriterion("debtinvestid not in", values, "debtinvestid");
            return (Criteria) this;
        }

        public Criteria andDebtinvestidBetween(Integer value1, Integer value2) {
            addCriterion("debtinvestid between", value1, value2, "debtinvestid");
            return (Criteria) this;
        }

        public Criteria andDebtinvestidNotBetween(Integer value1, Integer value2) {
            addCriterion("debtinvestid not between", value1, value2, "debtinvestid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidIsNull() {
            addCriterion("userinfoid is null");
            return (Criteria) this;
        }

        public Criteria andUserinfoidIsNotNull() {
            addCriterion("userinfoid is not null");
            return (Criteria) this;
        }

        public Criteria andUserinfoidEqualTo(Integer value) {
            addCriterion("userinfoid =", value, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidNotEqualTo(Integer value) {
            addCriterion("userinfoid <>", value, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidGreaterThan(Integer value) {
            addCriterion("userinfoid >", value, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userinfoid >=", value, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidLessThan(Integer value) {
            addCriterion("userinfoid <", value, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidLessThanOrEqualTo(Integer value) {
            addCriterion("userinfoid <=", value, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidIn(List<Integer> values) {
            addCriterion("userinfoid in", values, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidNotIn(List<Integer> values) {
            addCriterion("userinfoid not in", values, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidBetween(Integer value1, Integer value2) {
            addCriterion("userinfoid between", value1, value2, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andUserinfoidNotBetween(Integer value1, Integer value2) {
            addCriterion("userinfoid not between", value1, value2, "userinfoid");
            return (Criteria) this;
        }

        public Criteria andInvestamountIsNull() {
            addCriterion("investamount is null");
            return (Criteria) this;
        }

        public Criteria andInvestamountIsNotNull() {
            addCriterion("investamount is not null");
            return (Criteria) this;
        }

        public Criteria andInvestamountEqualTo(Double value) {
            addCriterion("investamount =", value, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountNotEqualTo(Double value) {
            addCriterion("investamount <>", value, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountGreaterThan(Double value) {
            addCriterion("investamount >", value, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountGreaterThanOrEqualTo(Double value) {
            addCriterion("investamount >=", value, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountLessThan(Double value) {
            addCriterion("investamount <", value, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountLessThanOrEqualTo(Double value) {
            addCriterion("investamount <=", value, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountIn(List<Double> values) {
            addCriterion("investamount in", values, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountNotIn(List<Double> values) {
            addCriterion("investamount not in", values, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountBetween(Double value1, Double value2) {
            addCriterion("investamount between", value1, value2, "investamount");
            return (Criteria) this;
        }

        public Criteria andInvestamountNotBetween(Double value1, Double value2) {
            addCriterion("investamount not between", value1, value2, "investamount");
            return (Criteria) this;
        }

        public Criteria andPaytimeIsNull() {
            addCriterion("paytime is null");
            return (Criteria) this;
        }

        public Criteria andPaytimeIsNotNull() {
            addCriterion("paytime is not null");
            return (Criteria) this;
        }

        public Criteria andPaytimeEqualTo(Date value) {
            addCriterion("paytime =", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotEqualTo(Date value) {
            addCriterion("paytime <>", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThan(Date value) {
            addCriterion("paytime >", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("paytime >=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThan(Date value) {
            addCriterion("paytime <", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThanOrEqualTo(Date value) {
            addCriterion("paytime <=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeIn(List<Date> values) {
            addCriterion("paytime in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotIn(List<Date> values) {
            addCriterion("paytime not in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeBetween(Date value1, Date value2) {
            addCriterion("paytime between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotBetween(Date value1, Date value2) {
            addCriterion("paytime not between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andIstransferIsNull() {
            addCriterion("istransfer is null");
            return (Criteria) this;
        }

        public Criteria andIstransferIsNotNull() {
            addCriterion("istransfer is not null");
            return (Criteria) this;
        }

        public Criteria andIstransferEqualTo(Boolean value) {
            addCriterion("istransfer =", value, "istransfer");
            return (Criteria) this;
        }

        public Criteria andIstransferNotEqualTo(Boolean value) {
            addCriterion("istransfer <>", value, "istransfer");
            return (Criteria) this;
        }

        public Criteria andIstransferGreaterThan(Boolean value) {
            addCriterion("istransfer >", value, "istransfer");
            return (Criteria) this;
        }

        public Criteria andIstransferGreaterThanOrEqualTo(Boolean value) {
            addCriterion("istransfer >=", value, "istransfer");
            return (Criteria) this;
        }

        public Criteria andIstransferLessThan(Boolean value) {
            addCriterion("istransfer <", value, "istransfer");
            return (Criteria) this;
        }

        public Criteria andIstransferLessThanOrEqualTo(Boolean value) {
            addCriterion("istransfer <=", value, "istransfer");
            return (Criteria) this;
        }

        public Criteria andIstransferIn(List<Boolean> values) {
            addCriterion("istransfer in", values, "istransfer");
            return (Criteria) this;
        }

        public Criteria andIstransferNotIn(List<Boolean> values) {
            addCriterion("istransfer not in", values, "istransfer");
            return (Criteria) this;
        }

        public Criteria andIstransferBetween(Boolean value1, Boolean value2) {
            addCriterion("istransfer between", value1, value2, "istransfer");
            return (Criteria) this;
        }

        public Criteria andIstransferNotBetween(Boolean value1, Boolean value2) {
            addCriterion("istransfer not between", value1, value2, "istransfer");
            return (Criteria) this;
        }

        public Criteria andServicechargeIsNull() {
            addCriterion("servicecharge is null");
            return (Criteria) this;
        }

        public Criteria andServicechargeIsNotNull() {
            addCriterion("servicecharge is not null");
            return (Criteria) this;
        }

        public Criteria andServicechargeEqualTo(Double value) {
            addCriterion("servicecharge =", value, "servicecharge");
            return (Criteria) this;
        }

        public Criteria andServicechargeNotEqualTo(Double value) {
            addCriterion("servicecharge <>", value, "servicecharge");
            return (Criteria) this;
        }

        public Criteria andServicechargeGreaterThan(Double value) {
            addCriterion("servicecharge >", value, "servicecharge");
            return (Criteria) this;
        }

        public Criteria andServicechargeGreaterThanOrEqualTo(Double value) {
            addCriterion("servicecharge >=", value, "servicecharge");
            return (Criteria) this;
        }

        public Criteria andServicechargeLessThan(Double value) {
            addCriterion("servicecharge <", value, "servicecharge");
            return (Criteria) this;
        }

        public Criteria andServicechargeLessThanOrEqualTo(Double value) {
            addCriterion("servicecharge <=", value, "servicecharge");
            return (Criteria) this;
        }

        public Criteria andServicechargeIn(List<Double> values) {
            addCriterion("servicecharge in", values, "servicecharge");
            return (Criteria) this;
        }

        public Criteria andServicechargeNotIn(List<Double> values) {
            addCriterion("servicecharge not in", values, "servicecharge");
            return (Criteria) this;
        }

        public Criteria andServicechargeBetween(Double value1, Double value2) {
            addCriterion("servicecharge between", value1, value2, "servicecharge");
            return (Criteria) this;
        }

        public Criteria andServicechargeNotBetween(Double value1, Double value2) {
            addCriterion("servicecharge not between", value1, value2, "servicecharge");
            return (Criteria) this;
        }

        public Criteria andServicechargeidIsNull() {
            addCriterion("servicechargeid is null");
            return (Criteria) this;
        }

        public Criteria andServicechargeidIsNotNull() {
            addCriterion("servicechargeid is not null");
            return (Criteria) this;
        }

        public Criteria andServicechargeidEqualTo(Integer value) {
            addCriterion("servicechargeid =", value, "servicechargeid");
            return (Criteria) this;
        }

        public Criteria andServicechargeidNotEqualTo(Integer value) {
            addCriterion("servicechargeid <>", value, "servicechargeid");
            return (Criteria) this;
        }

        public Criteria andServicechargeidGreaterThan(Integer value) {
            addCriterion("servicechargeid >", value, "servicechargeid");
            return (Criteria) this;
        }

        public Criteria andServicechargeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("servicechargeid >=", value, "servicechargeid");
            return (Criteria) this;
        }

        public Criteria andServicechargeidLessThan(Integer value) {
            addCriterion("servicechargeid <", value, "servicechargeid");
            return (Criteria) this;
        }

        public Criteria andServicechargeidLessThanOrEqualTo(Integer value) {
            addCriterion("servicechargeid <=", value, "servicechargeid");
            return (Criteria) this;
        }

        public Criteria andServicechargeidIn(List<Integer> values) {
            addCriterion("servicechargeid in", values, "servicechargeid");
            return (Criteria) this;
        }

        public Criteria andServicechargeidNotIn(List<Integer> values) {
            addCriterion("servicechargeid not in", values, "servicechargeid");
            return (Criteria) this;
        }

        public Criteria andServicechargeidBetween(Integer value1, Integer value2) {
            addCriterion("servicechargeid between", value1, value2, "servicechargeid");
            return (Criteria) this;
        }

        public Criteria andServicechargeidNotBetween(Integer value1, Integer value2) {
            addCriterion("servicechargeid not between", value1, value2, "servicechargeid");
            return (Criteria) this;
        }

        public Criteria andDebttransferdisplayIsNull() {
            addCriterion("debttransferdisplay is null");
            return (Criteria) this;
        }

        public Criteria andDebttransferdisplayIsNotNull() {
            addCriterion("debttransferdisplay is not null");
            return (Criteria) this;
        }

        public Criteria andDebttransferdisplayEqualTo(Integer value) {
            addCriterion("debttransferdisplay =", value, "debttransferdisplay");
            return (Criteria) this;
        }

        public Criteria andDebttransferdisplayNotEqualTo(Integer value) {
            addCriterion("debttransferdisplay <>", value, "debttransferdisplay");
            return (Criteria) this;
        }

        public Criteria andDebttransferdisplayGreaterThan(Integer value) {
            addCriterion("debttransferdisplay >", value, "debttransferdisplay");
            return (Criteria) this;
        }

        public Criteria andDebttransferdisplayGreaterThanOrEqualTo(Integer value) {
            addCriterion("debttransferdisplay >=", value, "debttransferdisplay");
            return (Criteria) this;
        }

        public Criteria andDebttransferdisplayLessThan(Integer value) {
            addCriterion("debttransferdisplay <", value, "debttransferdisplay");
            return (Criteria) this;
        }

        public Criteria andDebttransferdisplayLessThanOrEqualTo(Integer value) {
            addCriterion("debttransferdisplay <=", value, "debttransferdisplay");
            return (Criteria) this;
        }

        public Criteria andDebttransferdisplayIn(List<Integer> values) {
            addCriterion("debttransferdisplay in", values, "debttransferdisplay");
            return (Criteria) this;
        }

        public Criteria andDebttransferdisplayNotIn(List<Integer> values) {
            addCriterion("debttransferdisplay not in", values, "debttransferdisplay");
            return (Criteria) this;
        }

        public Criteria andDebttransferdisplayBetween(Integer value1, Integer value2) {
            addCriterion("debttransferdisplay between", value1, value2, "debttransferdisplay");
            return (Criteria) this;
        }

        public Criteria andDebttransferdisplayNotBetween(Integer value1, Integer value2) {
            addCriterion("debttransferdisplay not between", value1, value2, "debttransferdisplay");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table debtinvest
     *
     * @mbggenerated do_not_delete_during_merge Mon Aug 19 15:11:02 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table debtinvest
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
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
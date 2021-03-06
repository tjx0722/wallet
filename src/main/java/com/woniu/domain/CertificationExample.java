package com.woniu.domain;

import java.util.ArrayList;
import java.util.List;

public class CertificationExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table certification
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table certification
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table certification
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public CertificationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
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
     * This method corresponds to the database table certification
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
     * This method corresponds to the database table certification
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table certification
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
     * This class corresponds to the database table certification
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

        public Criteria andCertificationidIsNull() {
            addCriterion("certificationid is null");
            return (Criteria) this;
        }

        public Criteria andCertificationidIsNotNull() {
            addCriterion("certificationid is not null");
            return (Criteria) this;
        }

        public Criteria andCertificationidEqualTo(Integer value) {
            addCriterion("certificationid =", value, "certificationid");
            return (Criteria) this;
        }

        public Criteria andCertificationidNotEqualTo(Integer value) {
            addCriterion("certificationid <>", value, "certificationid");
            return (Criteria) this;
        }

        public Criteria andCertificationidGreaterThan(Integer value) {
            addCriterion("certificationid >", value, "certificationid");
            return (Criteria) this;
        }

        public Criteria andCertificationidGreaterThanOrEqualTo(Integer value) {
            addCriterion("certificationid >=", value, "certificationid");
            return (Criteria) this;
        }

        public Criteria andCertificationidLessThan(Integer value) {
            addCriterion("certificationid <", value, "certificationid");
            return (Criteria) this;
        }

        public Criteria andCertificationidLessThanOrEqualTo(Integer value) {
            addCriterion("certificationid <=", value, "certificationid");
            return (Criteria) this;
        }

        public Criteria andCertificationidIn(List<Integer> values) {
            addCriterion("certificationid in", values, "certificationid");
            return (Criteria) this;
        }

        public Criteria andCertificationidNotIn(List<Integer> values) {
            addCriterion("certificationid not in", values, "certificationid");
            return (Criteria) this;
        }

        public Criteria andCertificationidBetween(Integer value1, Integer value2) {
            addCriterion("certificationid between", value1, value2, "certificationid");
            return (Criteria) this;
        }

        public Criteria andCertificationidNotBetween(Integer value1, Integer value2) {
            addCriterion("certificationid not between", value1, value2, "certificationid");
            return (Criteria) this;
        }

        public Criteria andIdcardnumIsNull() {
            addCriterion("idcardnum is null");
            return (Criteria) this;
        }

        public Criteria andIdcardnumIsNotNull() {
            addCriterion("idcardnum is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardnumEqualTo(String value) {
            addCriterion("idcardnum =", value, "idcardnum");
            return (Criteria) this;
        }

        public Criteria andIdcardnumNotEqualTo(String value) {
            addCriterion("idcardnum <>", value, "idcardnum");
            return (Criteria) this;
        }

        public Criteria andIdcardnumGreaterThan(String value) {
            addCriterion("idcardnum >", value, "idcardnum");
            return (Criteria) this;
        }

        public Criteria andIdcardnumGreaterThanOrEqualTo(String value) {
            addCriterion("idcardnum >=", value, "idcardnum");
            return (Criteria) this;
        }

        public Criteria andIdcardnumLessThan(String value) {
            addCriterion("idcardnum <", value, "idcardnum");
            return (Criteria) this;
        }

        public Criteria andIdcardnumLessThanOrEqualTo(String value) {
            addCriterion("idcardnum <=", value, "idcardnum");
            return (Criteria) this;
        }

        public Criteria andIdcardnumLike(String value) {
            addCriterion("idcardnum like", value, "idcardnum");
            return (Criteria) this;
        }

        public Criteria andIdcardnumNotLike(String value) {
            addCriterion("idcardnum not like", value, "idcardnum");
            return (Criteria) this;
        }

        public Criteria andIdcardnumIn(List<String> values) {
            addCriterion("idcardnum in", values, "idcardnum");
            return (Criteria) this;
        }

        public Criteria andIdcardnumNotIn(List<String> values) {
            addCriterion("idcardnum not in", values, "idcardnum");
            return (Criteria) this;
        }

        public Criteria andIdcardnumBetween(String value1, String value2) {
            addCriterion("idcardnum between", value1, value2, "idcardnum");
            return (Criteria) this;
        }

        public Criteria andIdcardnumNotBetween(String value1, String value2) {
            addCriterion("idcardnum not between", value1, value2, "idcardnum");
            return (Criteria) this;
        }

        public Criteria andIdcardimgfrontIsNull() {
            addCriterion("idcardimgfront is null");
            return (Criteria) this;
        }

        public Criteria andIdcardimgfrontIsNotNull() {
            addCriterion("idcardimgfront is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardimgfrontEqualTo(String value) {
            addCriterion("idcardimgfront =", value, "idcardimgfront");
            return (Criteria) this;
        }

        public Criteria andIdcardimgfrontNotEqualTo(String value) {
            addCriterion("idcardimgfront <>", value, "idcardimgfront");
            return (Criteria) this;
        }

        public Criteria andIdcardimgfrontGreaterThan(String value) {
            addCriterion("idcardimgfront >", value, "idcardimgfront");
            return (Criteria) this;
        }

        public Criteria andIdcardimgfrontGreaterThanOrEqualTo(String value) {
            addCriterion("idcardimgfront >=", value, "idcardimgfront");
            return (Criteria) this;
        }

        public Criteria andIdcardimgfrontLessThan(String value) {
            addCriterion("idcardimgfront <", value, "idcardimgfront");
            return (Criteria) this;
        }

        public Criteria andIdcardimgfrontLessThanOrEqualTo(String value) {
            addCriterion("idcardimgfront <=", value, "idcardimgfront");
            return (Criteria) this;
        }

        public Criteria andIdcardimgfrontLike(String value) {
            addCriterion("idcardimgfront like", value, "idcardimgfront");
            return (Criteria) this;
        }

        public Criteria andIdcardimgfrontNotLike(String value) {
            addCriterion("idcardimgfront not like", value, "idcardimgfront");
            return (Criteria) this;
        }

        public Criteria andIdcardimgfrontIn(List<String> values) {
            addCriterion("idcardimgfront in", values, "idcardimgfront");
            return (Criteria) this;
        }

        public Criteria andIdcardimgfrontNotIn(List<String> values) {
            addCriterion("idcardimgfront not in", values, "idcardimgfront");
            return (Criteria) this;
        }

        public Criteria andIdcardimgfrontBetween(String value1, String value2) {
            addCriterion("idcardimgfront between", value1, value2, "idcardimgfront");
            return (Criteria) this;
        }

        public Criteria andIdcardimgfrontNotBetween(String value1, String value2) {
            addCriterion("idcardimgfront not between", value1, value2, "idcardimgfront");
            return (Criteria) this;
        }

        public Criteria andIdcardimgbackIsNull() {
            addCriterion("idcardimgback is null");
            return (Criteria) this;
        }

        public Criteria andIdcardimgbackIsNotNull() {
            addCriterion("idcardimgback is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardimgbackEqualTo(String value) {
            addCriterion("idcardimgback =", value, "idcardimgback");
            return (Criteria) this;
        }

        public Criteria andIdcardimgbackNotEqualTo(String value) {
            addCriterion("idcardimgback <>", value, "idcardimgback");
            return (Criteria) this;
        }

        public Criteria andIdcardimgbackGreaterThan(String value) {
            addCriterion("idcardimgback >", value, "idcardimgback");
            return (Criteria) this;
        }

        public Criteria andIdcardimgbackGreaterThanOrEqualTo(String value) {
            addCriterion("idcardimgback >=", value, "idcardimgback");
            return (Criteria) this;
        }

        public Criteria andIdcardimgbackLessThan(String value) {
            addCriterion("idcardimgback <", value, "idcardimgback");
            return (Criteria) this;
        }

        public Criteria andIdcardimgbackLessThanOrEqualTo(String value) {
            addCriterion("idcardimgback <=", value, "idcardimgback");
            return (Criteria) this;
        }

        public Criteria andIdcardimgbackLike(String value) {
            addCriterion("idcardimgback like", value, "idcardimgback");
            return (Criteria) this;
        }

        public Criteria andIdcardimgbackNotLike(String value) {
            addCriterion("idcardimgback not like", value, "idcardimgback");
            return (Criteria) this;
        }

        public Criteria andIdcardimgbackIn(List<String> values) {
            addCriterion("idcardimgback in", values, "idcardimgback");
            return (Criteria) this;
        }

        public Criteria andIdcardimgbackNotIn(List<String> values) {
            addCriterion("idcardimgback not in", values, "idcardimgback");
            return (Criteria) this;
        }

        public Criteria andIdcardimgbackBetween(String value1, String value2) {
            addCriterion("idcardimgback between", value1, value2, "idcardimgback");
            return (Criteria) this;
        }

        public Criteria andIdcardimgbackNotBetween(String value1, String value2) {
            addCriterion("idcardimgback not between", value1, value2, "idcardimgback");
            return (Criteria) this;
        }

        public Criteria andIdcardimghandIsNull() {
            addCriterion("idcardimghand is null");
            return (Criteria) this;
        }

        public Criteria andIdcardimghandIsNotNull() {
            addCriterion("idcardimghand is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardimghandEqualTo(String value) {
            addCriterion("idcardimghand =", value, "idcardimghand");
            return (Criteria) this;
        }

        public Criteria andIdcardimghandNotEqualTo(String value) {
            addCriterion("idcardimghand <>", value, "idcardimghand");
            return (Criteria) this;
        }

        public Criteria andIdcardimghandGreaterThan(String value) {
            addCriterion("idcardimghand >", value, "idcardimghand");
            return (Criteria) this;
        }

        public Criteria andIdcardimghandGreaterThanOrEqualTo(String value) {
            addCriterion("idcardimghand >=", value, "idcardimghand");
            return (Criteria) this;
        }

        public Criteria andIdcardimghandLessThan(String value) {
            addCriterion("idcardimghand <", value, "idcardimghand");
            return (Criteria) this;
        }

        public Criteria andIdcardimghandLessThanOrEqualTo(String value) {
            addCriterion("idcardimghand <=", value, "idcardimghand");
            return (Criteria) this;
        }

        public Criteria andIdcardimghandLike(String value) {
            addCriterion("idcardimghand like", value, "idcardimghand");
            return (Criteria) this;
        }

        public Criteria andIdcardimghandNotLike(String value) {
            addCriterion("idcardimghand not like", value, "idcardimghand");
            return (Criteria) this;
        }

        public Criteria andIdcardimghandIn(List<String> values) {
            addCriterion("idcardimghand in", values, "idcardimghand");
            return (Criteria) this;
        }

        public Criteria andIdcardimghandNotIn(List<String> values) {
            addCriterion("idcardimghand not in", values, "idcardimghand");
            return (Criteria) this;
        }

        public Criteria andIdcardimghandBetween(String value1, String value2) {
            addCriterion("idcardimghand between", value1, value2, "idcardimghand");
            return (Criteria) this;
        }

        public Criteria andIdcardimghandNotBetween(String value1, String value2) {
            addCriterion("idcardimghand not between", value1, value2, "idcardimghand");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table certification
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
     * This class corresponds to the database table certification
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
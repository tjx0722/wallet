package com.woniu.domain;

import java.util.ArrayList;
import java.util.List;

public class TransactiontypeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table transactiontype
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table transactiontype
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table transactiontype
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transactiontype
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public TransactiontypeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transactiontype
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transactiontype
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transactiontype
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transactiontype
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transactiontype
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transactiontype
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transactiontype
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
     * This method corresponds to the database table transactiontype
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
     * This method corresponds to the database table transactiontype
     *
     * @mbggenerated Mon Aug 19 15:11:02 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transactiontype
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
     * This class corresponds to the database table transactiontype
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

        public Criteria andTransactiontypeidIsNull() {
            addCriterion("transactiontypeid is null");
            return (Criteria) this;
        }

        public Criteria andTransactiontypeidIsNotNull() {
            addCriterion("transactiontypeid is not null");
            return (Criteria) this;
        }

        public Criteria andTransactiontypeidEqualTo(Integer value) {
            addCriterion("transactiontypeid =", value, "transactiontypeid");
            return (Criteria) this;
        }

        public Criteria andTransactiontypeidNotEqualTo(Integer value) {
            addCriterion("transactiontypeid <>", value, "transactiontypeid");
            return (Criteria) this;
        }

        public Criteria andTransactiontypeidGreaterThan(Integer value) {
            addCriterion("transactiontypeid >", value, "transactiontypeid");
            return (Criteria) this;
        }

        public Criteria andTransactiontypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("transactiontypeid >=", value, "transactiontypeid");
            return (Criteria) this;
        }

        public Criteria andTransactiontypeidLessThan(Integer value) {
            addCriterion("transactiontypeid <", value, "transactiontypeid");
            return (Criteria) this;
        }

        public Criteria andTransactiontypeidLessThanOrEqualTo(Integer value) {
            addCriterion("transactiontypeid <=", value, "transactiontypeid");
            return (Criteria) this;
        }

        public Criteria andTransactiontypeidIn(List<Integer> values) {
            addCriterion("transactiontypeid in", values, "transactiontypeid");
            return (Criteria) this;
        }

        public Criteria andTransactiontypeidNotIn(List<Integer> values) {
            addCriterion("transactiontypeid not in", values, "transactiontypeid");
            return (Criteria) this;
        }

        public Criteria andTransactiontypeidBetween(Integer value1, Integer value2) {
            addCriterion("transactiontypeid between", value1, value2, "transactiontypeid");
            return (Criteria) this;
        }

        public Criteria andTransactiontypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("transactiontypeid not between", value1, value2, "transactiontypeid");
            return (Criteria) this;
        }

        public Criteria andTransactiontypenameIsNull() {
            addCriterion("transactiontypename is null");
            return (Criteria) this;
        }

        public Criteria andTransactiontypenameIsNotNull() {
            addCriterion("transactiontypename is not null");
            return (Criteria) this;
        }

        public Criteria andTransactiontypenameEqualTo(String value) {
            addCriterion("transactiontypename =", value, "transactiontypename");
            return (Criteria) this;
        }

        public Criteria andTransactiontypenameNotEqualTo(String value) {
            addCriterion("transactiontypename <>", value, "transactiontypename");
            return (Criteria) this;
        }

        public Criteria andTransactiontypenameGreaterThan(String value) {
            addCriterion("transactiontypename >", value, "transactiontypename");
            return (Criteria) this;
        }

        public Criteria andTransactiontypenameGreaterThanOrEqualTo(String value) {
            addCriterion("transactiontypename >=", value, "transactiontypename");
            return (Criteria) this;
        }

        public Criteria andTransactiontypenameLessThan(String value) {
            addCriterion("transactiontypename <", value, "transactiontypename");
            return (Criteria) this;
        }

        public Criteria andTransactiontypenameLessThanOrEqualTo(String value) {
            addCriterion("transactiontypename <=", value, "transactiontypename");
            return (Criteria) this;
        }

        public Criteria andTransactiontypenameLike(String value) {
            addCriterion("transactiontypename like", value, "transactiontypename");
            return (Criteria) this;
        }

        public Criteria andTransactiontypenameNotLike(String value) {
            addCriterion("transactiontypename not like", value, "transactiontypename");
            return (Criteria) this;
        }

        public Criteria andTransactiontypenameIn(List<String> values) {
            addCriterion("transactiontypename in", values, "transactiontypename");
            return (Criteria) this;
        }

        public Criteria andTransactiontypenameNotIn(List<String> values) {
            addCriterion("transactiontypename not in", values, "transactiontypename");
            return (Criteria) this;
        }

        public Criteria andTransactiontypenameBetween(String value1, String value2) {
            addCriterion("transactiontypename between", value1, value2, "transactiontypename");
            return (Criteria) this;
        }

        public Criteria andTransactiontypenameNotBetween(String value1, String value2) {
            addCriterion("transactiontypename not between", value1, value2, "transactiontypename");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table transactiontype
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
     * This class corresponds to the database table transactiontype
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
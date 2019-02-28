package com.prosay.oa.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplicationExample() {
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

        public Criteria andApplicationIdIsNull() {
            addCriterion("application_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIsNotNull() {
            addCriterion("application_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdEqualTo(Integer value) {
            addCriterion("application_id =", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotEqualTo(Integer value) {
            addCriterion("application_id <>", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThan(Integer value) {
            addCriterion("application_id >", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("application_id >=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThan(Integer value) {
            addCriterion("application_id <", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThanOrEqualTo(Integer value) {
            addCriterion("application_id <=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIn(List<Integer> values) {
            addCriterion("application_id in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotIn(List<Integer> values) {
            addCriterion("application_id not in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdBetween(Integer value1, Integer value2) {
            addCriterion("application_id between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("application_id not between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationTitleIsNull() {
            addCriterion("application_title is null");
            return (Criteria) this;
        }

        public Criteria andApplicationTitleIsNotNull() {
            addCriterion("application_title is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationTitleEqualTo(String value) {
            addCriterion("application_title =", value, "applicationTitle");
            return (Criteria) this;
        }

        public Criteria andApplicationTitleNotEqualTo(String value) {
            addCriterion("application_title <>", value, "applicationTitle");
            return (Criteria) this;
        }

        public Criteria andApplicationTitleGreaterThan(String value) {
            addCriterion("application_title >", value, "applicationTitle");
            return (Criteria) this;
        }

        public Criteria andApplicationTitleGreaterThanOrEqualTo(String value) {
            addCriterion("application_title >=", value, "applicationTitle");
            return (Criteria) this;
        }

        public Criteria andApplicationTitleLessThan(String value) {
            addCriterion("application_title <", value, "applicationTitle");
            return (Criteria) this;
        }

        public Criteria andApplicationTitleLessThanOrEqualTo(String value) {
            addCriterion("application_title <=", value, "applicationTitle");
            return (Criteria) this;
        }

        public Criteria andApplicationTitleLike(String value) {
            addCriterion("application_title like", value, "applicationTitle");
            return (Criteria) this;
        }

        public Criteria andApplicationTitleNotLike(String value) {
            addCriterion("application_title not like", value, "applicationTitle");
            return (Criteria) this;
        }

        public Criteria andApplicationTitleIn(List<String> values) {
            addCriterion("application_title in", values, "applicationTitle");
            return (Criteria) this;
        }

        public Criteria andApplicationTitleNotIn(List<String> values) {
            addCriterion("application_title not in", values, "applicationTitle");
            return (Criteria) this;
        }

        public Criteria andApplicationTitleBetween(String value1, String value2) {
            addCriterion("application_title between", value1, value2, "applicationTitle");
            return (Criteria) this;
        }

        public Criteria andApplicationTitleNotBetween(String value1, String value2) {
            addCriterion("application_title not between", value1, value2, "applicationTitle");
            return (Criteria) this;
        }

        public Criteria andApplicationDateIsNull() {
            addCriterion("application_date is null");
            return (Criteria) this;
        }

        public Criteria andApplicationDateIsNotNull() {
            addCriterion("application_date is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationDateEqualTo(Date value) {
            addCriterion("application_date =", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotEqualTo(Date value) {
            addCriterion("application_date <>", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateGreaterThan(Date value) {
            addCriterion("application_date >", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("application_date >=", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateLessThan(Date value) {
            addCriterion("application_date <", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateLessThanOrEqualTo(Date value) {
            addCriterion("application_date <=", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateIn(List<Date> values) {
            addCriterion("application_date in", values, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotIn(List<Date> values) {
            addCriterion("application_date not in", values, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateBetween(Date value1, Date value2) {
            addCriterion("application_date between", value1, value2, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotBetween(Date value1, Date value2) {
            addCriterion("application_date not between", value1, value2, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationStatusIsNull() {
            addCriterion("application_status is null");
            return (Criteria) this;
        }

        public Criteria andApplicationStatusIsNotNull() {
            addCriterion("application_status is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationStatusEqualTo(String value) {
            addCriterion("application_status =", value, "applicationStatus");
            return (Criteria) this;
        }

        public Criteria andApplicationStatusNotEqualTo(String value) {
            addCriterion("application_status <>", value, "applicationStatus");
            return (Criteria) this;
        }

        public Criteria andApplicationStatusGreaterThan(String value) {
            addCriterion("application_status >", value, "applicationStatus");
            return (Criteria) this;
        }

        public Criteria andApplicationStatusGreaterThanOrEqualTo(String value) {
            addCriterion("application_status >=", value, "applicationStatus");
            return (Criteria) this;
        }

        public Criteria andApplicationStatusLessThan(String value) {
            addCriterion("application_status <", value, "applicationStatus");
            return (Criteria) this;
        }

        public Criteria andApplicationStatusLessThanOrEqualTo(String value) {
            addCriterion("application_status <=", value, "applicationStatus");
            return (Criteria) this;
        }

        public Criteria andApplicationStatusLike(String value) {
            addCriterion("application_status like", value, "applicationStatus");
            return (Criteria) this;
        }

        public Criteria andApplicationStatusNotLike(String value) {
            addCriterion("application_status not like", value, "applicationStatus");
            return (Criteria) this;
        }

        public Criteria andApplicationStatusIn(List<String> values) {
            addCriterion("application_status in", values, "applicationStatus");
            return (Criteria) this;
        }

        public Criteria andApplicationStatusNotIn(List<String> values) {
            addCriterion("application_status not in", values, "applicationStatus");
            return (Criteria) this;
        }

        public Criteria andApplicationStatusBetween(String value1, String value2) {
            addCriterion("application_status between", value1, value2, "applicationStatus");
            return (Criteria) this;
        }

        public Criteria andApplicationStatusNotBetween(String value1, String value2) {
            addCriterion("application_status not between", value1, value2, "applicationStatus");
            return (Criteria) this;
        }

        public Criteria andApplicationDocumentPathIsNull() {
            addCriterion("application_document_path is null");
            return (Criteria) this;
        }

        public Criteria andApplicationDocumentPathIsNotNull() {
            addCriterion("application_document_path is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationDocumentPathEqualTo(String value) {
            addCriterion("application_document_path =", value, "applicationDocumentPath");
            return (Criteria) this;
        }

        public Criteria andApplicationDocumentPathNotEqualTo(String value) {
            addCriterion("application_document_path <>", value, "applicationDocumentPath");
            return (Criteria) this;
        }

        public Criteria andApplicationDocumentPathGreaterThan(String value) {
            addCriterion("application_document_path >", value, "applicationDocumentPath");
            return (Criteria) this;
        }

        public Criteria andApplicationDocumentPathGreaterThanOrEqualTo(String value) {
            addCriterion("application_document_path >=", value, "applicationDocumentPath");
            return (Criteria) this;
        }

        public Criteria andApplicationDocumentPathLessThan(String value) {
            addCriterion("application_document_path <", value, "applicationDocumentPath");
            return (Criteria) this;
        }

        public Criteria andApplicationDocumentPathLessThanOrEqualTo(String value) {
            addCriterion("application_document_path <=", value, "applicationDocumentPath");
            return (Criteria) this;
        }

        public Criteria andApplicationDocumentPathLike(String value) {
            addCriterion("application_document_path like", value, "applicationDocumentPath");
            return (Criteria) this;
        }

        public Criteria andApplicationDocumentPathNotLike(String value) {
            addCriterion("application_document_path not like", value, "applicationDocumentPath");
            return (Criteria) this;
        }

        public Criteria andApplicationDocumentPathIn(List<String> values) {
            addCriterion("application_document_path in", values, "applicationDocumentPath");
            return (Criteria) this;
        }

        public Criteria andApplicationDocumentPathNotIn(List<String> values) {
            addCriterion("application_document_path not in", values, "applicationDocumentPath");
            return (Criteria) this;
        }

        public Criteria andApplicationDocumentPathBetween(String value1, String value2) {
            addCriterion("application_document_path between", value1, value2, "applicationDocumentPath");
            return (Criteria) this;
        }

        public Criteria andApplicationDocumentPathNotBetween(String value1, String value2) {
            addCriterion("application_document_path not between", value1, value2, "applicationDocumentPath");
            return (Criteria) this;
        }

        public Criteria andApplicantIdIsNull() {
            addCriterion("applicant_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicantIdIsNotNull() {
            addCriterion("applicant_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantIdEqualTo(Integer value) {
            addCriterion("applicant_id =", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdNotEqualTo(Integer value) {
            addCriterion("applicant_id <>", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdGreaterThan(Integer value) {
            addCriterion("applicant_id >", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("applicant_id >=", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdLessThan(Integer value) {
            addCriterion("applicant_id <", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdLessThanOrEqualTo(Integer value) {
            addCriterion("applicant_id <=", value, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdIn(List<Integer> values) {
            addCriterion("applicant_id in", values, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdNotIn(List<Integer> values) {
            addCriterion("applicant_id not in", values, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdBetween(Integer value1, Integer value2) {
            addCriterion("applicant_id between", value1, value2, "applicantId");
            return (Criteria) this;
        }

        public Criteria andApplicantIdNotBetween(Integer value1, Integer value2) {
            addCriterion("applicant_id not between", value1, value2, "applicantId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNull() {
            addCriterion("template_id is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNotNull() {
            addCriterion("template_id is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdEqualTo(Integer value) {
            addCriterion("template_id =", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotEqualTo(Integer value) {
            addCriterion("template_id <>", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThan(Integer value) {
            addCriterion("template_id >", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("template_id >=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThan(Integer value) {
            addCriterion("template_id <", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(Integer value) {
            addCriterion("template_id <=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIn(List<Integer> values) {
            addCriterion("template_id in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotIn(List<Integer> values) {
            addCriterion("template_id not in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdBetween(Integer value1, Integer value2) {
            addCriterion("template_id between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("template_id not between", value1, value2, "templateId");
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
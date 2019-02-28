package com.prosay.oa.domain;

import java.util.ArrayList;
import java.util.List;

public class TemplateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TemplateExample() {
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

        public Criteria andTemplateNameIsNull() {
            addCriterion("template_name is null");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIsNotNull() {
            addCriterion("template_name is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateNameEqualTo(String value) {
            addCriterion("template_name =", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotEqualTo(String value) {
            addCriterion("template_name <>", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameGreaterThan(String value) {
            addCriterion("template_name >", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameGreaterThanOrEqualTo(String value) {
            addCriterion("template_name >=", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLessThan(String value) {
            addCriterion("template_name <", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLessThanOrEqualTo(String value) {
            addCriterion("template_name <=", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameLike(String value) {
            addCriterion("template_name like", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotLike(String value) {
            addCriterion("template_name not like", value, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameIn(List<String> values) {
            addCriterion("template_name in", values, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotIn(List<String> values) {
            addCriterion("template_name not in", values, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameBetween(String value1, String value2) {
            addCriterion("template_name between", value1, value2, "templateName");
            return (Criteria) this;
        }

        public Criteria andTemplateNameNotBetween(String value1, String value2) {
            addCriterion("template_name not between", value1, value2, "templateName");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyIsNull() {
            addCriterion("process_definition_key is null");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyIsNotNull() {
            addCriterion("process_definition_key is not null");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyEqualTo(String value) {
            addCriterion("process_definition_key =", value, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyNotEqualTo(String value) {
            addCriterion("process_definition_key <>", value, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyGreaterThan(String value) {
            addCriterion("process_definition_key >", value, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyGreaterThanOrEqualTo(String value) {
            addCriterion("process_definition_key >=", value, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyLessThan(String value) {
            addCriterion("process_definition_key <", value, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyLessThanOrEqualTo(String value) {
            addCriterion("process_definition_key <=", value, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyLike(String value) {
            addCriterion("process_definition_key like", value, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyNotLike(String value) {
            addCriterion("process_definition_key not like", value, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyIn(List<String> values) {
            addCriterion("process_definition_key in", values, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyNotIn(List<String> values) {
            addCriterion("process_definition_key not in", values, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyBetween(String value1, String value2) {
            addCriterion("process_definition_key between", value1, value2, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionKeyNotBetween(String value1, String value2) {
            addCriterion("process_definition_key not between", value1, value2, "processDefinitionKey");
            return (Criteria) this;
        }

        public Criteria andTemplateDocumentPathIsNull() {
            addCriterion("template_document_path is null");
            return (Criteria) this;
        }

        public Criteria andTemplateDocumentPathIsNotNull() {
            addCriterion("template_document_path is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateDocumentPathEqualTo(String value) {
            addCriterion("template_document_path =", value, "templateDocumentPath");
            return (Criteria) this;
        }

        public Criteria andTemplateDocumentPathNotEqualTo(String value) {
            addCriterion("template_document_path <>", value, "templateDocumentPath");
            return (Criteria) this;
        }

        public Criteria andTemplateDocumentPathGreaterThan(String value) {
            addCriterion("template_document_path >", value, "templateDocumentPath");
            return (Criteria) this;
        }

        public Criteria andTemplateDocumentPathGreaterThanOrEqualTo(String value) {
            addCriterion("template_document_path >=", value, "templateDocumentPath");
            return (Criteria) this;
        }

        public Criteria andTemplateDocumentPathLessThan(String value) {
            addCriterion("template_document_path <", value, "templateDocumentPath");
            return (Criteria) this;
        }

        public Criteria andTemplateDocumentPathLessThanOrEqualTo(String value) {
            addCriterion("template_document_path <=", value, "templateDocumentPath");
            return (Criteria) this;
        }

        public Criteria andTemplateDocumentPathLike(String value) {
            addCriterion("template_document_path like", value, "templateDocumentPath");
            return (Criteria) this;
        }

        public Criteria andTemplateDocumentPathNotLike(String value) {
            addCriterion("template_document_path not like", value, "templateDocumentPath");
            return (Criteria) this;
        }

        public Criteria andTemplateDocumentPathIn(List<String> values) {
            addCriterion("template_document_path in", values, "templateDocumentPath");
            return (Criteria) this;
        }

        public Criteria andTemplateDocumentPathNotIn(List<String> values) {
            addCriterion("template_document_path not in", values, "templateDocumentPath");
            return (Criteria) this;
        }

        public Criteria andTemplateDocumentPathBetween(String value1, String value2) {
            addCriterion("template_document_path between", value1, value2, "templateDocumentPath");
            return (Criteria) this;
        }

        public Criteria andTemplateDocumentPathNotBetween(String value1, String value2) {
            addCriterion("template_document_path not between", value1, value2, "templateDocumentPath");
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
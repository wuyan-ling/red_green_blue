package com.bst.red_green_blue.pojo;

import java.util.ArrayList;
import java.util.List;

public class ApplicationFormExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplicationFormExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andResponsibilityNameIsNull() {
            addCriterion("responsibility_name is null");
            return (Criteria) this;
        }

        public Criteria andResponsibilityNameIsNotNull() {
            addCriterion("responsibility_name is not null");
            return (Criteria) this;
        }

        public Criteria andResponsibilityNameEqualTo(String value) {
            addCriterion("responsibility_name =", value, "responsibilityName");
            return (Criteria) this;
        }

        public Criteria andResponsibilityNameNotEqualTo(String value) {
            addCriterion("responsibility_name <>", value, "responsibilityName");
            return (Criteria) this;
        }

        public Criteria andResponsibilityNameGreaterThan(String value) {
            addCriterion("responsibility_name >", value, "responsibilityName");
            return (Criteria) this;
        }

        public Criteria andResponsibilityNameGreaterThanOrEqualTo(String value) {
            addCriterion("responsibility_name >=", value, "responsibilityName");
            return (Criteria) this;
        }

        public Criteria andResponsibilityNameLessThan(String value) {
            addCriterion("responsibility_name <", value, "responsibilityName");
            return (Criteria) this;
        }

        public Criteria andResponsibilityNameLessThanOrEqualTo(String value) {
            addCriterion("responsibility_name <=", value, "responsibilityName");
            return (Criteria) this;
        }

        public Criteria andResponsibilityNameLike(String value) {
            addCriterion("responsibility_name like", value, "responsibilityName");
            return (Criteria) this;
        }

        public Criteria andResponsibilityNameNotLike(String value) {
            addCriterion("responsibility_name not like", value, "responsibilityName");
            return (Criteria) this;
        }

        public Criteria andResponsibilityNameIn(List<String> values) {
            addCriterion("responsibility_name in", values, "responsibilityName");
            return (Criteria) this;
        }

        public Criteria andResponsibilityNameNotIn(List<String> values) {
            addCriterion("responsibility_name not in", values, "responsibilityName");
            return (Criteria) this;
        }

        public Criteria andResponsibilityNameBetween(String value1, String value2) {
            addCriterion("responsibility_name between", value1, value2, "responsibilityName");
            return (Criteria) this;
        }

        public Criteria andResponsibilityNameNotBetween(String value1, String value2) {
            addCriterion("responsibility_name not between", value1, value2, "responsibilityName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectInformationIsNull() {
            addCriterion("project_information is null");
            return (Criteria) this;
        }

        public Criteria andProjectInformationIsNotNull() {
            addCriterion("project_information is not null");
            return (Criteria) this;
        }

        public Criteria andProjectInformationEqualTo(String value) {
            addCriterion("project_information =", value, "projectInformation");
            return (Criteria) this;
        }

        public Criteria andProjectInformationNotEqualTo(String value) {
            addCriterion("project_information <>", value, "projectInformation");
            return (Criteria) this;
        }

        public Criteria andProjectInformationGreaterThan(String value) {
            addCriterion("project_information >", value, "projectInformation");
            return (Criteria) this;
        }

        public Criteria andProjectInformationGreaterThanOrEqualTo(String value) {
            addCriterion("project_information >=", value, "projectInformation");
            return (Criteria) this;
        }

        public Criteria andProjectInformationLessThan(String value) {
            addCriterion("project_information <", value, "projectInformation");
            return (Criteria) this;
        }

        public Criteria andProjectInformationLessThanOrEqualTo(String value) {
            addCriterion("project_information <=", value, "projectInformation");
            return (Criteria) this;
        }

        public Criteria andProjectInformationLike(String value) {
            addCriterion("project_information like", value, "projectInformation");
            return (Criteria) this;
        }

        public Criteria andProjectInformationNotLike(String value) {
            addCriterion("project_information not like", value, "projectInformation");
            return (Criteria) this;
        }

        public Criteria andProjectInformationIn(List<String> values) {
            addCriterion("project_information in", values, "projectInformation");
            return (Criteria) this;
        }

        public Criteria andProjectInformationNotIn(List<String> values) {
            addCriterion("project_information not in", values, "projectInformation");
            return (Criteria) this;
        }

        public Criteria andProjectInformationBetween(String value1, String value2) {
            addCriterion("project_information between", value1, value2, "projectInformation");
            return (Criteria) this;
        }

        public Criteria andProjectInformationNotBetween(String value1, String value2) {
            addCriterion("project_information not between", value1, value2, "projectInformation");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNull() {
            addCriterion("college is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNotNull() {
            addCriterion("college is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeEqualTo(String value) {
            addCriterion("college =", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotEqualTo(String value) {
            addCriterion("college <>", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThan(String value) {
            addCriterion("college >", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThanOrEqualTo(String value) {
            addCriterion("college >=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThan(String value) {
            addCriterion("college <", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThanOrEqualTo(String value) {
            addCriterion("college <=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLike(String value) {
            addCriterion("college like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotLike(String value) {
            addCriterion("college not like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeIn(List<String> values) {
            addCriterion("college in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotIn(List<String> values) {
            addCriterion("college not in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeBetween(String value1, String value2) {
            addCriterion("college between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotBetween(String value1, String value2) {
            addCriterion("college not between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andErrorMessageIsNull() {
            addCriterion("error_message is null");
            return (Criteria) this;
        }

        public Criteria andErrorMessageIsNotNull() {
            addCriterion("error_message is not null");
            return (Criteria) this;
        }

        public Criteria andErrorMessageEqualTo(String value) {
            addCriterion("error_message =", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotEqualTo(String value) {
            addCriterion("error_message <>", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageGreaterThan(String value) {
            addCriterion("error_message >", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageGreaterThanOrEqualTo(String value) {
            addCriterion("error_message >=", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageLessThan(String value) {
            addCriterion("error_message <", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageLessThanOrEqualTo(String value) {
            addCriterion("error_message <=", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageLike(String value) {
            addCriterion("error_message like", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotLike(String value) {
            addCriterion("error_message not like", value, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageIn(List<String> values) {
            addCriterion("error_message in", values, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotIn(List<String> values) {
            addCriterion("error_message not in", values, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageBetween(String value1, String value2) {
            addCriterion("error_message between", value1, value2, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andErrorMessageNotBetween(String value1, String value2) {
            addCriterion("error_message not between", value1, value2, "errorMessage");
            return (Criteria) this;
        }

        public Criteria andResponsibilityPhoneNumberIsNull() {
            addCriterion("responsibility_phone_number is null");
            return (Criteria) this;
        }

        public Criteria andResponsibilityPhoneNumberIsNotNull() {
            addCriterion("responsibility_phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andResponsibilityPhoneNumberEqualTo(String value) {
            addCriterion("responsibility_phone_number =", value, "responsibilityPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andResponsibilityPhoneNumberNotEqualTo(String value) {
            addCriterion("responsibility_phone_number <>", value, "responsibilityPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andResponsibilityPhoneNumberGreaterThan(String value) {
            addCriterion("responsibility_phone_number >", value, "responsibilityPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andResponsibilityPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("responsibility_phone_number >=", value, "responsibilityPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andResponsibilityPhoneNumberLessThan(String value) {
            addCriterion("responsibility_phone_number <", value, "responsibilityPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andResponsibilityPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("responsibility_phone_number <=", value, "responsibilityPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andResponsibilityPhoneNumberLike(String value) {
            addCriterion("responsibility_phone_number like", value, "responsibilityPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andResponsibilityPhoneNumberNotLike(String value) {
            addCriterion("responsibility_phone_number not like", value, "responsibilityPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andResponsibilityPhoneNumberIn(List<String> values) {
            addCriterion("responsibility_phone_number in", values, "responsibilityPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andResponsibilityPhoneNumberNotIn(List<String> values) {
            addCriterion("responsibility_phone_number not in", values, "responsibilityPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andResponsibilityPhoneNumberBetween(String value1, String value2) {
            addCriterion("responsibility_phone_number between", value1, value2, "responsibilityPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andResponsibilityPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("responsibility_phone_number not between", value1, value2, "responsibilityPhoneNumber");
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
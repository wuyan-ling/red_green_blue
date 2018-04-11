package com.bst.red_green_blue.pojo;

import java.util.ArrayList;
import java.util.List;

public class OperationMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperationMessageExample() {
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

        public Criteria andMonthTurnoverIsNull() {
            addCriterion("month_turnover is null");
            return (Criteria) this;
        }

        public Criteria andMonthTurnoverIsNotNull() {
            addCriterion("month_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andMonthTurnoverEqualTo(String value) {
            addCriterion("month_turnover =", value, "monthTurnover");
            return (Criteria) this;
        }

        public Criteria andMonthTurnoverNotEqualTo(String value) {
            addCriterion("month_turnover <>", value, "monthTurnover");
            return (Criteria) this;
        }

        public Criteria andMonthTurnoverGreaterThan(String value) {
            addCriterion("month_turnover >", value, "monthTurnover");
            return (Criteria) this;
        }

        public Criteria andMonthTurnoverGreaterThanOrEqualTo(String value) {
            addCriterion("month_turnover >=", value, "monthTurnover");
            return (Criteria) this;
        }

        public Criteria andMonthTurnoverLessThan(String value) {
            addCriterion("month_turnover <", value, "monthTurnover");
            return (Criteria) this;
        }

        public Criteria andMonthTurnoverLessThanOrEqualTo(String value) {
            addCriterion("month_turnover <=", value, "monthTurnover");
            return (Criteria) this;
        }

        public Criteria andMonthTurnoverLike(String value) {
            addCriterion("month_turnover like", value, "monthTurnover");
            return (Criteria) this;
        }

        public Criteria andMonthTurnoverNotLike(String value) {
            addCriterion("month_turnover not like", value, "monthTurnover");
            return (Criteria) this;
        }

        public Criteria andMonthTurnoverIn(List<String> values) {
            addCriterion("month_turnover in", values, "monthTurnover");
            return (Criteria) this;
        }

        public Criteria andMonthTurnoverNotIn(List<String> values) {
            addCriterion("month_turnover not in", values, "monthTurnover");
            return (Criteria) this;
        }

        public Criteria andMonthTurnoverBetween(String value1, String value2) {
            addCriterion("month_turnover between", value1, value2, "monthTurnover");
            return (Criteria) this;
        }

        public Criteria andMonthTurnoverNotBetween(String value1, String value2) {
            addCriterion("month_turnover not between", value1, value2, "monthTurnover");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeIsNull() {
            addCriterion("transaction_time is null");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeIsNotNull() {
            addCriterion("transaction_time is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeEqualTo(Integer value) {
            addCriterion("transaction_time =", value, "transactionTime");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeNotEqualTo(Integer value) {
            addCriterion("transaction_time <>", value, "transactionTime");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeGreaterThan(Integer value) {
            addCriterion("transaction_time >", value, "transactionTime");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("transaction_time >=", value, "transactionTime");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeLessThan(Integer value) {
            addCriterion("transaction_time <", value, "transactionTime");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeLessThanOrEqualTo(Integer value) {
            addCriterion("transaction_time <=", value, "transactionTime");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeIn(List<Integer> values) {
            addCriterion("transaction_time in", values, "transactionTime");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeNotIn(List<Integer> values) {
            addCriterion("transaction_time not in", values, "transactionTime");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeBetween(Integer value1, Integer value2) {
            addCriterion("transaction_time between", value1, value2, "transactionTime");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("transaction_time not between", value1, value2, "transactionTime");
            return (Criteria) this;
        }

        public Criteria andProductMainIsNull() {
            addCriterion("product_main is null");
            return (Criteria) this;
        }

        public Criteria andProductMainIsNotNull() {
            addCriterion("product_main is not null");
            return (Criteria) this;
        }

        public Criteria andProductMainEqualTo(String value) {
            addCriterion("product_main =", value, "productMain");
            return (Criteria) this;
        }

        public Criteria andProductMainNotEqualTo(String value) {
            addCriterion("product_main <>", value, "productMain");
            return (Criteria) this;
        }

        public Criteria andProductMainGreaterThan(String value) {
            addCriterion("product_main >", value, "productMain");
            return (Criteria) this;
        }

        public Criteria andProductMainGreaterThanOrEqualTo(String value) {
            addCriterion("product_main >=", value, "productMain");
            return (Criteria) this;
        }

        public Criteria andProductMainLessThan(String value) {
            addCriterion("product_main <", value, "productMain");
            return (Criteria) this;
        }

        public Criteria andProductMainLessThanOrEqualTo(String value) {
            addCriterion("product_main <=", value, "productMain");
            return (Criteria) this;
        }

        public Criteria andProductMainLike(String value) {
            addCriterion("product_main like", value, "productMain");
            return (Criteria) this;
        }

        public Criteria andProductMainNotLike(String value) {
            addCriterion("product_main not like", value, "productMain");
            return (Criteria) this;
        }

        public Criteria andProductMainIn(List<String> values) {
            addCriterion("product_main in", values, "productMain");
            return (Criteria) this;
        }

        public Criteria andProductMainNotIn(List<String> values) {
            addCriterion("product_main not in", values, "productMain");
            return (Criteria) this;
        }

        public Criteria andProductMainBetween(String value1, String value2) {
            addCriterion("product_main between", value1, value2, "productMain");
            return (Criteria) this;
        }

        public Criteria andProductMainNotBetween(String value1, String value2) {
            addCriterion("product_main not between", value1, value2, "productMain");
            return (Criteria) this;
        }

        public Criteria andProductMinorIsNull() {
            addCriterion("product_minor is null");
            return (Criteria) this;
        }

        public Criteria andProductMinorIsNotNull() {
            addCriterion("product_minor is not null");
            return (Criteria) this;
        }

        public Criteria andProductMinorEqualTo(String value) {
            addCriterion("product_minor =", value, "productMinor");
            return (Criteria) this;
        }

        public Criteria andProductMinorNotEqualTo(String value) {
            addCriterion("product_minor <>", value, "productMinor");
            return (Criteria) this;
        }

        public Criteria andProductMinorGreaterThan(String value) {
            addCriterion("product_minor >", value, "productMinor");
            return (Criteria) this;
        }

        public Criteria andProductMinorGreaterThanOrEqualTo(String value) {
            addCriterion("product_minor >=", value, "productMinor");
            return (Criteria) this;
        }

        public Criteria andProductMinorLessThan(String value) {
            addCriterion("product_minor <", value, "productMinor");
            return (Criteria) this;
        }

        public Criteria andProductMinorLessThanOrEqualTo(String value) {
            addCriterion("product_minor <=", value, "productMinor");
            return (Criteria) this;
        }

        public Criteria andProductMinorLike(String value) {
            addCriterion("product_minor like", value, "productMinor");
            return (Criteria) this;
        }

        public Criteria andProductMinorNotLike(String value) {
            addCriterion("product_minor not like", value, "productMinor");
            return (Criteria) this;
        }

        public Criteria andProductMinorIn(List<String> values) {
            addCriterion("product_minor in", values, "productMinor");
            return (Criteria) this;
        }

        public Criteria andProductMinorNotIn(List<String> values) {
            addCriterion("product_minor not in", values, "productMinor");
            return (Criteria) this;
        }

        public Criteria andProductMinorBetween(String value1, String value2) {
            addCriterion("product_minor between", value1, value2, "productMinor");
            return (Criteria) this;
        }

        public Criteria andProductMinorNotBetween(String value1, String value2) {
            addCriterion("product_minor not between", value1, value2, "productMinor");
            return (Criteria) this;
        }

        public Criteria andBuyCostIsNull() {
            addCriterion("buy_cost is null");
            return (Criteria) this;
        }

        public Criteria andBuyCostIsNotNull() {
            addCriterion("buy_cost is not null");
            return (Criteria) this;
        }

        public Criteria andBuyCostEqualTo(String value) {
            addCriterion("buy_cost =", value, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostNotEqualTo(String value) {
            addCriterion("buy_cost <>", value, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostGreaterThan(String value) {
            addCriterion("buy_cost >", value, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostGreaterThanOrEqualTo(String value) {
            addCriterion("buy_cost >=", value, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostLessThan(String value) {
            addCriterion("buy_cost <", value, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostLessThanOrEqualTo(String value) {
            addCriterion("buy_cost <=", value, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostLike(String value) {
            addCriterion("buy_cost like", value, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostNotLike(String value) {
            addCriterion("buy_cost not like", value, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostIn(List<String> values) {
            addCriterion("buy_cost in", values, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostNotIn(List<String> values) {
            addCriterion("buy_cost not in", values, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostBetween(String value1, String value2) {
            addCriterion("buy_cost between", value1, value2, "buyCost");
            return (Criteria) this;
        }

        public Criteria andBuyCostNotBetween(String value1, String value2) {
            addCriterion("buy_cost not between", value1, value2, "buyCost");
            return (Criteria) this;
        }

        public Criteria andEmployeeExpendIsNull() {
            addCriterion("employee_expend is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeExpendIsNotNull() {
            addCriterion("employee_expend is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeExpendEqualTo(String value) {
            addCriterion("employee_expend =", value, "employeeExpend");
            return (Criteria) this;
        }

        public Criteria andEmployeeExpendNotEqualTo(String value) {
            addCriterion("employee_expend <>", value, "employeeExpend");
            return (Criteria) this;
        }

        public Criteria andEmployeeExpendGreaterThan(String value) {
            addCriterion("employee_expend >", value, "employeeExpend");
            return (Criteria) this;
        }

        public Criteria andEmployeeExpendGreaterThanOrEqualTo(String value) {
            addCriterion("employee_expend >=", value, "employeeExpend");
            return (Criteria) this;
        }

        public Criteria andEmployeeExpendLessThan(String value) {
            addCriterion("employee_expend <", value, "employeeExpend");
            return (Criteria) this;
        }

        public Criteria andEmployeeExpendLessThanOrEqualTo(String value) {
            addCriterion("employee_expend <=", value, "employeeExpend");
            return (Criteria) this;
        }

        public Criteria andEmployeeExpendLike(String value) {
            addCriterion("employee_expend like", value, "employeeExpend");
            return (Criteria) this;
        }

        public Criteria andEmployeeExpendNotLike(String value) {
            addCriterion("employee_expend not like", value, "employeeExpend");
            return (Criteria) this;
        }

        public Criteria andEmployeeExpendIn(List<String> values) {
            addCriterion("employee_expend in", values, "employeeExpend");
            return (Criteria) this;
        }

        public Criteria andEmployeeExpendNotIn(List<String> values) {
            addCriterion("employee_expend not in", values, "employeeExpend");
            return (Criteria) this;
        }

        public Criteria andEmployeeExpendBetween(String value1, String value2) {
            addCriterion("employee_expend between", value1, value2, "employeeExpend");
            return (Criteria) this;
        }

        public Criteria andEmployeeExpendNotBetween(String value1, String value2) {
            addCriterion("employee_expend not between", value1, value2, "employeeExpend");
            return (Criteria) this;
        }

        public Criteria andLiabilityIsNull() {
            addCriterion("liability is null");
            return (Criteria) this;
        }

        public Criteria andLiabilityIsNotNull() {
            addCriterion("liability is not null");
            return (Criteria) this;
        }

        public Criteria andLiabilityEqualTo(String value) {
            addCriterion("liability =", value, "liability");
            return (Criteria) this;
        }

        public Criteria andLiabilityNotEqualTo(String value) {
            addCriterion("liability <>", value, "liability");
            return (Criteria) this;
        }

        public Criteria andLiabilityGreaterThan(String value) {
            addCriterion("liability >", value, "liability");
            return (Criteria) this;
        }

        public Criteria andLiabilityGreaterThanOrEqualTo(String value) {
            addCriterion("liability >=", value, "liability");
            return (Criteria) this;
        }

        public Criteria andLiabilityLessThan(String value) {
            addCriterion("liability <", value, "liability");
            return (Criteria) this;
        }

        public Criteria andLiabilityLessThanOrEqualTo(String value) {
            addCriterion("liability <=", value, "liability");
            return (Criteria) this;
        }

        public Criteria andLiabilityLike(String value) {
            addCriterion("liability like", value, "liability");
            return (Criteria) this;
        }

        public Criteria andLiabilityNotLike(String value) {
            addCriterion("liability not like", value, "liability");
            return (Criteria) this;
        }

        public Criteria andLiabilityIn(List<String> values) {
            addCriterion("liability in", values, "liability");
            return (Criteria) this;
        }

        public Criteria andLiabilityNotIn(List<String> values) {
            addCriterion("liability not in", values, "liability");
            return (Criteria) this;
        }

        public Criteria andLiabilityBetween(String value1, String value2) {
            addCriterion("liability between", value1, value2, "liability");
            return (Criteria) this;
        }

        public Criteria andLiabilityNotBetween(String value1, String value2) {
            addCriterion("liability not between", value1, value2, "liability");
            return (Criteria) this;
        }

        public Criteria andInvestmentIsNull() {
            addCriterion("investment is null");
            return (Criteria) this;
        }

        public Criteria andInvestmentIsNotNull() {
            addCriterion("investment is not null");
            return (Criteria) this;
        }

        public Criteria andInvestmentEqualTo(String value) {
            addCriterion("investment =", value, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentNotEqualTo(String value) {
            addCriterion("investment <>", value, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentGreaterThan(String value) {
            addCriterion("investment >", value, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentGreaterThanOrEqualTo(String value) {
            addCriterion("investment >=", value, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentLessThan(String value) {
            addCriterion("investment <", value, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentLessThanOrEqualTo(String value) {
            addCriterion("investment <=", value, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentLike(String value) {
            addCriterion("investment like", value, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentNotLike(String value) {
            addCriterion("investment not like", value, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentIn(List<String> values) {
            addCriterion("investment in", values, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentNotIn(List<String> values) {
            addCriterion("investment not in", values, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentBetween(String value1, String value2) {
            addCriterion("investment between", value1, value2, "investment");
            return (Criteria) this;
        }

        public Criteria andInvestmentNotBetween(String value1, String value2) {
            addCriterion("investment not between", value1, value2, "investment");
            return (Criteria) this;
        }

        public Criteria andMonthWorkIsNull() {
            addCriterion("month_work is null");
            return (Criteria) this;
        }

        public Criteria andMonthWorkIsNotNull() {
            addCriterion("month_work is not null");
            return (Criteria) this;
        }

        public Criteria andMonthWorkEqualTo(String value) {
            addCriterion("month_work =", value, "monthWork");
            return (Criteria) this;
        }

        public Criteria andMonthWorkNotEqualTo(String value) {
            addCriterion("month_work <>", value, "monthWork");
            return (Criteria) this;
        }

        public Criteria andMonthWorkGreaterThan(String value) {
            addCriterion("month_work >", value, "monthWork");
            return (Criteria) this;
        }

        public Criteria andMonthWorkGreaterThanOrEqualTo(String value) {
            addCriterion("month_work >=", value, "monthWork");
            return (Criteria) this;
        }

        public Criteria andMonthWorkLessThan(String value) {
            addCriterion("month_work <", value, "monthWork");
            return (Criteria) this;
        }

        public Criteria andMonthWorkLessThanOrEqualTo(String value) {
            addCriterion("month_work <=", value, "monthWork");
            return (Criteria) this;
        }

        public Criteria andMonthWorkLike(String value) {
            addCriterion("month_work like", value, "monthWork");
            return (Criteria) this;
        }

        public Criteria andMonthWorkNotLike(String value) {
            addCriterion("month_work not like", value, "monthWork");
            return (Criteria) this;
        }

        public Criteria andMonthWorkIn(List<String> values) {
            addCriterion("month_work in", values, "monthWork");
            return (Criteria) this;
        }

        public Criteria andMonthWorkNotIn(List<String> values) {
            addCriterion("month_work not in", values, "monthWork");
            return (Criteria) this;
        }

        public Criteria andMonthWorkBetween(String value1, String value2) {
            addCriterion("month_work between", value1, value2, "monthWork");
            return (Criteria) this;
        }

        public Criteria andMonthWorkNotBetween(String value1, String value2) {
            addCriterion("month_work not between", value1, value2, "monthWork");
            return (Criteria) this;
        }

        public Criteria andNextMonthWorkIsNull() {
            addCriterion("next_month_work is null");
            return (Criteria) this;
        }

        public Criteria andNextMonthWorkIsNotNull() {
            addCriterion("next_month_work is not null");
            return (Criteria) this;
        }

        public Criteria andNextMonthWorkEqualTo(String value) {
            addCriterion("next_month_work =", value, "nextMonthWork");
            return (Criteria) this;
        }

        public Criteria andNextMonthWorkNotEqualTo(String value) {
            addCriterion("next_month_work <>", value, "nextMonthWork");
            return (Criteria) this;
        }

        public Criteria andNextMonthWorkGreaterThan(String value) {
            addCriterion("next_month_work >", value, "nextMonthWork");
            return (Criteria) this;
        }

        public Criteria andNextMonthWorkGreaterThanOrEqualTo(String value) {
            addCriterion("next_month_work >=", value, "nextMonthWork");
            return (Criteria) this;
        }

        public Criteria andNextMonthWorkLessThan(String value) {
            addCriterion("next_month_work <", value, "nextMonthWork");
            return (Criteria) this;
        }

        public Criteria andNextMonthWorkLessThanOrEqualTo(String value) {
            addCriterion("next_month_work <=", value, "nextMonthWork");
            return (Criteria) this;
        }

        public Criteria andNextMonthWorkLike(String value) {
            addCriterion("next_month_work like", value, "nextMonthWork");
            return (Criteria) this;
        }

        public Criteria andNextMonthWorkNotLike(String value) {
            addCriterion("next_month_work not like", value, "nextMonthWork");
            return (Criteria) this;
        }

        public Criteria andNextMonthWorkIn(List<String> values) {
            addCriterion("next_month_work in", values, "nextMonthWork");
            return (Criteria) this;
        }

        public Criteria andNextMonthWorkNotIn(List<String> values) {
            addCriterion("next_month_work not in", values, "nextMonthWork");
            return (Criteria) this;
        }

        public Criteria andNextMonthWorkBetween(String value1, String value2) {
            addCriterion("next_month_work between", value1, value2, "nextMonthWork");
            return (Criteria) this;
        }

        public Criteria andNextMonthWorkNotBetween(String value1, String value2) {
            addCriterion("next_month_work not between", value1, value2, "nextMonthWork");
            return (Criteria) this;
        }

        public Criteria andProjectSpecialtyIsNull() {
            addCriterion("project_specialty is null");
            return (Criteria) this;
        }

        public Criteria andProjectSpecialtyIsNotNull() {
            addCriterion("project_specialty is not null");
            return (Criteria) this;
        }

        public Criteria andProjectSpecialtyEqualTo(String value) {
            addCriterion("project_specialty =", value, "projectSpecialty");
            return (Criteria) this;
        }

        public Criteria andProjectSpecialtyNotEqualTo(String value) {
            addCriterion("project_specialty <>", value, "projectSpecialty");
            return (Criteria) this;
        }

        public Criteria andProjectSpecialtyGreaterThan(String value) {
            addCriterion("project_specialty >", value, "projectSpecialty");
            return (Criteria) this;
        }

        public Criteria andProjectSpecialtyGreaterThanOrEqualTo(String value) {
            addCriterion("project_specialty >=", value, "projectSpecialty");
            return (Criteria) this;
        }

        public Criteria andProjectSpecialtyLessThan(String value) {
            addCriterion("project_specialty <", value, "projectSpecialty");
            return (Criteria) this;
        }

        public Criteria andProjectSpecialtyLessThanOrEqualTo(String value) {
            addCriterion("project_specialty <=", value, "projectSpecialty");
            return (Criteria) this;
        }

        public Criteria andProjectSpecialtyLike(String value) {
            addCriterion("project_specialty like", value, "projectSpecialty");
            return (Criteria) this;
        }

        public Criteria andProjectSpecialtyNotLike(String value) {
            addCriterion("project_specialty not like", value, "projectSpecialty");
            return (Criteria) this;
        }

        public Criteria andProjectSpecialtyIn(List<String> values) {
            addCriterion("project_specialty in", values, "projectSpecialty");
            return (Criteria) this;
        }

        public Criteria andProjectSpecialtyNotIn(List<String> values) {
            addCriterion("project_specialty not in", values, "projectSpecialty");
            return (Criteria) this;
        }

        public Criteria andProjectSpecialtyBetween(String value1, String value2) {
            addCriterion("project_specialty between", value1, value2, "projectSpecialty");
            return (Criteria) this;
        }

        public Criteria andProjectSpecialtyNotBetween(String value1, String value2) {
            addCriterion("project_specialty not between", value1, value2, "projectSpecialty");
            return (Criteria) this;
        }

        public Criteria andProjectQuestionIsNull() {
            addCriterion("project_question is null");
            return (Criteria) this;
        }

        public Criteria andProjectQuestionIsNotNull() {
            addCriterion("project_question is not null");
            return (Criteria) this;
        }

        public Criteria andProjectQuestionEqualTo(String value) {
            addCriterion("project_question =", value, "projectQuestion");
            return (Criteria) this;
        }

        public Criteria andProjectQuestionNotEqualTo(String value) {
            addCriterion("project_question <>", value, "projectQuestion");
            return (Criteria) this;
        }

        public Criteria andProjectQuestionGreaterThan(String value) {
            addCriterion("project_question >", value, "projectQuestion");
            return (Criteria) this;
        }

        public Criteria andProjectQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("project_question >=", value, "projectQuestion");
            return (Criteria) this;
        }

        public Criteria andProjectQuestionLessThan(String value) {
            addCriterion("project_question <", value, "projectQuestion");
            return (Criteria) this;
        }

        public Criteria andProjectQuestionLessThanOrEqualTo(String value) {
            addCriterion("project_question <=", value, "projectQuestion");
            return (Criteria) this;
        }

        public Criteria andProjectQuestionLike(String value) {
            addCriterion("project_question like", value, "projectQuestion");
            return (Criteria) this;
        }

        public Criteria andProjectQuestionNotLike(String value) {
            addCriterion("project_question not like", value, "projectQuestion");
            return (Criteria) this;
        }

        public Criteria andProjectQuestionIn(List<String> values) {
            addCriterion("project_question in", values, "projectQuestion");
            return (Criteria) this;
        }

        public Criteria andProjectQuestionNotIn(List<String> values) {
            addCriterion("project_question not in", values, "projectQuestion");
            return (Criteria) this;
        }

        public Criteria andProjectQuestionBetween(String value1, String value2) {
            addCriterion("project_question between", value1, value2, "projectQuestion");
            return (Criteria) this;
        }

        public Criteria andProjectQuestionNotBetween(String value1, String value2) {
            addCriterion("project_question not between", value1, value2, "projectQuestion");
            return (Criteria) this;
        }

        public Criteria andTeamNeedIsNull() {
            addCriterion("team_need is null");
            return (Criteria) this;
        }

        public Criteria andTeamNeedIsNotNull() {
            addCriterion("team_need is not null");
            return (Criteria) this;
        }

        public Criteria andTeamNeedEqualTo(String value) {
            addCriterion("team_need =", value, "teamNeed");
            return (Criteria) this;
        }

        public Criteria andTeamNeedNotEqualTo(String value) {
            addCriterion("team_need <>", value, "teamNeed");
            return (Criteria) this;
        }

        public Criteria andTeamNeedGreaterThan(String value) {
            addCriterion("team_need >", value, "teamNeed");
            return (Criteria) this;
        }

        public Criteria andTeamNeedGreaterThanOrEqualTo(String value) {
            addCriterion("team_need >=", value, "teamNeed");
            return (Criteria) this;
        }

        public Criteria andTeamNeedLessThan(String value) {
            addCriterion("team_need <", value, "teamNeed");
            return (Criteria) this;
        }

        public Criteria andTeamNeedLessThanOrEqualTo(String value) {
            addCriterion("team_need <=", value, "teamNeed");
            return (Criteria) this;
        }

        public Criteria andTeamNeedLike(String value) {
            addCriterion("team_need like", value, "teamNeed");
            return (Criteria) this;
        }

        public Criteria andTeamNeedNotLike(String value) {
            addCriterion("team_need not like", value, "teamNeed");
            return (Criteria) this;
        }

        public Criteria andTeamNeedIn(List<String> values) {
            addCriterion("team_need in", values, "teamNeed");
            return (Criteria) this;
        }

        public Criteria andTeamNeedNotIn(List<String> values) {
            addCriterion("team_need not in", values, "teamNeed");
            return (Criteria) this;
        }

        public Criteria andTeamNeedBetween(String value1, String value2) {
            addCriterion("team_need between", value1, value2, "teamNeed");
            return (Criteria) this;
        }

        public Criteria andTeamNeedNotBetween(String value1, String value2) {
            addCriterion("team_need not between", value1, value2, "teamNeed");
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
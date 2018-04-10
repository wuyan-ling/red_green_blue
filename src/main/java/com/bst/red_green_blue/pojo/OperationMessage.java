package com.bst.red_green_blue.pojo;

public class OperationMessage {
    private String id;

    private String monthTurnover;

    private Integer transactionTime;

    private String productMain;

    private String productMinor;

    private String buyCost;

    private String employeeExpend;

    private String liability;

    private String investment;

    public OperationMessage(String id, String monthTurnover, Integer transactionTime, String productMain, String productMinor, String buyCost, String employeeExpend, String liability, String investment) {
        this.id = id;
        this.monthTurnover = monthTurnover;
        this.transactionTime = transactionTime;
        this.productMain = productMain;
        this.productMinor = productMinor;
        this.buyCost = buyCost;
        this.employeeExpend = employeeExpend;
        this.liability = liability;
        this.investment = investment;
    }

    public OperationMessage() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMonthTurnover() {
        return monthTurnover;
    }

    public void setMonthTurnover(String monthTurnover) {
        this.monthTurnover = monthTurnover == null ? null : monthTurnover.trim();
    }

    public Integer getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Integer transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getProductMain() {
        return productMain;
    }

    public void setProductMain(String productMain) {
        this.productMain = productMain == null ? null : productMain.trim();
    }

    public String getProductMinor() {
        return productMinor;
    }

    public void setProductMinor(String productMinor) {
        this.productMinor = productMinor == null ? null : productMinor.trim();
    }

    public String getBuyCost() {
        return buyCost;
    }

    public void setBuyCost(String buyCost) {
        this.buyCost = buyCost == null ? null : buyCost.trim();
    }

    public String getEmployeeExpend() {
        return employeeExpend;
    }

    public void setEmployeeExpend(String employeeExpend) {
        this.employeeExpend = employeeExpend == null ? null : employeeExpend.trim();
    }

    public String getLiability() {
        return liability;
    }

    public void setLiability(String liability) {
        this.liability = liability == null ? null : liability.trim();
    }

    public String getInvestment() {
        return investment;
    }

    public void setInvestment(String investment) {
        this.investment = investment == null ? null : investment.trim();
    }
}
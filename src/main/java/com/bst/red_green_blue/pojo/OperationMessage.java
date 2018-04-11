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

    private String monthWork;

    private String nextMonthWork;

    private String projectSpecialty;

    private String projectQuestion;

    private String teamNeed;

    public OperationMessage(String id, String monthTurnover, Integer transactionTime, String productMain, String productMinor, String buyCost, String employeeExpend, String liability, String investment, String monthWork, String nextMonthWork, String projectSpecialty, String projectQuestion, String teamNeed) {
        this.id = id;
        this.monthTurnover = monthTurnover;
        this.transactionTime = transactionTime;
        this.productMain = productMain;
        this.productMinor = productMinor;
        this.buyCost = buyCost;
        this.employeeExpend = employeeExpend;
        this.liability = liability;
        this.investment = investment;
        this.monthWork = monthWork;
        this.nextMonthWork = nextMonthWork;
        this.projectSpecialty = projectSpecialty;
        this.projectQuestion = projectQuestion;
        this.teamNeed = teamNeed;
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

    public String getMonthWork() {
        return monthWork;
    }

    public void setMonthWork(String monthWork) {
        this.monthWork = monthWork == null ? null : monthWork.trim();
    }

    public String getNextMonthWork() {
        return nextMonthWork;
    }

    public void setNextMonthWork(String nextMonthWork) {
        this.nextMonthWork = nextMonthWork == null ? null : nextMonthWork.trim();
    }

    public String getProjectSpecialty() {
        return projectSpecialty;
    }

    public void setProjectSpecialty(String projectSpecialty) {
        this.projectSpecialty = projectSpecialty == null ? null : projectSpecialty.trim();
    }

    public String getProjectQuestion() {
        return projectQuestion;
    }

    public void setProjectQuestion(String projectQuestion) {
        this.projectQuestion = projectQuestion == null ? null : projectQuestion.trim();
    }

    public String getTeamNeed() {
        return teamNeed;
    }

    public void setTeamNeed(String teamNeed) {
        this.teamNeed = teamNeed == null ? null : teamNeed.trim();
    }
}
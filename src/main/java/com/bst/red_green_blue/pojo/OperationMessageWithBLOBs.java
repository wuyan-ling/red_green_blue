package com.bst.red_green_blue.pojo;

public class OperationMessageWithBLOBs extends OperationMessage {
    private String monthWork;

    private String nextMonthWork;

    private String projectSpecialty;

    private String projectQuestion;

    private String teamNeed;

    public OperationMessageWithBLOBs(String id, String monthTurnover, Integer transactionTime, String productMain, String productMinor, String buyCost, String employeeExpend, String liability, String investment, String monthWork, String nextMonthWork, String projectSpecialty, String projectQuestion, String teamNeed) {
        super(id, monthTurnover, transactionTime, productMain, productMinor, buyCost, employeeExpend, liability, investment);
        this.monthWork = monthWork;
        this.nextMonthWork = nextMonthWork;
        this.projectSpecialty = projectSpecialty;
        this.projectQuestion = projectQuestion;
        this.teamNeed = teamNeed;
    }

    public OperationMessageWithBLOBs() {
        super();
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
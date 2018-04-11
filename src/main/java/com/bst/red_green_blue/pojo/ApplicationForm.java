package com.bst.red_green_blue.pojo;

import com.bst.red_green_blue.pojo.vo.ApplicationFormVo;

public class ApplicationForm {
    private String id;

    private String responsibilityName;

    private String projectName;

    private String projectInformation;

    private String college;

    private Integer status;

    private String errorMessage;

    private String responsibilityPhoneNumber;

    public ApplicationForm(String id, String responsibilityName, String projectName, String projectInformation, String college, Integer status, String errorMessage, String responsibilityPhoneNumber) {
        this.id = id;
        this.responsibilityName = responsibilityName;
        this.projectName = projectName;
        this.projectInformation = projectInformation;
        this.college = college;
        this.status = status;
        this.errorMessage = errorMessage;
        this.responsibilityPhoneNumber = responsibilityPhoneNumber;
    }

    public ApplicationForm(ApplicationFormVo formVo,String id) {
        this.id = id;
        this.responsibilityName = formVo.getResponsibilityName();
        this.projectName = formVo.getProjectName();
        this.projectInformation = formVo.getProjectInformation();
        this.college = formVo.getCollege();
        this.responsibilityPhoneNumber = formVo.getResponsibilityPhoneNumber();
    }
    public ApplicationForm() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getResponsibilityName() {
        return responsibilityName;
    }

    public void setResponsibilityName(String responsibilityName) {
        this.responsibilityName = responsibilityName == null ? null : responsibilityName.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectInformation() {
        return projectInformation;
    }

    public void setProjectInformation(String projectInformation) {
        this.projectInformation = projectInformation == null ? null : projectInformation.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage == null ? null : errorMessage.trim();
    }

    public String getResponsibilityPhoneNumber() {
        return responsibilityPhoneNumber;
    }

    public void setResponsibilityPhoneNumber(String responsibilityPhoneNumber) {
        this.responsibilityPhoneNumber = responsibilityPhoneNumber == null ? null : responsibilityPhoneNumber.trim();
    }
}
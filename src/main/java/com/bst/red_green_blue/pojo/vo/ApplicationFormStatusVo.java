package com.bst.red_green_blue.pojo.vo;

import com.bst.red_green_blue.pojo.ApplicationForm;

/**
 * @author XHJ
 * 2018/4/11 14:47
 */
public class ApplicationFormStatusVo {

    private String responsibilityName;

    private String projectName;

    private String college;

    private Integer status;

    private String errorMessage;

    private String responsibilityPhoneNumber;

    private String projectInformation;


    public String getResponsibilityName() {
        return responsibilityName;
    }

    public ApplicationFormStatusVo setResponsibilityName(String responsibilityName) {
        this.responsibilityName = responsibilityName;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public ApplicationFormStatusVo setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getCollege() {
        return college;
    }

    public ApplicationFormStatusVo setCollege(String college) {
        this.college = college;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ApplicationFormStatusVo setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ApplicationFormStatusVo setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public String getResponsibilityPhoneNumber() {
        return responsibilityPhoneNumber;
    }

    public ApplicationFormStatusVo setResponsibilityPhoneNumber(String responsibilityPhoneNumber) {
        this.responsibilityPhoneNumber = responsibilityPhoneNumber;
        return this;
    }

    public String getProjectInformation() {
        return projectInformation;
    }

    public ApplicationFormStatusVo setProjectInformation(String projectInformation) {
        this.projectInformation = projectInformation;
        return this;
    }

    @Override
    public String toString() {
        return "ApplicationFormStatusVo{" +
                "responsibilityName='" + responsibilityName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", college='" + college + '\'' +
                ", status=" + status +
                ", errorMessage='" + errorMessage + '\'' +
                ", responsibilityPhoneNumber='" + responsibilityPhoneNumber + '\'' +
                ", projectInformation='" + projectInformation + '\'' +
                '}';
    }
}

package com.bst.red_green_blue.pojo.vo;

import javax.validation.constraints.NotBlank;

/**
 * @author XHJ
 * 2018/4/10 21:09
 */
public class ApplicationFormVo {
    @NotBlank(message = "项目名称不能为空")
    private String projectName;
    @NotBlank(message = "负责人姓名不能为空")
    private String responsibilityName;
    @NotBlank(message = "团队所属学院不能为空")
    private String college;
    @NotBlank(message = "项目负责人电话不能为空")
    private String responsibilityPhoneNumber;
    private Integer status;
    private String projectInformation;

    public ApplicationFormVo(@NotBlank(message = "项目名称不能为空") String projectName, @NotBlank(message = "负责人姓名不能为空") String responsibilityName, @NotBlank(message = "团队所属学院不能为空") String college, @NotBlank(message = "项目负责人电话不能为空") String responsibilityPhoneNumber, Integer status, String projectInformation) {
        this.projectName = projectName;
        this.responsibilityName = responsibilityName;
        this.college = college;
        this.responsibilityPhoneNumber = responsibilityPhoneNumber;
        this.status = status;
        this.projectInformation = projectInformation;
    }

    public String getProjectName() {
        return projectName;
    }

    public ApplicationFormVo setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getResponsibilityName() {
        return responsibilityName;
    }

    public ApplicationFormVo setResponsibilityName(String responsibilityName) {
        this.responsibilityName = responsibilityName;
        return this;
    }

    public String getCollege() {
        return college;
    }

    public ApplicationFormVo setCollege(String college) {
        this.college = college;
        return this;
    }

    public String getResponsibilityPhoneNumber() {
        return responsibilityPhoneNumber;
    }

    public ApplicationFormVo setResponsibilityPhoneNumber(String responsibilityPhoneNumber) {
        this.responsibilityPhoneNumber = responsibilityPhoneNumber;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ApplicationFormVo setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getProjectInformation() {
        return projectInformation;
    }

    public ApplicationFormVo setProjectInformation(String projectInformation) {
        this.projectInformation = projectInformation;
        return this;
    }

    @Override
    public String toString() {
        return "ApplicationFormVo{" +
                "projectName='" + projectName + '\'' +
                ", responsibilityName='" + responsibilityName + '\'' +
                ", college='" + college + '\'' +
                ", responsibilityPhoneNumber='" + responsibilityPhoneNumber + '\'' +
                ", status=" + status +
                ", projectInformation='" + projectInformation + '\'' +
                '}';
    }
}

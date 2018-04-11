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

    public ApplicationFormStatusVo(ApplicationForm applicationForm) {
        this.responsibilityName = applicationForm.getResponsibilityName();
        this.projectName = applicationForm.getProjectName();
        this.college = applicationForm.getCollege();
        this.status = applicationForm.getStatus();
        this.errorMessage = applicationForm.getErrorMessage();
        this.responsibilityPhoneNumber = applicationForm.getResponsibilityPhoneNumber();
        this.projectInformation = applicationForm.getProjectInformation();
    }
}

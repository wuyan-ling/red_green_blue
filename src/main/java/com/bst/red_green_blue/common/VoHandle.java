package com.bst.red_green_blue.common;

import com.bst.red_green_blue.pojo.ApplicationForm;
import com.bst.red_green_blue.pojo.vo.ApplicationFormVo;

/**
 * @author XHJ
 * 2018/4/11 21:15
 */
public class VoHandle {
    /**
     * 将 ApplicationForm 封装为ApplicationFormVo
     * @param form
     * @return
     */
    static public ApplicationFormVo createApplicationFormFormApplicationFormVo(ApplicationForm form) {
        ApplicationFormVo applicationForm = new ApplicationFormVo(form.getProjectName(),form.getResponsibilityName(),form.getCollege(),
                form.getResponsibilityPhoneNumber(),form.getProjectInformation());
        return applicationForm;
    }
    static public ApplicationForm createApplicationFormVoToApplicationForm(ApplicationFormVo applicationFormVo,String id) {

        ApplicationForm applicationForm = new ApplicationForm();
        applicationForm.setId(id);
        applicationForm.setProjectName(applicationFormVo.getProjectName());
        applicationForm.setProjectInformation(applicationFormVo.getProjectInformation());
        applicationForm.setResponsibilityName(applicationFormVo.getResponsibilityName());
        applicationForm.setCollege(applicationFormVo.getCollege());
        applicationForm.setResponsibilityPhoneNumber(applicationFormVo.getResponsibilityPhoneNumber());

        return applicationForm;
    }
}

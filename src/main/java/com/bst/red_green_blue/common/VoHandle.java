package com.bst.red_green_blue.common;

import com.bst.red_green_blue.pojo.ApplicationForm;
import com.bst.red_green_blue.pojo.PublicFacility;
import com.bst.red_green_blue.pojo.WechatNews;
import com.bst.red_green_blue.pojo.vo.ApplicationFormStatusVo;
import com.bst.red_green_blue.pojo.vo.ApplicationFormVo;
import com.bst.red_green_blue.pojo.vo.PublicFacilityVo;
import com.bst.red_green_blue.pojo.vo.WechatNewsVo;

/**
 * @author XHJ
 * 2018/4/11 21:15
 */
public class VoHandle {
    /**
     * 将 ApplicationForm 封装为ApplicationFormVo
     *
     * @param form
     * @return
     */
    static public ApplicationFormVo useApplicationFormCreateToVo(ApplicationForm form) {
        ApplicationFormVo applicationForm = new ApplicationFormVo(form.getProjectName(), form.getResponsibilityName(), form.getCollege(),
                form.getResponsibilityPhoneNumber(), form.getProjectInformation());
        return applicationForm;
    }

    /**
     * 将ApplicatoinFormVo 封装为Application
     *
     * @param vo
     * @param id
     * @return
     */
    static public ApplicationForm useApplicationFormCreateToVo(ApplicationFormVo vo, String id) {

        ApplicationForm applicationForm = new ApplicationForm();
        applicationForm.setId(id);
        applicationForm.setProjectName(vo.getProjectName());
        applicationForm.setProjectInformation(vo.getProjectInformation());
        applicationForm.setResponsibilityName(vo.getResponsibilityName());
        applicationForm.setCollege(vo.getCollege());
        applicationForm.setResponsibilityPhoneNumber(vo.getResponsibilityPhoneNumber());

        return applicationForm;
    }

    /**
     * 将PublicFacilityVo 封装为 publicFacility
     *
     * @param vo
     * @return
     */
    static public PublicFacility useVoCreateToPublicFacility(PublicFacilityVo vo, String id, String teamId) {
        PublicFacility publicFacility = new PublicFacility();
        publicFacility.setId(id);
        publicFacility.setTeamId(teamId);
        publicFacility.setRequestAddress(vo.getRequestAddress());
        publicFacility.setPersonNumber(vo.getPersonNumber());
        publicFacility.setContactWay(vo.getContactWay());
        publicFacility.setRemark(vo.getRemark());
        publicFacility.setRequestUseTime(vo.getRequestUseTime());

        return publicFacility;
    }

    static public WechatNews useVoCreateToWechatNews(WechatNewsVo vo, String id, String teamId, Long time) {
        WechatNews news = new WechatNews();
        news.setId(id);
        news.setDescription(vo.getDescription());
        news.setPicture(vo.getPicture());
        news.setTeamId(teamId);
        news.setTime(time);
        news.setTitle(vo.getTitle());

        return news;
    }

    static public ApplicationFormStatusVo useApplicationFormCreateToStatusVo(ApplicationForm applicationForm) {
        ApplicationFormStatusVo vo = new ApplicationFormStatusVo();
        vo.setResponsibilityName(applicationForm.getResponsibilityName());
        vo.setProjectName(applicationForm.getProjectName());
        vo.setCollege(applicationForm.getCollege());
        vo.setStatus(applicationForm.getStatus());
        vo.setErrorMessage(applicationForm.getErrorMessage()) ;
        vo.setResponsibilityPhoneNumber(applicationForm.getResponsibilityPhoneNumber()) ;
        vo.setProjectInformation(applicationForm.getProjectInformation()) ;

        return vo;
    }
}

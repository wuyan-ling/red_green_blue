package com.bst.red_green_blue.common;

import com.bst.red_green_blue.pojo.ApplicationForm;
import com.bst.red_green_blue.pojo.PublicFacility;
import com.bst.red_green_blue.pojo.WechatNews;
import com.bst.red_green_blue.pojo.vo.*;

/**
 * @author 熊厚谨
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
                form.getResponsibilityPhoneNumber(), form.getStatus(), form.getProjectInformation());
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
    static public PublicFacility useVoCreateToPublicFacility(PublicFacilityVo vo, String id, String teamId, String phoneNumber) {
        PublicFacility publicFacility = new PublicFacility();
        publicFacility.setId(id);
        publicFacility.setTeamId(teamId);
        Integer address = null;
        if ("会议室".equals(vo.getRequestAddress())) {
            address = 0;
        } else if ("培训教室".equals(vo.getRequestAddress())) {
            address = 1;
        } else if ("路演中心".equals(vo.getRequestAddress())) {
            address = 2;
        }
        publicFacility.setRequestAddress(address);
        publicFacility.setPersonNumber(vo.getPersonNumber());
        publicFacility.setContactWay(vo.getContactWay());
        publicFacility.setRemark(vo.getRemark());
        publicFacility.setRequestUseTime(vo.getRequestUseTime());
        publicFacility.setUserId(phoneNumber);
        return publicFacility;
    }

    /**
     * 将publicFacility 转换为 publicFacilityManageVo
     *
     * @param publicFacility
     * @return
     */
    static public PublicFacilityManageVo usePublicFacilityCreateToVo(PublicFacility publicFacility) {
        PublicFacilityManageVo vo = new PublicFacilityManageVo();
        vo.setId(publicFacility.getId());
        String address = null;
        if (publicFacility.getRequestAddress() == 0) {
            address = "会议室";
        } else if (publicFacility.getRequestAddress() == 1) {
            address = "培训教室";
        } else if (publicFacility.getRequestAddress() == 2) {
            address = "路演中心";
        }
        vo.setRequestAddress(address);
        vo.setPersonNumber(publicFacility.getPersonNumber());
        vo.setRequestUseTime(publicFacility.getRequestUseTime());
        vo.setContactWay(publicFacility.getContactWay());
        vo.setRemark(publicFacility.getRemark());
        vo.setTeamId(publicFacility.getTeamId());
        vo.setStatus(publicFacility.getStatus());
        vo.setUserId(publicFacility.getUserId());

        return vo;
    }

    /**
     * WechatNewsVo 封装为 WechatNews
     *
     * @param vo
     * @param id
     * @param teamId
     * @param time
     * @return
     */
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

    /**
     * 将ApplicationForm 转换成 ApplicationFormStatusVo
     *
     * @param applicationForm
     * @return
     */
    static public ApplicationFormStatusVo useApplicationFormCreateToStatusVo(ApplicationForm applicationForm) {
        ApplicationFormStatusVo vo = new ApplicationFormStatusVo();
        vo.setResponsibilityName(applicationForm.getResponsibilityName());
        vo.setProjectName(applicationForm.getProjectName());
        vo.setCollege(applicationForm.getCollege());
        vo.setStatus(applicationForm.getStatus());
        vo.setErrorMessage(applicationForm.getErrorMessage());
        vo.setResponsibilityPhoneNumber(applicationForm.getResponsibilityPhoneNumber());
        vo.setProjectInformation(applicationForm.getProjectInformation());

        return vo;
    }


}

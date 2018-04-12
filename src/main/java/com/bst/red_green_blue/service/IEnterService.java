package com.bst.red_green_blue.service;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.ApplicationForm;
import com.bst.red_green_blue.pojo.PublicFacility;
import com.bst.red_green_blue.pojo.vo.ApplicationFormVo;
import com.bst.red_green_blue.pojo.vo.PublicFacilityVo;

import java.util.List;

/**
 * @author XHJ
 * 2018/4/10 21:24
 */
public interface IEnterService {
    /**
     * 入驻申请
     *
     * @param applicationFormVo
     * @return
     */
    ServerResponse<String> enterApplyFor(ApplicationFormVo applicationFormVo);

    /**
     * 申请的状态查询
     *
     * @param responsibilityName
     * @param responsibilityPhoneNumber
     * @return
     */
    ServerResponse<ApplicationFormVo> applicationStatusQuery(String responsibilityName, String responsibilityPhoneNumber);

    /**
     * 申请公示
     *
     * @return
     */
    ServerResponse<List<ApplicationFormVo>> applicationPublic();

    /**
     * 获取审核列表
     *
     * @return
     */
    ServerResponse<List<ApplicationForm>> checkApplicationFormList();

    /**
     * 获取待审核列表
     *
     * @return
     */
    ServerResponse<List<ApplicationForm>> checkPendingApplicationFormList();


}

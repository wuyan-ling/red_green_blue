package com.bst.red_green_blue.service;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.ApplicationForm;
import com.bst.red_green_blue.pojo.vo.ApplicationFormVo;

import java.util.List;

/**
 * @author XHJ
 * 2018/4/10 21:24
 */
public interface IEnterService {
    ServerResponse<String> enterApplyFor(ApplicationFormVo applicationFormVo);

    ServerResponse<ApplicationFormVo> applicationStatusQuery(String responsibilityName, String responsibilityPhoneNumber);

    ServerResponse<List<ApplicationFormVo>> applicationPublic();

    ServerResponse<List<ApplicationForm>> checkApplicationFormList();

    ServerResponse<List<ApplicationForm>> checkPendingApplicationFormList();
}

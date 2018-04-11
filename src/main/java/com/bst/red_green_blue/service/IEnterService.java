package com.bst.red_green_blue.service;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.handle.exception.CustomException;
import com.bst.red_green_blue.pojo.ApplicationForm;
import com.bst.red_green_blue.pojo.vo.ApplicationFormStatusVo;
import com.bst.red_green_blue.pojo.vo.ApplicationFormVo;

import java.util.List;

/**
 * @author XHJ
 * 2018/4/10 21:24
 */
public interface IEnterService {
    ServerResponse<String> enterApplyFor(ApplicationFormVo applicationFormVo);

    ServerResponse<ApplicationForm> applicationStatusQuery(String responsibilityName, String responsibilityPhoneNumber);

    ServerResponse<List<ApplicationFormVo>> applicationPublic();
}

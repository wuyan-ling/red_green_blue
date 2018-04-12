package com.bst.red_green_blue.service;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.PublicFacility;
import com.bst.red_green_blue.pojo.vo.PublicFacilityVo;

import java.util.List;

/**
 * @author XHJ
 * 2018/4/12 14:08
 */
public interface IFacilityService {

    /**
     * 公共设施使用申请
     *
     * @param vo
     * @param teamId
     * @return
     */
    ServerResponse<String> applicationPublicFacility(PublicFacilityVo vo, String teamId);
    /**
     * 获取已审核的公共设施申请
     *
     * @return
     */
    ServerResponse<List<PublicFacility>> checkPublicFacility();
    /**
     * 获取未审核的公共设施申请
     *
     * @return
     */
    ServerResponse<List<PublicFacility>> checkPendingPublicFacility();
}

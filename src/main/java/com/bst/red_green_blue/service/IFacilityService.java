package com.bst.red_green_blue.service;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.PublicFacility;
import com.bst.red_green_blue.pojo.vo.PublicFacilityManageVo;
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
    ServerResponse<String> applicationPublicFacility(PublicFacilityVo vo, String teamId, String phoneNumber);

    /**
     * 获取已审核的公共设施申请
     *
     * @return
     */
    ServerResponse<List<PublicFacilityManageVo>> checkPublicFacilityList();

    /**
     * 获取未审核的公共设施申请
     *
     * @return
     */
    ServerResponse<List<PublicFacilityManageVo>> checkPendingPublicFacility();

    /**
     * 管理员公共设施申请审核
     *
     * @param id
     * @param status
     * @return
     */
    ServerResponse<String> checkPublicFacility(String id, int status);

    /**
     * 获取我的申请列表
     *
     * @param phoneNumber
     * @return
     */
    ServerResponse<List> getPublicFacilityList(String phoneNumber);
}

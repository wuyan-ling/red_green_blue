package com.bst.red_green_blue.service.impl;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.common.VoHandle;
import com.bst.red_green_blue.dao.PublicFacilityMapper;
import com.bst.red_green_blue.pojo.PublicFacility;
import com.bst.red_green_blue.pojo.PublicFacilityExample;
import com.bst.red_green_blue.pojo.vo.PublicFacilityVo;
import com.bst.red_green_blue.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author XHJ
 * 2018/4/12 14:08
 */
@Service
public class FacilityServiceImpl implements IFacilityService{
    @Autowired
    private PublicFacilityMapper publicFacilityMapper;
    /**
     * 公共设施使用申请
     *
     * @param vo
     * @param teamId
     * @return
     */
    @Override
    public ServerResponse<String> applicationPublicFacility(PublicFacilityVo vo, String teamId) {
        String id = String.valueOf(UUID.randomUUID());
        PublicFacility publicFacility = VoHandle.useVoCreateToPublicFacility(vo, id, teamId);
        int status = publicFacilityMapper.insertSelective(publicFacility);
        if (status == 0) {
            return ServerResponse.createByErrorMessage("提交失败");
        }
        return ServerResponse.createBySuccessMessage("提交成功");

    }

    /**
     * 获取已审核的公共设施申请
     *
     * @return
     */
    @Override
    public ServerResponse<List<PublicFacility>> checkPublicFacility() {
        PublicFacilityExample example = new PublicFacilityExample();
        example.or().andStatusEqualTo(1);
        example.or().andStatusEqualTo(2);
        List<PublicFacility> publicFacilities = publicFacilityMapper.selectByExample(example);
        if (publicFacilities.size() == 0) {
            return ServerResponse.createBySuccessMessage("空");
        }
        return ServerResponse.createBySuccess(publicFacilities);
    }

    /**
     * 获取未审核的公共设施申请
     *
     * @return
     */
    @Override
    public ServerResponse<List<PublicFacility>> checkPendingPublicFacility() {
        PublicFacilityExample example = new PublicFacilityExample();
        example.createCriteria().andStatusEqualTo(1);
        List<PublicFacility> publicFacilities = publicFacilityMapper.selectByExample(example);
        if (publicFacilities.size() == 0) {
            return ServerResponse.createBySuccessMessage("空");
        }
        return ServerResponse.createBySuccess(publicFacilities);
    }

}

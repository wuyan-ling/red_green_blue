package com.bst.red_green_blue.service.impl;

import com.bst.red_green_blue.common.Constant;
import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.common.VoHandle;
import com.bst.red_green_blue.dao.PublicFacilityMapper;
import com.bst.red_green_blue.pojo.ApplicationForm;
import com.bst.red_green_blue.pojo.ApplicationFormExample;
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
     * 、、
     *
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
    public ServerResponse<List<PublicFacility>> checkPublicFacilityList() {
        PublicFacilityExample example = new PublicFacilityExample();
        example.or().andStatusEqualTo(Constant.Status.PASS);
        example.or().andStatusEqualTo(Constant.Status.NOT_PASS);
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
        example.createCriteria().andStatusEqualTo(Constant.Status.UNTREATED);
        List<PublicFacility> publicFacilities = publicFacilityMapper.selectByExample(example);
        if (publicFacilities.size() == 0) {
            return ServerResponse.createBySuccessMessage("空");
        }
        return ServerResponse.createBySuccess(publicFacilities);
    }
    /**
     * 管理员公共设施申请审核
     *
     * @param id
     * @param status
     * @return
     */
    @Override
    public ServerResponse<String> checkPublicFacility(String id, int status) {

        PublicFacilityExample example = new PublicFacilityExample();
        example.createCriteria().andIdEqualTo(id);
        List<PublicFacility> list = publicFacilityMapper.selectByExample(example);
        if (list.size() == 0) {
            return ServerResponse.createByErrorMessage("无此团队");
        } else if (status == Constant.Status.PASS || status == Constant.Status.NOT_PASS) {
            PublicFacility applicationForm = list.get(0);
            applicationForm.setStatus(status);
//            尝试使用example进行update
//            example.clear();
//            example.createCriteria().andIdEqualTo(applicationForm.getId());
//            int i = publicFacilityMapper.updateByExampleSelective(applicationForm, example);
            int i = publicFacilityMapper.updateByPrimaryKeySelective(applicationForm);
            if (i == 0) {
                return ServerResponse.createByErrorMessage("更改审核信息失败");
            }
            return ServerResponse.createBySuccessMessage("更改审核状态成功");
        }
        return ServerResponse.createByErrorMessage("修改状态参数错误");
    }
}

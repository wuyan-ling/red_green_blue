package com.bst.red_green_blue.service.impl;

import com.bst.red_green_blue.common.Constant;
import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.common.VoHandle;
import com.bst.red_green_blue.dao.PublicFacilityMapper;
import com.bst.red_green_blue.pojo.PublicFacility;
import com.bst.red_green_blue.pojo.PublicFacilityExample;
import com.bst.red_green_blue.pojo.vo.PublicFacilityManageVo;
import com.bst.red_green_blue.pojo.vo.PublicFacilityVo;
import com.bst.red_green_blue.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author 熊厚谨
 * 2018/4/12 14:08
 */
@Service
public class FacilityServiceImpl implements IFacilityService {
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
    public ServerResponse<String> applicationPublicFacility(PublicFacilityVo vo, String teamId, String phoneNumber) {
        String id = String.valueOf(UUID.randomUUID());
        //将Vo对象转化为完整的对象
        PublicFacility publicFacility = VoHandle.useVoCreateToPublicFacility(vo, id, teamId, phoneNumber);
        int status = publicFacilityMapper.insertSelective(publicFacility);
        if (status == 0) {
            return ServerResponse.createByErrorMessage("提交失败");
        }
        return ServerResponse.createBySuccess("提交成功");

    }

    /**
     * 获取已审核的公共设施申请
     *
     * @return
     */
    @Override
    public ServerResponse<List<PublicFacilityManageVo>> checkPublicFacilityList() {
        PublicFacilityExample example = new PublicFacilityExample();
        example.or().andStatusEqualTo(Constant.Status.PASS);
        example.or().andStatusEqualTo(Constant.Status.NOT_PASS);
        List<PublicFacility> publicFacilities = publicFacilityMapper.selectByExample(example);
        if (publicFacilities.size() == 0) {
            return ServerResponse.createBySuccessMessage("已审核的公共设施申请空");
        }
        List<PublicFacilityManageVo> vos = new ArrayList<>();
        for (PublicFacility publicFacility : publicFacilities) {
            vos.add(VoHandle.usePublicFacilityCreateToVo(publicFacility));
        }
        return ServerResponse.createBySuccess(vos);
    }

    /**
     * 获取未审核的公共设施申请
     *
     * @return
     */
    @Override
    public ServerResponse<List<PublicFacilityManageVo>> checkPendingPublicFacility() {
        PublicFacilityExample example = new PublicFacilityExample();
        example.createCriteria().andStatusEqualTo(Constant.Status.UNTREATED);
        List<PublicFacility> publicFacilities = publicFacilityMapper.selectByExample(example);
        if (publicFacilities.size() == 0) {
            return ServerResponse.createBySuccessMessage("未审核的公共设施申请为空");
        }
        List<PublicFacilityManageVo> vos = new ArrayList<>();
        for (PublicFacility publicFacility : publicFacilities) {
            vos.add(VoHandle.usePublicFacilityCreateToVo(publicFacility));
        }
        return ServerResponse.createBySuccess(vos);
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
        } else if (status == Constant.Status.PASS || status == Constant.Status.NOT_PASS) {//判断将要用来改变审核状态的参数是否正确
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

    /**
     * 获取我的申请列表
     *
     * @param phoneNumber
     * @return
     */
    @Override
    public ServerResponse<List> getPublicFacilityList(String phoneNumber) {
        PublicFacilityExample publicFacilityExample = new PublicFacilityExample();
        publicFacilityExample.createCriteria().andUserIdEqualTo(phoneNumber);
        List<PublicFacility> publicFacilities = publicFacilityMapper.selectByExample(publicFacilityExample);

        List<PublicFacilityManageVo> vos = new ArrayList<>();
        for (PublicFacility publicFacility : publicFacilities) {
            vos.add(VoHandle.usePublicFacilityCreateToVo(publicFacility));
        }
        return ServerResponse.createBySuccess(vos);

    }


}

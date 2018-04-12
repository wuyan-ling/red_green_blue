package com.bst.red_green_blue.service.impl;

import com.bst.red_green_blue.common.Constant;
import com.bst.red_green_blue.common.ResponseCode;
import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.common.VoHandle;
import com.bst.red_green_blue.dao.ApplicationFormMapper;
import com.bst.red_green_blue.dao.PublicFacilityMapper;
import com.bst.red_green_blue.pojo.ApplicationForm;
import com.bst.red_green_blue.pojo.ApplicationFormExample;
import com.bst.red_green_blue.pojo.PublicFacility;
import com.bst.red_green_blue.pojo.PublicFacilityExample;
import com.bst.red_green_blue.pojo.vo.ApplicationFormVo;
import com.bst.red_green_blue.pojo.vo.PublicFacilityVo;
import com.bst.red_green_blue.service.IEnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author XHJ
 * 2018/4/10 21:25
 */
@Service
public class EnterServiceImpl implements IEnterService {
    @Autowired
    private ApplicationFormMapper applicationFormMapper;
    @Autowired
    private PublicFacilityMapper publicFacilityMapper;

    /**
     * 入驻申请
     *
     * @param applicationFormVo
     * @return
     */
    @Override
    public ServerResponse<String> enterApplyFor(ApplicationFormVo applicationFormVo) {
        String id = String.valueOf(UUID.randomUUID());
        ApplicationForm applicationForm = VoHandle.useApplicationFormCreateToVo(applicationFormVo, id);
//        ApplicationForm applicationForm = new ApplicationForm(applicationFormVo, id);
        int status = 0;

        try {
            status = applicationFormMapper.insertSelective(applicationForm);
        } catch (Exception e) {
//            throw new CustomException(ResponseCode.SQL_EXCEPTION);
            return ServerResponse.createByErrorMessage(ResponseCode.SQL_EXCEPTION.getMessage());
        }

        if (status == 0) {
            return ServerResponse.createByErrorMessage("提交失败");
        }

        return ServerResponse.createBySuccessMessage("申请成功");

    }

    /**
     * 申请的状态查询
     *
     * @param responsibilityName
     * @param responsibilityPhoneNumber
     * @return
     */
    @Override
    public ServerResponse<ApplicationFormVo> applicationStatusQuery(String responsibilityName, String responsibilityPhoneNumber) {
        ApplicationFormExample example = new ApplicationFormExample();
        example.createCriteria().andResponsibilityNameEqualTo(responsibilityName).
                andResponsibilityPhoneNumberEqualTo(responsibilityPhoneNumber);

        List<ApplicationForm> applicationForms = applicationFormMapper.selectByExample(example);
        if (applicationForms.size() == 0) {
            return ServerResponse.createByErrorMessage("无此团队信息,查询失败");
        }
        ApplicationForm form = applicationForms.get(0);
        if (form.getErrorMessage() == null || form.getErrorMessage().isEmpty()) {
            form.setErrorMessage("");
        }
        return ServerResponse.createBySuccess(VoHandle.useApplicationFormCreateToVo(form));

    }

    /**
     * 申请公示
     * (有瑕疵)
     *
     * @return
     */
    @Override
    public ServerResponse<List<ApplicationFormVo>> applicationPublic() {
        ApplicationFormExample example = new ApplicationFormExample();
        example.createCriteria().andStatusEqualTo(Constant.Status.PASS);
        List<ApplicationForm> applicationForms = applicationFormMapper.selectByExample(example);
        if (applicationForms.size() == 0) {
            return ServerResponse.createBySuccessMessage("空");
        }
        List<ApplicationFormVo> formVos = new ArrayList<>();
        for (ApplicationForm form : applicationForms) {
            formVos.add(VoHandle.useApplicationFormCreateToVo(form));
        }
        return ServerResponse.createBySuccess(formVos);
    }

    /**
     * 获取审核列表
     *
     * @return
     */
    @Override
    public ServerResponse<List<ApplicationForm>> checkApplicationFormList() {
        ApplicationFormExample example = new ApplicationFormExample();
        example.or().andStatusEqualTo(Constant.Status.PASS);
        example.or().andStatusEqualTo(Constant.Status.NOT_PASS);
        List<ApplicationForm> applicationForms = applicationFormMapper.selectByExample(example);
        if (applicationForms.size() == 0) {
            return ServerResponse.createBySuccessMessage("空");
        }
        return ServerResponse.createBySuccess(applicationForms);
    }

    /**
     * 获取待审核列表
     *
     * @return
     */
    @Override
    public ServerResponse<List<ApplicationForm>> checkPendingApplicationFormList() {
        ApplicationFormExample example = new ApplicationFormExample();
        example.createCriteria().andStatusEqualTo(Constant.Status.UNTREATED);
        List<ApplicationForm> applicationForms = applicationFormMapper.selectByExample(example);
        if (applicationForms.size() == 0) {
            return ServerResponse.createBySuccessMessage("空");
        }
        return ServerResponse.createBySuccess(applicationForms);
    }

    /**
     * 管理员入驻申请审核
     *
     * @param id
     * @param status
     * @return
     */
    @Override
    public ServerResponse<String> checkApplication(String id, int status) {
        ApplicationFormExample example = new ApplicationFormExample();
        example.createCriteria().andIdEqualTo(id);
        List<ApplicationForm> list = applicationFormMapper.selectByExample(example);
        ApplicationForm applicationForm = list.get(0);
        if (list.size() == 0) {
            return ServerResponse.createByErrorMessage("无此团队");
        } else if (status == Constant.Status.PASS || status == Constant.Status.NOT_PASS) {
            applicationForm.setStatus(status);
            int i = applicationFormMapper.updateByPrimaryKeySelective(applicationForm);
            if (i == 0) {
                return ServerResponse.createByErrorMessage("更改审核信息失败");
            }
            return ServerResponse.createBySuccessMessage("更改审核状态成功 ");
        }
        return ServerResponse.createByErrorMessage("修改状态参数错误");
    }


}

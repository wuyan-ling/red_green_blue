package com.bst.red_green_blue.controller;

import com.bst.red_green_blue.common.Constant;
import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.ApplicationForm;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.pojo.vo.ApplicationFormStatusVo;
import com.bst.red_green_blue.pojo.vo.ApplicationFormVo;
import com.bst.red_green_blue.service.IEnterService;
import com.bst.red_green_blue.util.GsonUtil;
import com.sun.activation.registries.MailcapParseException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @author XHJ
 * 入驻
 * 2018/4/10 21:01
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/enter/")
public class EnterController {
    @Autowired
    private IEnterService iEnterService;

    @ApiOperation(value = "入驻申请")
    @PostMapping(value = "enterApplyFor")
    public ServerResponse<String> enterApplyFor(@Valid ApplicationFormVo applicationFormVo,
                                                BindingResult bindingResult) {
        return iEnterService.enterApplyFor(applicationFormVo);
    }


    @ApiOperation(value = "审核状态查询")
    @GetMapping(value = "applicationStatusQuery")
    public ServerResponse<ApplicationFormStatusVo> applicationStatusQuery(String responsibilityName, String responsibilityPhoneNumber) {
        if (responsibilityName == null || responsibilityName.isEmpty() ||
                responsibilityPhoneNumber == null || responsibilityPhoneNumber.isEmpty()) {
            return ServerResponse.createByErrorMessage("团队负责人姓名或联系电话不能为空");
        }
        System.out.println();
        return iEnterService.applicationStatusQuery(responsibilityName, responsibilityPhoneNumber);
    }

    @ApiOperation(value = "申请公示")
    @GetMapping(value = "applicationPublic")
    public ServerResponse<List<ApplicationFormStatusVo>> applicationPublic() {
        return iEnterService.applicationPublic();

    }

    @ApiOperation(value = "获取已审核列表")
    @GetMapping(value = "checkApplicationFormList")
    public ServerResponse<List<ApplicationForm>> checkApplicationFormList(String token) throws MailcapParseException {
        if (token == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        }
        User currentUser = GsonUtil.createUserUseToToken(token);
        if (currentUser.getMark() == 1) {
            return ServerResponse.createByErrorMessage("不是管理员，权限不足");
        }
        return iEnterService.checkApplicationFormList();
    }

    @ApiOperation(value = "获取待审核列表")
    @GetMapping(value = "checkPendingApplicationFormList")
    public ServerResponse<List<ApplicationForm>> checkPendingApplicationFormList(String token) throws MailcapParseException {
        if (token == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        }
        User currentUser = GsonUtil.createUserUseToToken(token);
        if (currentUser.getMark() == 1) {
            return ServerResponse.createByErrorMessage("不是管理员，权限不足");
        }
        return iEnterService.checkPendingApplicationFormList();
    }

    @ApiOperation(value = "管理员入驻申请审核")
    @PostMapping(value = "checkApplication")
    public ServerResponse<String> checkApplication(String token, String id, int status) throws MailcapParseException {
        if (token == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        }
        User currentUser = GsonUtil.createUserUseToToken(token);
        if (currentUser.getMark() == 1) {
            return ServerResponse.createByErrorMessage("不是管理员，权限不足");
        } else if (id == null || id.isEmpty()) {
            return ServerResponse.createByErrorMessage("团队信息错误");
        }
        return iEnterService.checkApplication(id, status);
    }
}

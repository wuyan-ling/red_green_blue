package com.bst.red_green_blue.controller;

import com.bst.red_green_blue.common.Constant;
import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.ApplicationForm;
import com.bst.red_green_blue.pojo.PublicFacility;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.pojo.vo.ApplicationFormVo;
import com.bst.red_green_blue.pojo.vo.PublicFacilityVo;
import com.bst.red_green_blue.service.IEnterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author XHJ
 * 入驻
 * 2018/4/10 21:01
 */
@RestController
@RequestMapping(value = "/enter/")
public class EnterController {
    @Autowired
    private IEnterService iEnterService;

    @ApiOperation(value = "入驻申请")
    @PostMapping(value = "enterApplyFor")
    public ServerResponse<String> enterApplyFor(@Valid ApplicationFormVo applicationFormVo,
                                                BindingResult bindingResult) throws Exception {
        return iEnterService.enterApplyFor(applicationFormVo);
    }

    @ApiOperation(value = "审核状态查询")
    @GetMapping(value = "applicationStatusQuery")
    public ServerResponse<ApplicationFormVo> applicationStatusQuery(String responsibilityName, String responsibilityPhoneNumber) {
        if (responsibilityName == null || responsibilityName.isEmpty() ||
                responsibilityPhoneNumber == null || responsibilityPhoneNumber.isEmpty()) {
            return ServerResponse.createByErrorMessage("团队负责人姓名或联系电话不能为空");
        }
        return iEnterService.applicationStatusQuery(responsibilityName, responsibilityPhoneNumber);
    }

    @ApiOperation(value = "申请公示")
    @GetMapping(value = "applicationPublic")
    public ServerResponse<List<ApplicationFormVo>> applicationPublic() {
        return iEnterService.applicationPublic();

    }

    @ApiOperation(value = "获取已审核列表")
    @GetMapping(value = "checkApplicationFormList")
    public ServerResponse<List<ApplicationForm>> checkApplicationFormList(HttpSession session) {
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        } else if (user.getMark() == 1) {
            return ServerResponse.createByErrorMessage("不是管理员，权限不足");
        }
        return iEnterService.checkApplicationFormList();
    }

    @ApiOperation(value = "获取待审核列表")
    @GetMapping(value = "checkPendingApplicationFormList")
    public ServerResponse<List<ApplicationForm>> checkPendingApplicationFormList(HttpSession session) {
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        } else if (user.getMark() == 1) {
            return ServerResponse.createByErrorMessage("不是管理员，权限不足");
        }
        return iEnterService.checkPendingApplicationFormList();
    }
    @ApiOperation(value = "管理员入驻申请审核")
    @PostMapping(value = "checkApplication")
    public ServerResponse<String> checkApplication(HttpSession session, String id , int status) {
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        } else if (user.getMark() == 1) {
            return ServerResponse.createByErrorMessage("不是管理员，权限不足");
        } else if (id == null || id.isEmpty()) {
            return ServerResponse.createByErrorMessage("团队信息错误");
        }
        return iEnterService.checkApplication(id,status);
    }
}

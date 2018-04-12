package com.bst.red_green_blue.controller;

import com.bst.red_green_blue.common.Constant;
import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.PublicFacility;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.pojo.vo.PublicFacilityVo;
import com.bst.red_green_blue.service.IEnterService;
import com.bst.red_green_blue.service.IFacilityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author XHJ
 * 2018/4/12 14:06
 */
@RestController
@RequestMapping("/Facility")
public class FacilityController  {
    @Autowired
    private IFacilityService iFacilityService;

    @ApiOperation(value = "申请公共设施使用")
    @GetMapping(value = "applicationPublicFacility")
    public ServerResponse<String> applicationPublicFacility(HttpSession session, @Valid PublicFacilityVo vo, BindingResult bindingResult) {
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        }
        String teamId = user.getTeamId();
        return iFacilityService.applicationPublicFacility(vo,teamId);
    }
    @ApiOperation(value = "获取已审核的公共设施申请列表")
    @GetMapping(value = "checkPublicFacility")
    public ServerResponse<List<PublicFacility>> checkPublicFacility(HttpSession session) {
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        } else if (user.getMark() == 1) {
            return ServerResponse.createByErrorMessage("不是管理员，权限不足");
        }
        return iFacilityService.checkPublicFacility();
    }
    @ApiOperation(value = "获取待审核的公共设施申请审核列表")
    @GetMapping(value = "checkPendingPublicFacility")
    public ServerResponse<List<PublicFacility>> checkPendingPublicFacility(HttpSession session) {
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        } else if (user.getMark() == 1) {
            return ServerResponse.createByErrorMessage("不是管理员，权限不足");
        }
        return iFacilityService.checkPendingPublicFacility();
    }
}

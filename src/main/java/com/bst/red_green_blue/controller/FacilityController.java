package com.bst.red_green_blue.controller;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.dao.UserMapper;
import com.bst.red_green_blue.handle.exception.CustomException;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.pojo.vo.PublicFacilityManageVo;
import com.bst.red_green_blue.pojo.vo.PublicFacilityVo;
import com.bst.red_green_blue.service.IFacilityService;
import com.bst.red_green_blue.util.GsonUtil;
import com.sun.activation.registries.MailcapParseException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author XHJ
 * 2018/4/12 14:06
 */
@CrossOrigin
@RestController
@RequestMapping("/Facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "申请公共设施使用")
    @PostMapping(value = "applicationPublicFacility")
    public ServerResponse<String> applicationPublicFacility(String token, @Valid PublicFacilityVo vo, BindingResult bindingResult) throws MailcapParseException {

        if (token == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        }
//        String phoneNumber = JwtUtil.parseJWT(token).getSubject();
//        User user = userMapper.selectByPrimaryKey(phoneNumber);
        User currentUser = GsonUtil.createUserUseToToken(token);
        if (currentUser == null) {
            return ServerResponse.createByErrorMessage("请重新登录");
        }
        String teamId = currentUser.getTeamId();
        String phoneNumber = currentUser.getPhoneNumber();
        return iFacilityService.applicationPublicFacility(vo, teamId, phoneNumber);
    }


    @ApiOperation(value = "获取已审核的公共设施申请列表")
    @GetMapping(value = "checkPublicFacilityList")
    public ServerResponse<List<PublicFacilityManageVo>> checkPublicFacilityList(String token) throws MailcapParseException {
        if (token == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        }

        User currentUser = GsonUtil.createUserUseToToken(token);
        if (currentUser.getMark() == 1) {
            return ServerResponse.createByErrorMessage("不是管理员，权限不足");
        }
        return iFacilityService.checkPublicFacilityList();
    }

    @ApiOperation(value = "获取待审核的公共设施申请审核列表")
    @GetMapping(value = "checkPendingPublicFacility")
    public ServerResponse<List<PublicFacilityManageVo>> checkPendingPublicFacility(String token) throws MailcapParseException {
        if (token == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        }
        User currentUser = GsonUtil.createUserUseToToken(token);
        if (currentUser.getMark() == 1) {
            return ServerResponse.createByErrorMessage("不是管理员，权限不足");
        }
        return iFacilityService.checkPendingPublicFacility();
    }

    @ApiOperation(value = "管理员公共设施申请审核")
    @PostMapping(value = "checkPublicFacility")
    public ServerResponse<String> checkPublicFacility(String token, String id, int status) throws MailcapParseException {
        if (token == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        }
        User currentUser = GsonUtil.createUserUseToToken(token);
        if (currentUser.getMark() == 1) {
            return ServerResponse.createByErrorMessage("不是管理员,权限不足");
        } else if (id == null || id.isEmpty()) {
            return ServerResponse.createByErrorMessage("团队信息错误");
        }
        return iFacilityService.checkPublicFacility(id, status);
    }

    @ApiOperation(value = "获取我的公共设施申请列表")
    @PostMapping(value = "getPublicFacilityList")
    public ServerResponse<List> getPublicFacilityList(String token) {
        if (token == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        }
//        todo
        try {
//            if ( GsonUtil.StatusCheckout(token)){
            User currentUser = GsonUtil.createUserUseToToken(token);
            return iFacilityService.getPublicFacilityList(currentUser.getPhoneNumber());
//            }else {
//                return ServerResponse.createByErrorMessage("token无效或已过期，请重新登录");
//            }
        } catch (Exception e) {
            return ServerResponse.createByErrorMessage("token无效或已过期，请重新登录");
        }
    }
}

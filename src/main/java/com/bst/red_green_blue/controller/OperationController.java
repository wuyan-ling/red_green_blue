package com.bst.red_green_blue.controller;

import com.bst.red_green_blue.common.Constant;
import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.OperationMessage;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.service.IOpreationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

/**
 * @author XHJ
 * 2018/4/12 16:37
 */
@RestController
@RequestMapping("/Operation/")
public class OperationController {
    @Autowired
    private IOpreationService iOpreationService;

    @ApiOperation("提交或更新运营信息统计")
    @PostMapping("operationDataStatistics")
    public ServerResponse<String> operationDataStatistics(OperationMessage operationMessage, HttpSession session) {
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        } else if (user.getMark() == 0) {
            return ServerResponse.createByErrorMessage("需要团队负责人提交");
        }
        return iOpreationService.operationDataStatistics(operationMessage);
    }
    @ApiOperation("查询团队运营信息")
    @GetMapping("checkOperationMessage")
    public ServerResponse<OperationMessage> checkOperationMessage(HttpSession session) {
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        }
        String teamId = user.getTeamId();
        return iOpreationService.checkOperationMessage(teamId);
    }
}

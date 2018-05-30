package com.bst.red_green_blue.controller;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.handle.exception.CustomException;
import com.bst.red_green_blue.pojo.OperationMessage;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.service.IOpreationService;
import com.bst.red_green_blue.util.GsonUtil;
import com.sun.activation.registries.MailcapParseException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author XHJ
 * 2018/4/12 16:37
 */
@CrossOrigin
@RestController
@RequestMapping("/Operation/")
public class OperationController {
    @Autowired
    private IOpreationService iOpreationService;

    @ApiOperation("提交或更新运营信息统计")
    @PostMapping("operationDataStatistics")
    public ServerResponse<String> operationDataStatistics(OperationMessage operationMessage, String token) throws MailcapParseException {
        if (token == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        }
        User currentUser = GsonUtil.createUserUseToToken(token);
        if (currentUser.getMark() == 0) {
            return ServerResponse.createByErrorMessage("需要团队负责人提交");
        }
        return iOpreationService.operationDataStatistics(operationMessage);
    }

    @ApiOperation("查询团队运营信息")
    @GetMapping("checkOperationMessage")
    public ServerResponse<OperationMessage> checkOperationMessage(String token) throws MailcapParseException {
        if (token == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        }
        User currentUser = GsonUtil.createUserUseToToken(token);
        String teamId = currentUser.getTeamId();
        return iOpreationService.checkOperationMessage(teamId);
    }
}

package com.bst.red_green_blue.controller;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.ApplicationForm;
import com.bst.red_green_blue.pojo.vo.ApplicationFormVo;
import com.bst.red_green_blue.service.IEnterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author XHJ
 * 入驻大杂烩
 * 2018/4/10 21:01
 */
@RestController
@RequestMapping(value = "/enter/")
public class EnterController {
    @Autowired
    private IEnterService ienterService;

    @ApiOperation(value = "入驻申请")
    @PostMapping(value = "enterApplyFor")
    public ServerResponse<String> enterApplyFor(@Valid ApplicationFormVo applicationFormVo,
                                                BindingResult bindingResult) throws Exception {
        return ienterService.enterApplyFor(applicationFormVo);
    }

    @ApiOperation(value = "审核状态查询")
    @GetMapping(value = "applicationStatusQuery")
    public ServerResponse<ApplicationForm> applicationStatusQuery(String responsibilityName, String responsibilityPhoneNumber) {
        if (responsibilityName == null || responsibilityName.isEmpty() ||
                responsibilityPhoneNumber == null || responsibilityPhoneNumber.isEmpty()) {
            return ServerResponse.createByErrorMessage("团队负责人姓名或联系电话不能为空");
        }
        return ienterService.applicationStatusQuery(responsibilityName,responsibilityPhoneNumber);
    }

    /**
     * 申请公示
     * @return
     */
    @ApiOperation(value = "申请公示")
    @GetMapping(value = "applicationPublic")
    public ServerResponse<List<ApplicationFormVo>> applicationPublic() {
        return ienterService.applicationPublic();

    }
}

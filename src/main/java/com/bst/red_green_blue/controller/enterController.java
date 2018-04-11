package com.bst.red_green_blue.controller;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.vo.ApplicationFormVo;
import com.bst.red_green_blue.service.IenterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author XHJ
 * 入驻大杂烩
 * 2018/4/10 21:01
 */
@RestController
@RequestMapping(value = "/enter/")
public class enterController {
    @Autowired
    private IenterService ienterService;

    @ApiOperation(value = "入驻申请")
    @PostMapping(value = "enter_apply_for")
    public ServerResponse<String> enterApplyFor(@Valid ApplicationFormVo applicationFormVo, BindingResult bindingResult) {
//        return ienterService.enterApplyFor(applicationFormVo);
        return null;
    }


}

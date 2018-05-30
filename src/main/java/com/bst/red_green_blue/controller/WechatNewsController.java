package com.bst.red_green_blue.controller;

import com.bst.red_green_blue.common.Constant;
import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.handle.exception.CustomException;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.pojo.WechatNews;
import com.bst.red_green_blue.pojo.vo.WechatNewsVo;
import com.bst.red_green_blue.service.IWechatNewsService;
import com.bst.red_green_blue.util.GsonUtil;
import com.sun.activation.registries.MailcapParseException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author XHJ
 * 2018/4/12 15:21
 */
@CrossOrigin
@RestController
@RequestMapping("/WechatNews/")
public class WechatNewsController {
    @Autowired
    private IWechatNewsService iWechatNewsService;

    @ApiOperation("新闻发布")
    @PostMapping("releaseNews")
    public ServerResponse<String> releaseNews(String token, @Valid WechatNewsVo vo, BindingResult bindingResult) throws MailcapParseException {
        if (token == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        }
        User currentUser = GsonUtil.createUserUseToToken(token);
        String teamId = currentUser.getTeamId();
        return iWechatNewsService.releaseNews(vo,teamId);
    }
    @ApiOperation("查看新闻 ")
    @GetMapping("SeeTheNews")
    public ServerResponse<List<WechatNews>> SeeTheNews( ) {
        return iWechatNewsService.SeeTheNews();

    }
}

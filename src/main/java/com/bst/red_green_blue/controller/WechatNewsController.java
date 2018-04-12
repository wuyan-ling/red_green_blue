package com.bst.red_green_blue.controller;

import com.bst.red_green_blue.common.Constant;
import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.pojo.vo.WechatNewsVo;
import com.bst.red_green_blue.service.IWechatNewsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author XHJ
 * 2018/4/12 15:21
 */
@RestController
@RequestMapping("/WechatNews/")
public class WechatNewsController {
    @Autowired
    private IWechatNewsService iWechatNewsService;

    @ApiOperation("新闻发布")
    @PostMapping("release")
    public ServerResponse<String> releaseNews(WechatNewsVo vo, HttpSession session) {
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("请先登录");
        }
        String teamId = user.getTeamId();
        return iWechatNewsService.releaseNews(vo,teamId);
    }
}

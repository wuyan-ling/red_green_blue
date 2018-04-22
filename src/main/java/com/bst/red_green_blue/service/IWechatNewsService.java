package com.bst.red_green_blue.service;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.WechatNews;
import com.bst.red_green_blue.pojo.vo.WechatNewsVo;

import java.util.List;

/**
 * @author XHJ
 * 2018/4/12 15:22
 */
public interface IWechatNewsService {
    /**
     * 新闻发布
     *
     * @param vo
     * @param teamId
     * @return
     */
    ServerResponse<String> releaseNews(WechatNewsVo vo, String teamId);

    /**
     * 查看新闻
     *
     * @return
     */
    ServerResponse<List<WechatNews>> SeeTheNews();
}

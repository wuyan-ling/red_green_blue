package com.bst.red_green_blue.service.impl;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.common.VoHandle;
import com.bst.red_green_blue.dao.WechatNewsMapper;
import com.bst.red_green_blue.pojo.WechatNews;
import com.bst.red_green_blue.pojo.WechatNewsExample;
import com.bst.red_green_blue.pojo.vo.WechatNewsVo;
import com.bst.red_green_blue.service.IWechatNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author 熊厚谨
 * 2018/4/12 15:23
 */
@Service
public class WechatNewsServiceImpl implements IWechatNewsService {
    @Autowired
    private WechatNewsMapper wechatNewsMapper;


    /**
     * 新闻发布
     *
     * @param vo
     * @param teamId
     * @return
     */
    @Override
    public ServerResponse<String> releaseNews(WechatNewsVo vo, String teamId) {
        String uuid = UUID.randomUUID().toString();
        long Millis = System.currentTimeMillis();
        System.out.println(Millis);
        WechatNews wechatNews = VoHandle.useVoCreateToWechatNews(vo, uuid, teamId, Millis);
        int insert = wechatNewsMapper.insert(wechatNews);
        if (insert == 0) {
            return ServerResponse.createByErrorMessage("发布失败");
        }
        return ServerResponse.createBySuccessMessage("发布成功");

    }

    /**
     * 查看新闻
     *
     * @return
     */
    @Override
    public ServerResponse<List<WechatNews>> SeeTheNews() {
        WechatNewsExample example = new WechatNewsExample();
        example.createCriteria().andIdNotEqualTo("");
        List<WechatNews> wechatNews = wechatNewsMapper.selectByExample(example);
        return ServerResponse.createBySuccess(wechatNews);
    }
}

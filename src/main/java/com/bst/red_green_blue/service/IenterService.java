package com.bst.red_green_blue.service;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.vo.ApplicationFormVo;

/**
 * @author XHJ
 * 2018/4/10 21:24
 */
public interface IenterService {
    ServerResponse<String> enterApplyFor(ApplicationFormVo applicationFormVo);
}

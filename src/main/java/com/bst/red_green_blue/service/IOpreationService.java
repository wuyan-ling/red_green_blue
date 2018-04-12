package com.bst.red_green_blue.service;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.pojo.OperationMessage;

/**
 * @author XHJ
 * 2018/4/12 16:40
 */
public interface IOpreationService {
    /**
     * 存储或更新团队运营数据
     *
     * @param operationMessage
     * @return
     */
    ServerResponse<String> operationDataStatistics(OperationMessage operationMessage);

    /**
     * 查询团队运营信息
     *
     * @param teamId
     * @return
     */
    ServerResponse<OperationMessage> checkOperationMessage(String teamId);
}

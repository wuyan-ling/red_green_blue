package com.bst.red_green_blue.service.impl;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.dao.OperationMessageMapper;
import com.bst.red_green_blue.pojo.OperationMessage;
import com.bst.red_green_blue.service.IOpreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 熊厚谨
 * 2018/4/12 16:40
 */
@Service
public class OperationServiceImpl implements IOpreationService {
    @Autowired
    OperationMessageMapper operationMessageMapper;

    /**
     * 存储或更新团队运营数据
     *
     * @param operationMessage
     * @return
     */
    @Override
    public ServerResponse<String> operationDataStatistics(OperationMessage operationMessage) {
        String id = operationMessage.getId();
        OperationMessage operationMessageToKey = operationMessageMapper.selectByPrimaryKey(id);
        //当团队运营信息为空的时候，因为是第一次储存所以进行插入操作
        if (operationMessageToKey == null) {
            int status = operationMessageMapper.insertSelective(operationMessage);
            if (status == 1) {
                return ServerResponse.createBySuccessMessage("提交团队运营数据成功");
            }
            return ServerResponse.createByErrorMessage("提交团队运营数据失败");
        } else {//当团队运营信息不为空，进行更新操作

            int status = operationMessageMapper.updateByPrimaryKeySelective(operationMessage);
            if (status == 1) {
                return ServerResponse.createBySuccessMessage("更新团队运营数据成功");
            }
            return ServerResponse.createByErrorMessage("更新团队运营数据失败");
        }
    }

    /**
     * 查询团队运营信息
     *
     * @param teamId
     * @return
     */
    @Override
    public ServerResponse<OperationMessage> checkOperationMessage(String teamId) {
        OperationMessage operationMessage = operationMessageMapper.selectByPrimaryKey(teamId);
        if (operationMessage == null) {
            return ServerResponse.createBySuccessMessage("团队运营信息为空");
        }
        return ServerResponse.createBySuccess(operationMessage);
    }
}

package com.bst.red_green_blue.service.impl;

import com.bst.red_green_blue.common.ServerResponse;
import com.bst.red_green_blue.dao.ApplicationFormMapper;
import com.bst.red_green_blue.pojo.ApplicationForm;
import com.bst.red_green_blue.pojo.ApplicationFormExample;
import com.bst.red_green_blue.pojo.vo.ApplicationFormVo;
import com.bst.red_green_blue.service.IenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.JdbcUpdateAffectedIncorrectNumberOfRowsException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.UUID;

/**
 * @author XHJ
 * 2018/4/10 21:25
 */
@Service
public class IenterServiceImpl implements IenterService{
    @Autowired
    private ApplicationFormMapper applicationFormMapper;

    /**
     * 入驻申请
     * @param applicationFormVo
     * @return
     */
    @Override
    public ServerResponse<String> enterApplyFor(ApplicationFormVo applicationFormVo)  {
        String id = String.valueOf(UUID.randomUUID());
        ApplicationForm applicationForm = new ApplicationForm(applicationFormVo,id);
        int status;

        try {
            status = applicationFormMapper.insertSelective(applicationForm);
        }catch (Exception e) {
            return ServerResponse.createBySuccessMessage("团队名称有重复");
        }

        if (status == 0) {
            return ServerResponse.createByErrorMessage("提交失败");
        }

        return ServerResponse.createBySuccessMessage("申请成功");

}
}

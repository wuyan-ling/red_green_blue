package com.bst.red_green_blue.handle.exception;

import com.bst.red_green_blue.common.ResponseCode;

/**
 * @author XHJ
 * 自定义异常类(简易的 未完成...)
 * 2018/4/10 23:53
 */
public class CustomException extends Exception{
    private String code;
    public CustomException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.code = responseCode.getCode();
    }

    public String getCode() {
        return code;
    }

}

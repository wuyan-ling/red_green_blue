package com.bst.red_green_blue.common;

/**
 * @author summer
 * @version 1.0.0
 */
public enum ResponseCode  {
    SUCCESS("0", "SUCCESS"),
    ERROR("1","ERROR"),

    NEED_LOGIN("10","NEED_LOGIN"),

    SQL_EXCEPTION("20","团队名已存在"),
    UNKNOWN_EXCEPTION("21", "UNKNOWN_EXCEPTION") ,
    TOKEN_EXCEPTION("22", "TOKEN_EXCEPTION") ;


    private  String code;
    private   String desc;
    private String message;



    public String getCode(){
        return this.code;
    }
    public String getDesc(){
        return this.desc;
    }
    /**
     * 错误码
     *
     * @return
     */
    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }


    /**
     * 错误信息
     *
     * @return
     */

    public String getMessage() {
        return this.message;
    }


    @Override
    public String toString() {
        return "[" + code + "]" + message;
    }

}

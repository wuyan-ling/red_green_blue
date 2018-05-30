package com.bst.red_green_blue.common;

/**
 * @author summer
 * @version 1.0.0
 */
public class Constant {
    public static final String CURRENT_USER = "currentUser";
    public interface Role {
        //普通用户
        int ROLE_CUSTOMER = 1;

        //管理员
        int ROLE_ADMIN = 0;
    }

    public interface Status {
        //未处理
        int UNTREATED = 0;
        //审核通过
        int PASS = 1;
        //审核未通过
        int NOT_PASS = 2;
    }

    public interface Consts {
        /**鉴权的key*/
        public static final String AUTH_KEY = "authorization";
        /**JWT 秘钥*/
        public static final String SECRET = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";
        /**jwt失效时间 4个小时*/
        public static final Long JWT_EXPIRE = 4 * 60 * 60 * 1000L;
        /**验证码code*/
        public static final String IMAGE_CODE = "imagecode";
        /***有效的状态*/
        public static final String STATUS_VALID = "1";
        /***失效的状态*/
        public static final String STATUS_NOT_VALID = "0";
    }

}

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

}

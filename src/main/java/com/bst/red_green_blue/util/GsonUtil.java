package com.bst.red_green_blue.util;

import com.bst.red_green_blue.common.Constant;
import com.bst.red_green_blue.pojo.User;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;

/**
 * Created by 熊厚谨 on 2018/4/22 21:22
 *
 * @author 熊厚谨
 */
public class GsonUtil {
    //提取token中的用户信息
    public static User createUserUseToToken(String token) {
        String subject = JwtUtil.parseJWT(token).getSubject();
        return new Gson().fromJson(subject, User.class);
    }
    //判断token的状态 失效返回true
    public static boolean StatusCheckout(String token) {
        Claims claims = JwtUtil.parseJWT(token);
        String status = claims.getId();
        return status.equals(Constant.Consts.STATUS_NOT_VALID);
    }
}

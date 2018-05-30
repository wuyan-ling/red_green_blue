package com.bst.red_green_blue.aop;

import com.bst.red_green_blue.common.ResponseCode;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.pojo.vo.Token;
import com.bst.red_green_blue.util.GsonUtil;
import com.bst.red_green_blue.util.JwtUtil;
import com.google.gson.Gson;
import com.sun.activation.registries.MailcapParseException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by 熊厚谨 on 2018/5/30 17:05
 *
 * @author 熊厚谨
 */
@Slf4j
@Aspect
@Component
public class TokenValidator {
    @Around("execution(* com.bst.red_green_blue.controller.*.*(..)) && args(..,token )")
    public Object doAround(ProceedingJoinPoint pjp, Token token) throws Throwable {
        Object retVal;
        //对token进行判断
        identityVerification(token);
        int role = authorityJudge(token);
        token.setRole(role);
        //一定要这一步，调用这个方法才会进行下一步
        retVal = pjp.proceed();
        return retVal;
    }


    /**
     * 对token进行校验，判断合法性
     * @param parameter
     * @throws MailcapParseException
     */
    private void identityVerification(Token parameter) throws MailcapParseException {
        String token = parameter.getToken();
        String phoneNumber = parameter.getPhoneNumber();
        System.out.println("测试");
        User user = null;
        try {
            user = GsonUtil.createUserUseToToken(token);
        } catch (MailcapParseException e) {
            throw new MailcapParseException(ResponseCode.TOKEN_EXCEPTION.getMessage());
        }
        if (!user.getPhoneNumber().equals(phoneNumber)) {
            throw new MailcapParseException(ResponseCode.TOKEN_EXCEPTION.getMessage());
        }
    }

    /**
     * 判断当前token的身份角色
     * @param token
     * @return
     */
    private int authorityJudge(Token token) {
        String subject = JwtUtil.parseJWT(token.getToken()).getSubject();
        return new Gson().fromJson(subject, User.class).getMark();
    }
}

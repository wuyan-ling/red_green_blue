package com.bst.red_green_blue.aop;

import com.bst.red_green_blue.common.ResponseCode;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.pojo.vo.Token;
import com.bst.red_green_blue.util.GsonUtil;
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
        authorityJudge(token.getToken(),token.getPhoneNumber());
        retVal = pjp.proceed();
        return retVal;
    }


    /**
     * 对token进行校验，判断合法性
     * @param token
     * @param phoneNumber
     * @throws MailcapParseException
     */
    private void authorityJudge(String token,String phoneNumber) throws MailcapParseException {
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
        //没有验证角色
    }
}

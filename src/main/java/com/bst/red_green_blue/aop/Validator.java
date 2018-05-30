package com.bst.red_green_blue.aop;


import com.bst.red_green_blue.common.ResponseCode;
import com.bst.red_green_blue.common.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * @author 熊厚谨
 * decription  Controller 参数验证
 * date 2017/9/11
 */
@Slf4j
@Aspect
@Component
public class Validator {

    @Around("execution(* com.bst.red_green_blue.controller.*.*(..)) && args(..,bindingResult)")
    public Object doAround(ProceedingJoinPoint pjp, BindingResult bindingResult) throws Throwable {
        Object retVal;
        if (bindingResult.hasErrors()) {
            retVal = doErrorHandle(bindingResult);
        } else {
            retVal = pjp.proceed();
        }
        return retVal;
    }

//    https://blog.csdn.net/thinkingt_t/article/details/68951703  SpringAOP中，获取被切面管理的方法的参数名称和参数的值
    /**
     * 处理错误信息
     * @param result 参数校验结果
     * @return
     */
    private Object doErrorHandle(BindingResult result)
    {
        List<FieldError>  err = result.getFieldErrors();
        FieldError fe;
        StringBuffer buffer = new StringBuffer();
        for(int i=0; i < err.size(); i++){
            fe = err.get(i);
            buffer.append(fe.getDefaultMessage() + " ,");
        }
      return   ServerResponse.createByErrorCodeMessage(Integer.valueOf(ResponseCode.ERROR.getCode()), buffer.substring(0,buffer.length()-1));
    }

}

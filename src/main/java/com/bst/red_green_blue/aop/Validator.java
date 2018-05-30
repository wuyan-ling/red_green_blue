package com.bst.red_green_blue.aop;


import com.bst.red_green_blue.common.ResponseCode;
import com.bst.red_green_blue.common.ServerResponse;
import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 熊厚谨
 * decription  Controller 参数验证
 * date 2017/9/11
 */
@Slf4j
@Aspect
@Component
public class Validator
{

    @Around("execution(* com.bst.red_green_blue.controller.*.*(..)) && args(..,bindingResult)")
    public Object doAround(ProceedingJoinPoint pjp, BindingResult bindingResult) throws Throwable {
        Object retVal;
        if (bindingResult.hasErrors()) {
            retVal = doErrorHandle(bindingResult);
        } else {
            String classType = pjp.getTarget().getClass().getName();
            Class<?> clazz = Class.forName(classType);
            String clazzName = clazz.getName();
            String methodName = pjp.getSignature().getName(); //获取方法名称
            Object[] args = pjp.getArgs();//参数
            //获取参数名称和值
            Map<String,Object > nameAndArgs = getFieldsName(this.getClass(), clazzName, methodName,args);
            System.out.println(nameAndArgs.toString());
            retVal = pjp.proceed();
        }
        return retVal;
    }

    private Map<String,Object> getFieldsName(Class cls, String clazzName, String methodName, Object[] args) throws NotFoundException {
        Map<String,Object > map=new HashMap<String,Object>();

        ClassPool pool = ClassPool.getDefault();
        //ClassClassPath classPath = new ClassClassPath(this.getClass());
        ClassClassPath classPath = new ClassClassPath(cls);
        pool.insertClassPath(classPath);

        CtClass cc = pool.get(clazzName);
        CtMethod cm = cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            // exception
        }
        // String[] paramNames = new String[cm.getParameterTypes().length];
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < cm.getParameterTypes().length; i++){
            map.put( attr.variableName(i + pos),args[i]);//paramNames即参数名
        }

        //Map<>
        return map;
    }
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

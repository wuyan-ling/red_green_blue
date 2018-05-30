package com.bst.red_green_blue.validator;

import com.bst.red_green_blue.pojo.vo.Token;
import com.bst.red_green_blue.pojo.vo.UserVo;
import com.bst.red_green_blue.service.IUserService;
import com.sun.activation.registries.MailcapParseException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by 熊厚谨 on 2018/5/29 21:29
 *
 * @author 熊厚谨
 */
//需要实现ConstraintValidator接口 泛型的第一个参数意思是校验哪个注解，
// 第二个意思是校验的参数的类型是什么类型的（因为注解作用在字段上所以意思是字段的类型）
public class MyConstraintValidated implements ConstraintValidator<TokenConstraint,Token> {
    @Autowired
    private IUserService iUserService;

    //初始化时会被调用的方法，可以进行一些初始化操作
    @Override
    public void initialize(TokenConstraint myConstraint) {
        System.out.println("my validator init");
    }
    //真正的校验逻辑 第一个参数是被校验的值，第二个参数是校验的上下文，包含注解中的值
    @Override
    public boolean isValid(Token value, ConstraintValidatorContext constraintValidatorContext) {

        if (value.getToken() == null) {
            try {
                throw new MailcapParseException("token为空");
            } catch (MailcapParseException e) {
                e.printStackTrace();
            }
        }


        //一般对被验证的参数做一些判断
        System.out.println(value);
        return true;
    }

}

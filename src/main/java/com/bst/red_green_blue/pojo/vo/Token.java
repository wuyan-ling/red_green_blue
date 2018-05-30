package com.bst.red_green_blue.pojo.vo;

import com.bst.red_green_blue.validator.TokenConstraint;
import lombok.Data;

/**
 * Created by 熊厚谨 on 2018/5/30 15:00
 *
 * @author 熊厚谨
 */
@Data
public class Token {

    private String token;

    private String phoneNumber;

    private Integer role;
}

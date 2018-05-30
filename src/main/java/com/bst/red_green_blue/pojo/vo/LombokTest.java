package com.bst.red_green_blue.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 熊厚谨 on 2018/5/22 15:03
 *          测试使用Lombok插件
 * @author 熊厚谨
 */
//提供类基本的getting/setting方法 和 equals、canEqual、hashCode、toString方法。
@Data
//生成无参和全参的构造器
@NoArgsConstructor
@AllArgsConstructor
public class LombokTest {

    public String name;
    public int age;
}

class Test {
    public static void main(String[] args) {
        LombokTest lombokTest = new LombokTest();
        System.out.println(lombokTest.toString());
        lombokTest.setName("xhj");
        lombokTest.setAge(20);
        System.out.println(lombokTest.toString());
        LombokTest lombokTest1 = new LombokTest("ceshi",20);
        System.out.println(lombokTest1);
    }
}

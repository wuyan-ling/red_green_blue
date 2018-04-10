package com.bst.red_green_blue.controller;

import com.bst.red_green_blue.util.MD5Util;

import static org.junit.Assert.*;

public class UserControllerTest {
    public static void main(String[] args) {
        String s = MD5Util.MD5EncodeUtf8("123456");
        System.out.println(s);

    }
}
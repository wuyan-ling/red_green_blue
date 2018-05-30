package com.bst.red_green_blue.util.QRcode;

/**
 * Created by 熊厚谨 on 2018/5/22 20:06
 *
 * @author 熊厚谨
 */
public class QRcodeTest {
    public static void main(String[] args) {
        QRcodePojo pojo = new QRcodePojo(300,300,"png","","h");
        QRcodeUtils.CreateQRcode(pojo);
    }
}

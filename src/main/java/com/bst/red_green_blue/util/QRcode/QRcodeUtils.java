package com.bst.red_green_blue.util.QRcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * 二维码生成工具类
 * https://blog.csdn.net/pptlxc666/article/details/79113936
 */
public class QRcodeUtils {

    /**
     * 生成二维码
     */
    public static void CreateQRcode(QRcodePojo qRcodePojo) {
        HashMap hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");//指定字符编码为“utf-8"
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);//指定二维码的纠错等级为中级
        hints.put(EncodeHintType.MARGIN, 2);//设置图片的边框

        /**
         * 生成二维码
         */
        try {
            BitMatrix bitMatrix=new MultiFormatWriter().encode(qRcodePojo.getContent(), BarcodeFormat.QR_CODE, qRcodePojo.getWidth(), qRcodePojo.getHeight(),hints);
            Path file = new File("src\\main\\java\\com\\bst\\red_green_blue\\util\\QRcode\\img\\"+qRcodePojo.getName()+".png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, qRcodePojo.getFormat(), file);

        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("已生成二维码");
    }

}
package com.bst.red_green_blue.util.QRcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 熊厚谨 on 2018/5/22 19:47
 *
 * @author 熊厚谨
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QRcodePojo {

    int width;
    int height;
    String format;
    String content;
    String name;
}

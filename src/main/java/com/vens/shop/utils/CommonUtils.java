package com.vens.shop.utils;

import java.io.UnsupportedEncodingException;

/**
 * @author LuZhiqing
 * @Description:
 * @date 2018/9/6
 */
public class CommonUtils {
    static public int getDataCenterByName(String name) {
        char[] strChar = name.toCharArray();
        int tempChar = 0;
        if (strChar.length > 4) {
            for (int i = 0; i < 5; i++) {
                tempChar = strChar[i] ^ tempChar;
            }
        } else {
            for (char c : strChar) {
                tempChar = c ^ tempChar;
            }
        }
        String binaryString = Integer.toBinaryString(tempChar);
        if (binaryString.length() < 5) {
            return Integer.parseInt(binaryString, 2);
        }
        binaryString=binaryString.substring(binaryString.length() - 5, binaryString.length());
        return Integer.parseInt(binaryString, 2);
    }

}

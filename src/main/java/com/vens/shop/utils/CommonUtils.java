package com.vens.shop.utils;


/**
 * @author LuZhiqing
 * @Description:
 * @date 2018/9/6
 */
public class CommonUtils {
    /**
     * 根据名字获取数据库中心
     *
     * @param name 各种名字
     * @return 数据库代号
     */
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
        binaryString = binaryString.substring(binaryString.length() - 5, binaryString.length());
        return Integer.parseInt(binaryString, 2);
    }

    /**
     * 不推荐使用该方法，由于依赖现有数据库数，当数据库扩展后，那扩展后name得到的db_id和扩展之前的name得到的db_id不同
     * 就存在同一个name锁定到了不同的数据库，但是我们需要的是同一个name获得的db_id永远是相同的。
     * @param name
     * @param dataNumber
     * @return
     */
    static public int getDataCenterByName(String name, int dataNumber) {
        int hash = name.hashCode();
        return hash % dataNumber;
    }

}

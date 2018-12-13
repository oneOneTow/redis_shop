package com.vens.shop.utils;


/**
 * @author LuZhiqing
 * @Description:
 * @date 2018/9/6
 */
public class CommonUtils {
    /**
     * �������ֻ�ȡ���ݿ�����
     *
     * @param name ��������
     * @return ���ݿ����
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
     * ���Ƽ�ʹ�ø÷��������������������ݿ����������ݿ���չ������չ��name�õ���db_id����չ֮ǰ��name�õ���db_id��ͬ
     * �ʹ���ͬһ��name�������˲�ͬ�����ݿ⣬����������Ҫ����ͬһ��name��õ�db_id��Զ����ͬ�ġ�
     * @param name
     * @param dataNumber
     * @return
     */
    static public int getDataCenterByName(String name, int dataNumber) {
        int hash = name.hashCode();
        return hash % dataNumber;
    }

}

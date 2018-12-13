package com.vens.shop.utils;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author LuZhiqing
 * @Description:
 * @date 2018/12/13
 */
public class CommonUtilsTest {
    @Test
    public void given_same_name_should_return_same_value(){
        String strOne="kjafas390034!`бо";
        assertEquals(CommonUtils.getDataCenterByName(strOne),CommonUtils.getDataCenterByName(strOne));
        String strTwo="sfjsngfvljs;sgfnasiwSf[asgsngfs; vnsosknsdkjgfhsgglsjsa";
        assertEquals(CommonUtils.getDataCenterByName(strTwo),CommonUtils.getDataCenterByName(strTwo));

    }
}

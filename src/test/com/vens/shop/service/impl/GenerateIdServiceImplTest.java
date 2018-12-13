package com.vens.shop.service.impl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author LuZhiqing
 * @Description:
 * @date 2018/12/13
 */
public class GenerateIdServiceImplTest {
    GenerateIdServiceImpl generateIdService;
    @Before
    public void testBefore(){
        generateIdService=new GenerateIdServiceImpl();
    }
    @Test
    public void given_same_name_should_get_same_id(){
       long userId1 = generateIdService.getUserId("luzhiqing");
       long userId2 = generateIdService.getUserId("luzhiqing");
       assertEquals(userId1,userId2);
    }
}

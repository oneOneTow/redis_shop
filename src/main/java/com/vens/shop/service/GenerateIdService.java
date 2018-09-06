package com.vens.shop.service;

/**
 * @author LuZhiqing
 * @Description:
 * @date 2018/9/6
 */
public interface GenerateIdService {
    /**
     * 根据用户名生成一个id
     * @param name
     * @return
     */
    long getUserId(String name);

    /**
     * 根据userId生成一个id
     * @param userId
     * @return
     */
    long getOrderId(long userId);

    /**
     * 根据orderId生成一个id
     * @param orderId
     * @return
     */
    long getOrderGoodsId(long orderId);

    /**
     * 根据userId生成一个id
     * @param userId
     * @return
     */
    long getConsignee(long userId);
    /**
     * 根据环境变量生成一个机械id
     * @return
     */
    int getMachineId();
}

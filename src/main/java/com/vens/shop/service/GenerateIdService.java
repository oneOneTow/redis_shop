package com.vens.shop.service;

/**
 * @author LuZhiqing
 * @Description:
 * @date 2018/9/6
 */
public interface GenerateIdService {
    /**
     * �����û�������һ��id
     * @param name
     * @return
     */
    long getUserId(String name);

    /**
     * ����userId����һ��id
     * @param userId
     * @return
     */
    long getOrderId(long userId);

    /**
     * ����orderId����һ��id
     * @param orderId
     * @return
     */
    long getOrderGoodsId(long orderId);

    /**
     * ����userId����һ��id
     * @param userId
     * @return
     */
    long getConsignee(long userId);
    /**
     * ���ݻ�����������һ����еid
     * @return
     */
    int getMachineId();
}

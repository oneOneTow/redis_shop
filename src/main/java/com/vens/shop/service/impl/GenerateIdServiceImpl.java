package com.vens.shop.service.impl;

import com.vens.shop.service.GenerateIdService;
import com.vens.shop.service.SnowflakeService;
import com.vens.shop.utils.CommonUtils;


/**
 * @author LuZhiqing
 * @Description:
 * @date 2018/9/6
 */
public class GenerateIdServiceImpl implements GenerateIdService {

    public long getUserId(String name) {
        return getIdByName(name);
    }

    public long getOrderId(long userId) {
        return getIdById(userId);
    }

    public long getOrderGoodsId(long orderId) {
        return getIdById(orderId);
    }

    public long getConsignee(long userId) {
        return getIdById(userId);
    }

    public int getMachineId() {
        //由于目前是单机所以为0，如果以后有分布式，会获取环境变量来设置id
        return 0;
    }
    private int getDataCenterId(long id){
        String idStr=Long.toBinaryString(id);
        String dataCenterIdStr=idStr.substring(41,46);
        int dataCenterId=Integer.parseInt(dataCenterIdStr,2);
        return dataCenterId;
    }
    private long getIdById(long id){
        int dataCenterId=getDataCenterId(id);
        int workerId=getMachineId();
        SnowflakeService snowflakeService=new SnowflakeService(workerId,dataCenterId);
        id=snowflakeService.nextId();
        return id;
    }
    private long getIdByName(String name){
        int dataCenterId=CommonUtils.getDataCenterByName(name);
        int workerId=getMachineId();
        SnowflakeService snowflakeService=new SnowflakeService(workerId,dataCenterId);
        long id=snowflakeService.nextId();
        return id;
    }
}

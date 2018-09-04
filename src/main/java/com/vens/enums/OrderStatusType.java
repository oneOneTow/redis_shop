package com.vens.enums;

public enum OrderStatusType {
    unpaid(0,"未付款"),
    paid(1,"付款"),
    delivered(2,"已发货"),
    returnGoods(3,"退货");


    private int code;
    private String desc;
    OrderStatusType(int code,String desc){
        this.code=code;
        this.desc=desc;
    }
    public int getCode() {
        return this.code;
    }
    static public OrderStatusType getEnumFromCode(int code) {
        OrderStatusType[] types = OrderStatusType.values();
        for (OrderStatusType type : types) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return OrderStatusType.unpaid;
    }
}

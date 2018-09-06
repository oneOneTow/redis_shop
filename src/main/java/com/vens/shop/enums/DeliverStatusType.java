package com.vens.shop.enums;

public enum DeliverStatusType implements BaseEnum {
    NOT_DELIVER(0, "未发货"),
    DELIVERED(1, "已发货"),
    TAKE_OVER(2, "收货");
    private int code;
    private String desc;

    DeliverStatusType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    static public DeliverStatusType getEnumFromCode(int code) {
        DeliverStatusType[] types = DeliverStatusType.values();
        for (DeliverStatusType type : types) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return DeliverStatusType.NOT_DELIVER;
    }
}

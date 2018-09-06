package com.vens.shop.enums;

public enum InvoiceType implements BaseEnum{
    self(0,"个人"),
    company(1,"公司");
    private int code;
    private String desc;
    InvoiceType(int code,String desc){
        this.code=code;
        this.desc=desc;
    }
    public int getCode() {
        return this.code;
    }
    static public InvoiceType getEnumFromCode(int code) {
        InvoiceType[] types = InvoiceType.values();
        for (InvoiceType type : types) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return InvoiceType.self;
    }
}

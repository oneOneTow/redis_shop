package com.vens.enums;

public enum GenderType implements BaseEnum{
    MAN(0,"男"),
    WOMAN(1,"女");
    private int code;
    private String desc;
    GenderType(int code, String desc) {
        this.code=code;
        this.desc=desc;
    }

    public int getCode() {
        return this.code;
    }

    static public GenderType getEnumFromCode(int code) {
        GenderType[] types = GenderType.values();
        for (GenderType type : types) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return GenderType.MAN;
    }
}

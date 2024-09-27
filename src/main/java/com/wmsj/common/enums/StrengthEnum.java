package com.wmsj.common.enums;

public enum StrengthEnum {
    //OP
    OP("0","OP"),
    //LEVEL1
    LEVEL_1("1","LEVEL1"),
    //LEVEL2
    LEVEL_2("2","LEVEL2"),
    //LEVEL3
    LEVEL_3("3","LEVEL_3"),
    //LEVEL4
    LEVEL_4("4","LEVEL_4")
    ;

    private String value;
    private String desc;

    StrengthEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }
    public String getDesc() {
        return desc;
    }
}

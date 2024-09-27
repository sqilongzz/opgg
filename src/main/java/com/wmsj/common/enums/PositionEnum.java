package com.wmsj.common.enums;

public enum PositionEnum {
    //上路
    UP("1","上路"),
    //打野
    JUG("2","打野"),
    //中单
    MIDDLE("3","中单"),
    //射手
    ADC("4","射手"),
    //辅助
    SUPPORT("5","辅助")
    ;

    private String value;
    private String desc;

    PositionEnum(String value, String desc) {
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

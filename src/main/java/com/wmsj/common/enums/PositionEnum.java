package com.wmsj.common.enums;

public enum PositionEnum {
    //全部
    ALL("0","全部"),
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

    public static PositionEnum fromValue(String value) {
        for (PositionEnum position : PositionEnum.values()) {
            if (position.getValue().equals(value)) {
                return position;
            }
        }
        return null; // 或者抛出异常
    }
}

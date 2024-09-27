package com.wmsj.common.enums;

public enum RankEnum {
    //黑铁
    DARK_IRON_DIVISION("1","黑铁"),
    //青铜
    BRONZE_DIVISION("2","青铜"),
    //白银
    SILVER_DIVISION("3","白银"),
    //黄金
    GOLD_DIVISION("4","黄金"),
    //铂金
    PLATINUM_DIVISION("5","铂金"),
    //翡翠
    JADE_DIVISION("6","翡翠"),
    //砖石
    DIAMOND_DIVISION("7","砖石"),
    //大师
    MASTER_DIVISION("8","大师"),
    //宗师
    CLAN_MASTER_DIVISION("9","宗师"),
    //王者
    CHALLENGER_DIVISION("0","王者")
    ;

    private String value;
    private String desc;

    RankEnum(String value, String desc) {
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

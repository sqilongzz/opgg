package com.wmsj.entity;

import lombok.Data;

@Data
public class Equipment {
    private Long id;
    private String version;
    private String equipmentId;
    private String equipmentName;
    private String englishName;
    private String picUrl;
    private String equipmentIntroduction;
}

package com.wmsj.request;

import lombok.Data;

@Data
public class HeroRequest {
    private String id;
    private String version;
    private String heroId;
    private String heroName;
    private String englishName;
    private String chineseName;
    private String heroPosition;
    private String picUrl;
    private String heroPassiveSkills;
    private String heroSkillsQ;
    private String heroSkillsW;
    private String heroSkillsE;
    private String heroSkillsR;

    private Integer page;
    private Integer pageSize;
}

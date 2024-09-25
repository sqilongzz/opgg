package com.wmsj.entity;

import lombok.Data;

@Data
public class Hero {
    private Long id;
    private String version;
    private String heroId;
    private String heroName;
    private String englishName;
    private String picUrl;
    private String heroPassiveSkills;
    private String heroSkillsQ;
    private String heroSkillsW;
    private String heroSkillsE;
    private String heroSkillsR;

}

package com.wmsj.response;

import lombok.Data;

import java.util.Date;

@Data
public class HeroDetailResponse {
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
    private Date createTime;
    private Date updateTime;

    private String winRate;
    private String banRate;
    private String appearanceRate;
}

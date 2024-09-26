package com.wmsj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_hero")
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

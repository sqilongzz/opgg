package com.wmsj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_hero")
public class Hero {
    //定义 serialVersionUID 是一个良好的实践，可以帮助管理类的版本，避免因类结构变化而导致的序列化和反序列化问题。
    private static final long serialVersionUID = 1L;

    @TableId(type= IdType.AUTO)
    private String id;
    private String version;
    private String heroId;
    private String heroName;
    private String chineseName;
    private String englishName;
    private String heroPosition;
    private String picUrl;
    private String heroPassiveSkills;
    private String heroSkillsQ;
    private String heroSkillsW;
    private String heroSkillsE;
    private String heroSkillsR;
    private Date createTime;
    private Date updateTime;
}

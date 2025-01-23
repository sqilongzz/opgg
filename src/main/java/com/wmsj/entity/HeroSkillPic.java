package com.wmsj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_hero_skill_pic")
public class HeroSkillPic {
    //定义 serialVersionUID 是一个良好的实践，可以帮助管理类的版本，避免因类结构变化而导致的序列化和反序列化问题。
    private static final long serialVersionUID = 1L;

    @TableId(type= IdType.AUTO)
    private String id;
    private String heroId;
    private String passivePicUrl;
    private String qPicUrl;
    private String wPicUrl;
    private String ePicUrl;
    private String rPicUrl;
}

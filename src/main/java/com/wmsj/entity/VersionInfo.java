package com.wmsj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_version_info")
public class VersionInfo {
    //定义 serialVersionUID 是一个良好的实践，可以帮助管理类的版本，避免因类结构变化而导致的序列化和反序列化问题。
    private static final long serialVersionUID = 1L;

    @TableId(type= IdType.AUTO)
    private String id;
    private String version;
    private String heroId;
    private String equipmentId;
    private String rankLevel;
    private String strength;
    private String heroPosition;
    private String winRate;
    private String appearanceRate;
    private String banRate;
    private String advantageAgainst;
    private String inferiorityAgainst;
    private Date createTime;
    private Date updateTime;
//    "id":"",
//    "version":"",
//    "heroId":"",
//    "equipmentId":"",
//    "rankLevel":"",
//    "strength":"",
//    "heroPosition":"",
//    "winRate":"",
//    "appearanceRate":"",
//    "banRate":"",
//    "advantageAgainst":"",
//    "inferiorityAgainst":"",
}

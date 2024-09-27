package com.wmsj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_version_info")
public class VersionInfo {
    private Long id;
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

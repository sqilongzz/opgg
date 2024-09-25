package com.wmsj.entity;

import lombok.Data;

@Data
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
}

package com.wmsj.request;

import lombok.Data;

@Data
public class VersionInfoRequest {
    private String version;
    private String position;
    private String rankLevel;
    private String heroId;
    private String equipmentId;
    private String strength;
    private String heroPosition;
    private String winRate;
    private String appearanceRate;
    private String banRate;
    private String advantageAgainst;
    private String inferiorityAgainst;

    private Integer page;
    private Integer pageSize;

}

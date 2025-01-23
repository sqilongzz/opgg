package com.wmsj.response;

import com.wmsj.entity.Hero;
import lombok.Data;

import java.util.List;

@Data
public class VersionInfoResponse {
    private String id;
    private String version;
    private String heroId;
    private String heroName;
    private String englishName;
    private String equipmentId;
    private String picUrl;
    private String rankLevel;
    private String strength;
    private String heroPosition;
    private String winRate;
    private String appearanceRate;
    private String banRate;
    private String advantageAgainst;
    private List<Hero> advantageAgainstList;
    private String inferiorityAgainst;
    private List<Hero> inferiorityAgainstList;
}

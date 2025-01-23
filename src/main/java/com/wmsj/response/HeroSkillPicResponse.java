package com.wmsj.response;

import lombok.Data;


@Data
public class HeroSkillPicResponse {
    private String id;
    private String heroId;
    private String passivePicUrl;
    private String qPicUrl;
    private String wPicUrl;
    private String ePicUrl;
    private String rPicUrl;
}

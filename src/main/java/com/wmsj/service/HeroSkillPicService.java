package com.wmsj.service;

import com.wmsj.common.service.BaseService;
import com.wmsj.entity.HeroSkillPic;
import com.wmsj.request.HeroSkillPicRequest;
import com.wmsj.response.HeroSkillPicResponse;


public interface HeroSkillPicService extends BaseService<HeroSkillPic> {

    HeroSkillPicResponse getHeroSkillPic(HeroSkillPicRequest request);
}

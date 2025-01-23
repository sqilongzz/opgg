package com.wmsj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wmsj.common.service.impl.BaseServiceImpl;
import com.wmsj.dao.HeroSkillPicDao;
import com.wmsj.entity.HeroSkillPic;
import com.wmsj.request.HeroSkillPicRequest;
import com.wmsj.response.HeroSkillPicResponse;
import com.wmsj.service.HeroSkillPicService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HeroSkillPicServiceImpl extends BaseServiceImpl<HeroSkillPicDao, HeroSkillPic> implements HeroSkillPicService {
    @Autowired
    private HeroSkillPicDao heroSkillPicDao;

    @Override
    public HeroSkillPicResponse getHeroSkillPic(HeroSkillPicRequest request) {
        QueryWrapper<HeroSkillPic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hero_id", request.getHeroId());
        HeroSkillPic heroSkillPic = heroSkillPicDao.selectOne(queryWrapper);
        HeroSkillPicResponse heroSkillPicResponse = new HeroSkillPicResponse();
        BeanUtils.copyProperties(heroSkillPic, heroSkillPicResponse);
        return heroSkillPicResponse;
    }
}

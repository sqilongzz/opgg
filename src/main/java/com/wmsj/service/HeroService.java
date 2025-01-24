package com.wmsj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wmsj.common.service.BaseService;
import com.wmsj.entity.Hero;
import com.wmsj.request.HeroRequest;
import com.wmsj.response.HeroDetailResponse;
import com.wmsj.response.HeroResponse;

import java.util.List;

public interface HeroService extends BaseService<Hero> {
    int insertHero(HeroRequest heroRequest) ;
    int deleteHero(String id) ;
    int deleteBatchHero(List<String> ids);
    int updateHero(HeroRequest heroRequest);
    Hero getHeroById(String id);
    List<HeroResponse> getHeroList(HeroRequest request);
    IPage<HeroResponse> getHeroListPage(HeroRequest request);
    List<String> getHeroIdList(HeroRequest request);
    Hero getHeroByHeroId(String heroId);
    HeroDetailResponse getHeroDetail(String heroId);

}

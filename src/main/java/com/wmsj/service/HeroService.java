package com.wmsj.service;

import com.wmsj.common.service.BaseService;
import com.wmsj.entity.Hero;
import com.wmsj.request.HeroRequest;

import java.util.List;

public interface HeroService extends BaseService<Hero> {
    //增
    int insertHero(Hero hero) ;
    //删
    int deleteHero(String id) ;
    //改
    int updateHero(Hero hero);
    //查
    Hero getHeroById(String id);
    //分页查询
    List<Hero> getHeroList(HeroRequest request);

}

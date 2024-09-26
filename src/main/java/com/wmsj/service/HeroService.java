package com.wmsj.service;

import com.wmsj.common.service.BaseService;
import com.wmsj.entity.Hero;

public interface HeroService extends BaseService<Hero> {
    //增
    public int insertHero(Hero hero) ;
    //删
    public int deleteHero(int id) ;
    //改
    public int updateHero(Hero hero);
    //查
    public Hero getHeroById(int id);
}

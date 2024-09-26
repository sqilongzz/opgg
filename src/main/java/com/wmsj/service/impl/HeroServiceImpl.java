package com.wmsj.service.impl;

import com.wmsj.common.service.impl.BaseServiceImpl;
import com.wmsj.dao.HeroDao;
import com.wmsj.entity.Hero;
import com.wmsj.service.HeroService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HeroServiceImpl extends BaseServiceImpl<HeroDao, Hero> implements HeroService {
    @Autowired
    private HeroDao heroDao;

    //增
    public int insertHero(Hero hero) {
        return heroDao.insert(hero);
    }
    //删
    public int deleteHero(int id) {
        return heroDao.deleteById(id);
    }
    //改
    public int updateHero(Hero hero) {
        return heroDao.updateById(hero);
    }
    //查
    public Hero getHeroById(int id){
        return heroDao.selectById(id);
    }
}

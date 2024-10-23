package com.wmsj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wmsj.common.service.impl.BaseServiceImpl;
import com.wmsj.dao.HeroDao;
import com.wmsj.entity.Hero;
import com.wmsj.request.HeroRequest;
import com.wmsj.service.HeroService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HeroServiceImpl extends BaseServiceImpl<HeroDao, Hero> implements HeroService {
    @Autowired
    private HeroDao heroDao;

    //增
    public int insertHero(Hero hero) {
        String id = "v-"+hero.getVersion()+"-"+hero.getEnglishName();
        hero.setHeroId(id);
        return heroDao.insert(hero);
    }
    //删
    public int deleteHero(String id) {
        return heroDao.deleteById(id);
    }
    //改
    public int updateHero(Hero hero) {
        return heroDao.updateById(hero);
    }
    //查
    public Hero getHeroById(String id){
        return heroDao.selectById(id);
    }
    //分页查询
    public List<Hero> getHeroList(HeroRequest request) {
        QueryWrapper<Hero> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Hero::getVersion,request.getVersion());
        return heroDao.selectList(queryWrapper);
    }

    @Override
    public Hero getHeroByHeroId(String heroId) {
        QueryWrapper<Hero> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Hero::getHeroId,heroId);
        return heroDao.selectOne(queryWrapper);
    }
}

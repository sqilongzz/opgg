package com.wmsj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wmsj.common.service.impl.BaseServiceImpl;
import com.wmsj.dao.HeroDao;
import com.wmsj.entity.Hero;
import com.wmsj.request.HeroRequest;
import com.wmsj.response.HeroResponse;
import com.wmsj.service.HeroService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HeroServiceImpl extends BaseServiceImpl<HeroDao, Hero> implements HeroService {
    @Autowired
    private HeroDao heroDao;

    public int insertHero(HeroRequest heroRequest) {
        Hero hero = new Hero();
        BeanUtils.copyProperties(heroRequest,hero);
        String id = "v-"+hero.getVersion()+"-"+hero.getEnglishName();
        hero.setCreateTime(new Date());
        hero.setUpdateTime(new Date());
        hero.setId(null);
        hero.setHeroId(id);
        return heroDao.insert(hero);
    }

    public int deleteHero(String id) {
        return heroDao.deleteById(id);
    }

    @Override
    public int deleteBatchHero(List<String> ids) {
        return heroDao.deleteBatchIds(ids);
    }

    public int updateHero(HeroRequest heroRequest) {
        Hero hero = new Hero();
        BeanUtils.copyProperties(heroRequest,hero);
        hero.setUpdateTime(new Date());
        return heroDao.updateById(hero);
    }

    public Hero getHeroById(String id){
        return heroDao.selectById(id);
    }

    public List<HeroResponse> getHeroList(HeroRequest request) {
        QueryWrapper<Hero> queryWrapper = new QueryWrapper<>();
        if(request.getVersion() != null) {
            queryWrapper.lambda().eq(Hero::getVersion,request.getVersion());
        }
        if(request.getHeroPosition() != null) {
            queryWrapper.lambda().eq(Hero::getHeroPosition,request.getHeroPosition());
        }
        if(request.getHeroName() != null || request.getChineseName() != null) {
            queryWrapper.lambda().and(wrapper -> {
                if(request.getHeroName() != null) {
                    wrapper.like(Hero::getHeroName, request.getHeroName());
                }
                if(request.getChineseName() != null) {
                    wrapper.or().like(Hero::getChineseName, request.getChineseName());
                }
            });
        }
        List<Hero> heroes = heroDao.selectList(queryWrapper);
        return heroes.stream().map(hero -> {
            HeroResponse heroResponse = new HeroResponse();
            BeanUtils.copyProperties(hero,heroResponse);
            return heroResponse;
        }).collect(Collectors.toList());
    }



    @Override
    public Hero getHeroByHeroId(String heroId) {
        QueryWrapper<Hero> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Hero::getHeroId,heroId);
        return heroDao.selectOne(queryWrapper);
    }

    @Override
    public HeroResponse getHeroDetail(String heroIdList) {
        QueryWrapper<Hero> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Hero::getHeroId,heroIdList);
        Hero hero = heroDao.selectOne(queryWrapper);
        HeroResponse heroResponse = new HeroResponse();
        BeanUtils.copyProperties(hero,heroResponse);
        return heroResponse;

    }

    @Override
    public IPage<HeroResponse> getHeroListPage(HeroRequest request) {
        QueryWrapper<Hero> queryWrapper = new QueryWrapper<>();
        if(request.getVersion() != null) {
            queryWrapper.lambda().eq(Hero::getVersion,request.getVersion());
        }
        if(request.getHeroPosition() != null) {
            queryWrapper.lambda().eq(Hero::getHeroPosition,request.getHeroPosition());
        }
        if(request.getHeroName() != null) {
            queryWrapper.lambda().like(Hero::getHeroName, request.getHeroName());
        }
        if(request.getChineseName() != null) {
            queryWrapper.lambda().like(Hero::getChineseName, request.getChineseName());
        }
        if(request.getEnglishName() != null) {
            queryWrapper.lambda().like(Hero::getEnglishName, request.getEnglishName());
        }
        IPage<Hero> page = new Page<>(request.getPage(),request.getPageSize());
        IPage<Hero> heroPage = heroDao.selectPage(page,queryWrapper);
        return heroPage.convert(hero -> {
            HeroResponse heroResponse = new HeroResponse();
            BeanUtils.copyProperties(hero,heroResponse);
            return heroResponse;
        });
    }

    @Override
    public List<String> getHeroIdList(HeroRequest request) {
        QueryWrapper<Hero> queryWrapper = new QueryWrapper<>();
        if(request.getVersion() != null) {
            queryWrapper.lambda().eq(Hero::getVersion, request.getVersion());
        }
        if(request.getHeroPosition() != null) {
            queryWrapper.lambda().eq(Hero::getHeroPosition, request.getHeroPosition());
        }
        // 只查询heroId字段
        queryWrapper.select("hero_id");
        // 执行查询并收集heroId
        return heroDao.selectList(queryWrapper)
                .stream()
                .map(Hero::getHeroId)
                .collect(Collectors.toList());
    }


}
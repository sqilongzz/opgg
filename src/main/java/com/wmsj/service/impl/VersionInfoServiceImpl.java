package com.wmsj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wmsj.common.enums.PositionEnum;
import com.wmsj.common.service.impl.BaseServiceImpl;
import com.wmsj.dao.VersionInfoDao;
import com.wmsj.entity.Hero;
import com.wmsj.entity.VersionInfo;
import com.wmsj.request.VersionInfoRequest;
import com.wmsj.response.VersionInfoResponse;
import com.wmsj.service.HeroService;
import com.wmsj.service.VersionInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VersionInfoServiceImpl extends BaseServiceImpl<VersionInfoDao, VersionInfo> implements VersionInfoService {
    @Autowired
    private VersionInfoDao versionInfoDao;
    @Autowired
    private HeroService heroService;

    //增
    public int insertVersionInfo(VersionInfo versionInfo) {
        return versionInfoDao.insert(versionInfo);
    }

    //删
    public int deleteVersionInfo(String id) {
        return versionInfoDao.deleteById(id);
    }

    //改
    public int updateVersionInfo(VersionInfo versionInfo) {
        return versionInfoDao.updateById(versionInfo);
    }

    //查
    public VersionInfo getVersionInfoById(String id) {
        return versionInfoDao.selectById(id);
    }

    //分页查询
    public List<VersionInfoResponse> getVersionInfoList(VersionInfoRequest request) {
        if (request.getVersion() == null) {
            throw new IllegalArgumentException("Version cannot be null");//或者return一个信息
        }
        QueryWrapper<VersionInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(VersionInfo::getVersion, request.getVersion());
        queryWrapper.lambda().eq(VersionInfo::getHeroPosition, request.getPosition());
        List<VersionInfo> versionInfos = versionInfoDao.selectList(queryWrapper);
        //根据heroId获取hero的信息
        return versionInfos.stream().map(e -> {
                    VersionInfoResponse versionInfoResponse = new VersionInfoResponse();
                    BeanUtils.copyProperties(e, versionInfoResponse);
                    Hero hero = heroService.getHeroByHeroId(e.getHeroId());
                    versionInfoResponse.setHeroName(hero.getHeroName());
                    versionInfoResponse.setEnglishName(hero.getEnglishName());
                    versionInfoResponse.setPicUrl(hero.getPicUrl());
                    versionInfoResponse.setHeroPosition(PositionEnum.fromValue(versionInfoResponse.getHeroPosition()).getDesc());
                    //优势对抗 todo 循环
                    Hero advantageAgainstHero = heroService.getHeroByHeroId(e.getAdvantageAgainst());
                    List<Hero> advantageList = new ArrayList<>();
                    advantageList.add(advantageAgainstHero);
                    versionInfoResponse.setAdvantageAgainstList(advantageList);
                    //劣势对抗 todo 循环
                    Hero inferiorityAgainstHero = heroService.getHeroByHeroId(e.getInferiorityAgainst());
                    List<Hero> inferiorityList = new ArrayList<>();
                    inferiorityList.add(inferiorityAgainstHero);
                    versionInfoResponse.setInferiorityAgainstList(inferiorityList);
                    return versionInfoResponse;
                }
        ).collect(Collectors.toList());
    }
}

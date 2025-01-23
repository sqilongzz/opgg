package com.wmsj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wmsj.common.enums.PositionEnum;
import com.wmsj.common.service.impl.BaseServiceImpl;
import com.wmsj.dao.VersionInfoDao;
import com.wmsj.entity.Hero;
import com.wmsj.entity.VersionInfo;
import com.wmsj.request.VersionInfoRequest;
import com.wmsj.response.HeroResponse;
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

    public int insertVersionInfo(VersionInfoRequest versionInfoRequest) {
        VersionInfo versionInfo = new VersionInfo();
        BeanUtils.copyProperties(versionInfoRequest, versionInfo);
        versionInfo.setId(null);
        return versionInfoDao.insert(versionInfo);
    }

    public int deleteVersionInfo(String id) {
        return versionInfoDao.deleteById(id);
    }

    @Override
    public int deleteBatchVersionInfo(List<String> ids) {
        return versionInfoDao.deleteBatchIds(ids);
    }

    public int updateVersionInfo(VersionInfo versionInfo) {
        return versionInfoDao.updateById(versionInfo);
    }

    public VersionInfo getVersionInfoById(String id) {
        return versionInfoDao.selectById(id);
    }

    //分页查询
    public List<VersionInfoResponse> getVersionInfoList(VersionInfoRequest request) {
        if (request.getVersion() == null) {
            throw new IllegalArgumentException("Version cannot be null");
        }
        QueryWrapper<VersionInfo> queryWrapper = new QueryWrapper<>();
        if(request.getPosition() != null && !request.getPosition().isEmpty() && !"0".equals(request.getPosition())){
            queryWrapper.lambda().eq(VersionInfo::getHeroPosition, request.getPosition());
        }
        if(request.getRankLevel() != null){
            queryWrapper.lambda().eq(VersionInfo::getRankLevel, request.getRankLevel());
        }
        queryWrapper.lambda().eq(VersionInfo::getVersion, request.getVersion());
        // 将 strength 字段（可能是字符串类型）转换为有符号整数类型
        queryWrapper.orderByAsc("CAST(strength AS SIGNED)");
        List<VersionInfo> versionInfos = versionInfoDao.selectList(queryWrapper);
        
        return versionInfos.stream().map(e -> {
                    VersionInfoResponse versionInfoResponse = new VersionInfoResponse();
                    BeanUtils.copyProperties(e, versionInfoResponse);
                    Hero hero = heroService.getHeroByHeroId(e.getHeroId());
                    versionInfoResponse.setHeroName(hero.getHeroName());
                    versionInfoResponse.setEnglishName(hero.getEnglishName());
                    versionInfoResponse.setPicUrl(hero.getPicUrl());
//                    if(e.getHeroPosition() != null) {
//                        versionInfoResponse.setHeroPosition(PositionEnum.fromValue(e.getHeroPosition()).getDesc());
//                    }
                    //优势对抗
                    String[] advantageAgainstItems = e.getAdvantageAgainst().split(",");
                    List<Hero> advantageList = new ArrayList<>();
                    for(String item: advantageAgainstItems){
                        Hero advantageAgainstHero = heroService.getHeroByHeroId(item);
                        advantageList.add(advantageAgainstHero);
                    }
                    versionInfoResponse.setAdvantageAgainstList(advantageList);
                    //劣势对抗
                    String[] inferiorityAgainstItems = e.getInferiorityAgainst().split(",");
                    List<Hero> inferiorityList = new ArrayList<>();
                    for(String item: inferiorityAgainstItems){
                        Hero inferiorityAgainstHero = heroService.getHeroByHeroId(item);
                        inferiorityList.add(inferiorityAgainstHero);
                    }
                    versionInfoResponse.setInferiorityAgainstList(inferiorityList);
                    return versionInfoResponse;
                }
        ).collect(Collectors.toList());
    }

    @Override
    public IPage<VersionInfoResponse> getVersionInfoListPage(VersionInfoRequest request) {
        QueryWrapper<VersionInfo> queryWrapper = new QueryWrapper<>();
        if(request.getVersion() != null) {
            queryWrapper.lambda().eq(VersionInfo::getVersion,request.getVersion());
        }
        IPage<VersionInfo> page = new Page<>(request.getPage(),request.getPageSize());
        IPage<VersionInfo> versionInfoPage = versionInfoDao.selectPage(page,queryWrapper);
        return versionInfoPage.convert(versionInfo -> {
            VersionInfoResponse versionInfoResponse = new VersionInfoResponse();
            BeanUtils.copyProperties(versionInfo,versionInfoResponse);
            Hero hero = heroService.getHeroByHeroId(versionInfo.getHeroId());
            versionInfoResponse.setHeroName(hero.getHeroName());
            versionInfoResponse.setEnglishName(hero.getEnglishName());
            versionInfoResponse.setPicUrl(hero.getPicUrl());
//                    if(e.getHeroPosition() != null) {
//                        versionInfoResponse.setHeroPosition(PositionEnum.fromValue(e.getHeroPosition()).getDesc());
//                    }
            //优势对抗
            String[] advantageAgainstItems = versionInfo.getAdvantageAgainst().split(",");
            List<Hero> advantageList = new ArrayList<>();
            for(String item: advantageAgainstItems){
                Hero advantageAgainstHero = heroService.getHeroByHeroId(item);
                advantageList.add(advantageAgainstHero);
            }
            versionInfoResponse.setAdvantageAgainstList(advantageList);
            //劣势对抗
            String[] inferiorityAgainstItems = versionInfo.getInferiorityAgainst().split(",");
            List<Hero> inferiorityList = new ArrayList<>();
            for(String item: inferiorityAgainstItems){
                Hero inferiorityAgainstHero = heroService.getHeroByHeroId(item);
                inferiorityList.add(inferiorityAgainstHero);
            }
            versionInfoResponse.setInferiorityAgainstList(inferiorityList);
            return versionInfoResponse;
        });
    }
}

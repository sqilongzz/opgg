package com.wmsj.service;

import com.wmsj.common.service.BaseService;
import com.wmsj.entity.VersionInfo;

import java.util.List;

public interface VersionInfoService extends BaseService<VersionInfo> {
    //增
    int insertVersionInfo(VersionInfo versionInfo) ;
    //删
    int deleteVersionInfo(String id) ;
    //改
    int updateVersionInfo(VersionInfo versionInfo);
    //查
    VersionInfo getVersionInfoById(String id);
    //分页查询
    List<VersionInfo> getVersionInfoList();

}

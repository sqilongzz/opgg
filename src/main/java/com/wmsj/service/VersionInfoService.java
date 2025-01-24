package com.wmsj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wmsj.common.service.BaseService;
import com.wmsj.entity.VersionInfo;
import com.wmsj.request.VersionInfoRequest;
import com.wmsj.response.VersionInfoResponse;

import java.util.List;

public interface VersionInfoService extends BaseService<VersionInfo> {
    int insertVersionInfo(VersionInfoRequest versionInfoRequest);
    int deleteVersionInfo(String id);
    int deleteBatchVersionInfo(List<String> ids);
    int updateVersionInfo(VersionInfo versionInfo);
    VersionInfo getVersionInfoById(String id);
    VersionInfo getVersionInfoByHeroId(String heroId);
    List<VersionInfoResponse> getVersionInfoList(VersionInfoRequest request);
    IPage<VersionInfoResponse> getVersionInfoListPage(VersionInfoRequest request);
}

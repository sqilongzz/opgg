package com.wmsj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wmsj.common.service.impl.BaseServiceImpl;
import com.wmsj.dao.VersionInfoDao;
import com.wmsj.entity.VersionInfo;
import com.wmsj.request.VersionInfoRequest;
import com.wmsj.service.VersionInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VersionInfoServiceImpl extends BaseServiceImpl<VersionInfoDao, VersionInfo> implements VersionInfoService {
    @Autowired
    private VersionInfoDao versionInfoDao;

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
    public VersionInfo getVersionInfoById(String id){
        return versionInfoDao.selectById(id);
    }
    //分页查询
    public List<VersionInfo> getVersionInfoList(VersionInfoRequest request) {
        QueryWrapper<VersionInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(VersionInfo::getVersion, request.getVersion());
        return versionInfoDao.selectList(queryWrapper);
    }
}

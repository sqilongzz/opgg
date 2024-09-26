package com.wmsj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wmsj.entity.VersionInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VersionInfoDao extends BaseMapper<VersionInfo> {
}

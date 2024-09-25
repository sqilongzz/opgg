package com.wmsj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wmsj.entity.Hero;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HeroDao extends BaseMapper<Hero> {
}

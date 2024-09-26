package com.wmsj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wmsj.entity.Equipment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EquipmentDao extends BaseMapper<Equipment> {
}

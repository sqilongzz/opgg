package com.wmsj.service;

import com.wmsj.common.service.BaseService;
import com.wmsj.entity.Equipment;

import java.util.List;

public interface EquipmentService extends BaseService<Equipment> {
    //增
    int insertEquipment(Equipment equipment) ;
    //删
    int deleteEquipment(String id) ;
    //改
    int updateEquipment(Equipment equipment);
    //查
    Equipment getEquipmentById(String id);
    //分页查询
    List<Equipment> getEquipmentList();

}

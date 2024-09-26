package com.wmsj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wmsj.common.service.impl.BaseServiceImpl;
import com.wmsj.dao.EquipmentDao;
import com.wmsj.entity.Equipment;
import com.wmsj.service.EquipmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipmentServiceImpl extends BaseServiceImpl<EquipmentDao, Equipment> implements EquipmentService {
    @Autowired
    private EquipmentDao equipmentDao;

    //增
    public int insertEquipment(Equipment equipment) {
        return equipmentDao.insert(equipment);
    }
    //删
    public int deleteEquipment(String id) {
        return equipmentDao.deleteById(id);
    }
    //改
    public int updateEquipment(Equipment equipment) {
        return equipmentDao.updateById(equipment);
    }
    //查
    public Equipment getEquipmentById(String id){
        return equipmentDao.selectById(id);
    }
    //分页查询
    public List<Equipment> getEquipmentList() {
        QueryWrapper<Equipment> queryWrapper = new QueryWrapper<>();
        return equipmentDao.selectList(queryWrapper);
    }
}

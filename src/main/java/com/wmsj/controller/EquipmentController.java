package com.wmsj.controller;

import com.wmsj.entity.Equipment;
import com.wmsj.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/insertEquipment")
    public String insertEquipment(@RequestBody Equipment equipment) {
        int i = equipmentService.insertEquipment(equipment);
        if (i > 0) {
            return "success";
        }
        //todo log.info
        //todo id生成规则
        //todo request->entity
        return "fail";
    }
    @DeleteMapping("/deleteEquipment")
    public String deleteEquipment(@RequestParam("id") String id) {
        int i = equipmentService.deleteEquipment(id);
        if (i > 0) {
            return "success";
        }
        return "fail";
    }
    @PostMapping("/updateEquipment")
    public String updateEquipment(@RequestBody Equipment equipment) {
        //通过版本和英雄名称修改英雄信息
        int i = equipmentService.updateEquipment(equipment);
        if (i > 0) {
            return "success";
        }
        return "fail";
    }
    @GetMapping("/getEquipment")
    public Equipment getEquipment(@RequestParam("id") String id) {
        return equipmentService.getEquipmentById(id);

    }
    @GetMapping("/getEquipmentList")
    public List<Equipment> getEquipmentList() {
        return equipmentService.getEquipmentList();
    }
}

package com.wmsj.controller;

import com.wmsj.entity.Equipment;
import com.wmsj.request.EquipmentRequest;
import com.wmsj.service.EquipmentService;
import com.wmsj.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/add")
    public Result<String> insertEquipment(@RequestBody Equipment equipment) {
        return equipmentService.insertEquipment(equipment) > 0 ?
                Result.ok("success") : Result.ok("fail");
    }

    @DeleteMapping("/delete")
    public Result<String> deleteEquipment(@RequestParam("id") String id) {
        return equipmentService.deleteEquipment(id) > 0 ?
                Result.ok("success") : Result.ok("fail");
    }

    @PostMapping("/update")
    public Result<String> updateEquipment(@RequestBody Equipment equipment) {
        return equipmentService.updateEquipment(equipment) > 0 ?
                Result.ok("success") : Result.ok("fail");
    }

    @GetMapping("/get")
    public Result<Equipment> getEquipment(@RequestParam("id") String id) {
        return Result.ok(equipmentService.getEquipmentById(id));

    }

    @PostMapping("/getList")
    public Result<List<Equipment>> getEquipmentList(@RequestBody EquipmentRequest request) {
        return Result.ok(equipmentService.getEquipmentList(request));
    }
}

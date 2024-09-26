package com.wmsj.controller;

import com.wmsj.entity.VersionInfo;
import com.wmsj.service.VersionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VersionInfoController {
    @Autowired
    private VersionInfoService versionInfoService;

    @PostMapping("/insertVersionInfo")
    public String insertVersionInfo(@RequestBody VersionInfo versionInfo) {
        int i = versionInfoService.insertVersionInfo(versionInfo);
        if (i > 0) {
            return "success";
        }
        //todo log.info
        //todo id生成规则
        //todo request->entity
        return "fail";
    }
    @DeleteMapping("/deleteVersionInfo")
    public String deleteVersionInfo(@RequestParam("id") String id) {
        int i = versionInfoService.deleteVersionInfo(id);
        if (i > 0) {
            return "success";
        }
        return "fail";
    }
    @PostMapping("/updateVersionInfo")
    public String updateVersionInfo(@RequestBody VersionInfo versionInfo) {
        //通过版本和英雄名称修改英雄信息
        int i = versionInfoService.updateVersionInfo(versionInfo);
        if (i > 0) {
            return "success";
        }
        return "fail";
    }
    @GetMapping("/getVersionInfo")
    public VersionInfo getVersionInfo(@RequestParam("id") String id) {
        return versionInfoService.getVersionInfoById(id);

    }
    @GetMapping("/getVersionInfoList")
    public List<VersionInfo> getVersionInfoList() {
        return versionInfoService.getVersionInfoList();
    }
}

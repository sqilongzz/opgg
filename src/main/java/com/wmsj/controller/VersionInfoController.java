package com.wmsj.controller;

import com.wmsj.entity.VersionInfo;
import com.wmsj.request.VersionInfoRequest;
import com.wmsj.response.VersionInfoResponse;
import com.wmsj.service.VersionInfoService;
import com.wmsj.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/versionInfo")
public class VersionInfoController {
    @Autowired
    private VersionInfoService versionInfoService;

    @PostMapping("/add")
    public Result<String> insertVersionInfo(@RequestBody VersionInfo versionInfo) {
        return versionInfoService.insertVersionInfo(versionInfo) > 0 ? Result.ok("success") : Result.ok("fail");
    }

    @DeleteMapping("/delete")
    public Result<String> deleteVersionInfo(@RequestParam("id") String id) {
        return versionInfoService.deleteVersionInfo(id) > 0 ? Result.ok("success") : Result.ok("fail");
    }

    @PostMapping("/update")
    public Result<String> updateVersionInfo(@RequestBody VersionInfo versionInfo) {
        //通过版本和英雄名称修改英雄信息
        return versionInfoService.updateVersionInfo(versionInfo) > 0 ? Result.ok("success") : Result.ok("fail");
    }

    @GetMapping("/get")
    public Result<VersionInfo> getVersionInfo(@RequestParam("id") String id) {
        return Result.ok(versionInfoService.getVersionInfoById(id));
    }

    @PostMapping("/getList")
    public Result<List<VersionInfoResponse>> getVersionInfoList(@RequestBody VersionInfoRequest request) {
        return Result.ok(versionInfoService.getVersionInfoList(request));
    }
}

package com.wmsj.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wmsj.entity.Hero;
import com.wmsj.request.HeroRequest;
import com.wmsj.response.HeroDetailResponse;
import com.wmsj.response.HeroResponse;
import com.wmsj.service.HeroService;
import com.wmsj.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/hero")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @PostMapping("/add")
    public Result<String> insertHero(@RequestBody HeroRequest heroRequest) {
        return heroService.insertHero(heroRequest) > 0 ? Result.ok("success") : Result.ok("fail");
    }

    @DeleteMapping("/delete/{id}")
    public Result<String> deleteHero(@PathVariable("id") String id) {
        return heroService.deleteHero(id) > 0 ? Result.ok("success") : Result.ok("fail");
    }

    @DeleteMapping("/deleteBatch")
    public Result<String> deleteBatchHero(@RequestBody List<String> ids) {
        return heroService.deleteBatchHero(ids) > 0 ? Result.ok("success") : Result.ok("fail");
    }

    @PostMapping("/update")
    public Result<String> updateHero(@RequestBody HeroRequest heroRequest) {
        //通过版本和英雄名称修改英雄信息
        return heroService.updateHero(heroRequest) > 0 ? Result.ok("success") : Result.ok("fail");
    }

    @GetMapping("/get")
    public Result<Hero> getHero(@RequestParam("id") String id) {
        return Result.ok(heroService.getHeroById(id));
    }

    @GetMapping("detail/{heroId}")
    public Result<HeroDetailResponse> getHeroDetail(@PathVariable("heroId") String heroId) {
        return Result.ok(heroService.getHeroDetail(heroId));
    }

    /**
     * 根据版本获取英雄信息
     *
     * @return 英雄信息
     */
    @PostMapping("/getHeroList")
    public Result<List<HeroResponse>> getHeroList(@RequestBody HeroRequest request) {
        return Result.ok(heroService.getHeroList(request));
    }

    @PostMapping("/getListPage")
    public Result<IPage<HeroResponse>> getHeroListPage(@RequestBody HeroRequest request) {
        return Result.ok(heroService.getHeroListPage(request));
    }

    @PostMapping("/getHeroIdList")
    public Result<List<String>> getHeroIdList(@RequestBody HeroRequest request) {
        return Result.ok(heroService.getHeroIdList(request));
    }
}

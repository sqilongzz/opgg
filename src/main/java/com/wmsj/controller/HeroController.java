package com.wmsj.controller;

import com.wmsj.entity.Hero;
import com.wmsj.request.HeroRequest;
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
    public Result<String> insertHero(@RequestBody Hero hero) {
        return heroService.insertHero(hero) > 0 ? Result.ok("success") : Result.ok("fail");
    }

    @DeleteMapping("/delete")
    public Result<String> deleteHero(@RequestParam("id") String id) {
        return heroService.deleteHero(id) > 0 ? Result.ok("success") : Result.ok("fail");
    }

    @PostMapping("/update")
    public Result<String> updateHero(@RequestBody Hero hero) {
        //通过版本和英雄名称修改英雄信息
        return heroService.updateHero(hero) > 0 ? Result.ok("success") : Result.ok("fail");
    }

    @GetMapping("/get")
    public Result<Hero> getHero(@RequestParam("id") String id) {
        return Result.ok(heroService.getHeroById(id));
    }

    /**
     * 根据版本获取英雄信息
     *
     * @return 英雄信息
     */
    @PostMapping("/getList")
    public Result<List<Hero>> getHeroList(@RequestBody HeroRequest request) {
        return Result.ok(heroService.getHeroList(request));
    }
}

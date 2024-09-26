package com.wmsj.controller;

import com.wmsj.entity.Hero;
import com.wmsj.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HeroController {
    @Autowired
    private HeroService heroService;

    @PostMapping("/insertHero")
    public String insertHero(@RequestBody Hero hero) {
        int i = heroService.insertHero(hero);
        if (i > 0) {
            return "success";
        }
        //todo log.info
        //todo id生成规则
        return "fail";
    }
    @DeleteMapping("/deleteHero")
    public String deleteHero(@RequestParam("id") String id) {
        int i = heroService.deleteHero(id);
        if (i > 0) {
            return "success";
        }
        return "fail";
    }
    @PostMapping("/updateHero")
    public String updateHero(@RequestBody Hero hero) {
        //通过版本和英雄名称修改英雄信息
        int i = heroService.updateHero(hero);
        if (i > 0) {
            return "success";
        }
        return "fail";
    }
    @GetMapping("/getHero")
    public Hero getHero(@RequestParam("id") String id) {
        return heroService.getHeroById(id);

    }
    @GetMapping("/getHeroList")
    public List<Hero> getHeroList() {
        return heroService.getHeroList();
    }
}

package com.wmsj.controller;

import com.wmsj.entity.Hero;
import com.wmsj.request.HeroRequest;
import com.wmsj.service.HeroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class HeroController {
    @Autowired
    private HeroService heroService;

    @PostMapping("/insertHero")
    public String insertHero(@RequestBody Hero hero) {
        int i = heroService.insertHero(hero);
        log.info("==== i:[{}]",i);
        if (i > 0) {
            return "success";
        }
        //todo log.info
        //todo id生成规则 v-14.18-lee_sin
        //todo request->entity
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

    /**
     * 根据版本获取英雄信息
     * @return 英雄信息
     */
    @PostMapping("/getHeroList")
    public List<Hero> getHeroList(@RequestBody HeroRequest request) {
        return heroService.getHeroList(request);
    }
}

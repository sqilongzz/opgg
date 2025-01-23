package com.wmsj.controller;

import com.wmsj.request.HeroSkillPicRequest;
import com.wmsj.response.HeroSkillPicResponse;
import com.wmsj.service.HeroSkillPicService;
import com.wmsj.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/heroSkillPic")
public class HeroSkillPicController {
    @Autowired
    private HeroSkillPicService heroSkillPicService;

    @PostMapping("/get")
    public Result<HeroSkillPicResponse> getHeroSkillPic(@RequestBody HeroSkillPicRequest request) {
        return Result.ok(heroSkillPicService.getHeroSkillPic(request));

    }

}

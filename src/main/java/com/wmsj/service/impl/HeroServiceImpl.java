package com.wmsj.service.impl;

import com.wmsj.common.service.impl.BaseServiceImpl;
import com.wmsj.dao.HeroDao;
import com.wmsj.entity.Hero;
import com.wmsj.service.HeroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HeroServiceImpl extends BaseServiceImpl<HeroDao, Hero> implements HeroService {

}

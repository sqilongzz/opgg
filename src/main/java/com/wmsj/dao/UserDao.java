package com.wmsj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wmsj.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao extends BaseMapper<User> {

    User queryUserByUserName(@Param("userName") String userName);

    int queryCountByUserName(@Param("userName") String userName);
}

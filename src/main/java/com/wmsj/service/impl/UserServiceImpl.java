package com.wmsj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.wmsj.common.service.impl.BaseServiceImpl;
import com.wmsj.dao.UserDao;
import com.wmsj.entity.User;
import com.wmsj.exception.ServerException;
import com.wmsj.request.UserRequest;
import com.wmsj.response.LoginResponse;
import com.wmsj.response.UserResponse;
import com.wmsj.service.UserService;
import com.wmsj.util.JwtHelper;
import com.wmsj.util.MD5;
import com.wmsj.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, User> implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Result addUser(UserRequest userRequest) {
        // 检查用户名是否已存在
        if (userDao.queryCountByUserName(userRequest.getUserName()) > 0) {
            return Result.error("此用户已存在");
        }
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
//        user.setUserId(UUID.randomUUID().toString());
        user.setUserId(String.valueOf(new Random().nextInt(1000000)));//随机0~999999
        user.setPassword(MD5.encrypt(userRequest.getPassword()));
        if (userDao.insert(user) <= 0) {
            return Result.error("新增用户失败");
        }
        return Result.ok("新增用户成功");
    }

    @Override
    public Result<LoginResponse> login(String userName, String password) {
        LoginResponse loginResponse = new LoginResponse();
        User user = userDao.queryUserByUserName(userName);
        if (user == null) {
            return Result.error("未找到此用户");
        }
        if (!MD5.encrypt(password).equals(user.getPassword())) {
            return Result.error("密码错误");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUserName, userName);
        queryWrapper.lambda().eq(User::getPassword, user.getPassword());
        userDao.selectOne(queryWrapper);
        String token = JwtHelper.createToken(Long.valueOf(user.getUserId()), user.getUserType(), userName);
        log.info("token:{}", token);
        loginResponse.setToken(token);
        loginResponse.setNickname(user.getNickname());
        return Result.ok(loginResponse);
    }

    @Override
    public Result<UserResponse> getUserInfo(String token) {
        boolean expiration = JwtHelper.isExpiration(token);
        if (expiration) {
            return Result.error("token失效");
        }
        String userName = JwtHelper.getUserName(token);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUserName, userName);
        User user = userDao.selectOne(queryWrapper);
        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(user, response);
        return Result.ok(response);
    }

    @Override
    public Result updateUserInfo(String token, UserRequest userRequest) {
        boolean expiration = JwtHelper.isExpiration(token);
        if (expiration) {
            return Result.error("token失效");
        }
        String userName = JwtHelper.getUserName(token);
        User updateUser = new User();
        updateUser.setEmail(userRequest.getEmail());
        updateUser.setPhone(userRequest.getPhone());
        updateUser.setNickname(userRequest.getNickname());
        QueryWrapper<User> updateWrapper = new QueryWrapper<>();
        updateWrapper.lambda().eq(User::getUserName, userName);

        if (userDao.update(updateUser, updateWrapper) <= 0) {
            throw new ServerException("更新信息失败");
        }
        return Result.ok("更新用户信息成功");
    }

    @Override
    public Result updateUserPassword(String token, UserRequest userRequest) {
        boolean expiration = JwtHelper.isExpiration(token);
        if (expiration) {
            return Result.error("token失效");
        }
        //使用 throw：当遇到错误、异常情况或业务逻辑需要强制终止时，使用 throw 抛出异常。
        //使用 return：当方法成功执行完毕并需要返回一个结果时，使用 return。
        String userName = JwtHelper.getUserName(token);
        //查看旧密码是否正确
        User user = userDao.queryUserByUserName(userName);
        if (!MD5.encrypt(userRequest.getOldPassword()).equals(user.getPassword())) {
            return Result.error("原密码输入错误！");
//            throw new ServerException("原密码输入错误！"); //会报500的错误
        }
        User updateUser = new User();
        updateUser.setPassword(MD5.encrypt(userRequest.getNewPassword())); // 设置新密码

        QueryWrapper<User> updateWrapper = new QueryWrapper<>();
        updateWrapper.lambda().eq(User::getUserName, userName); // 根据当前用户名查找用户

        if (userDao.update(updateUser, updateWrapper) <= 0) {
            throw new ServerException("更新密码失败");
        }
        return Result.ok("更新密码成功");
    }

}

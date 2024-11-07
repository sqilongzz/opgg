package com.wmsj.service;


import com.wmsj.common.service.BaseService;
import com.wmsj.entity.User;
import com.wmsj.request.UserRequest;
import com.wmsj.response.LoginResponse;
import com.wmsj.response.UserResponse;
import com.wmsj.util.Result;

public interface UserService extends BaseService<User> {

    Result addUser(UserRequest userRequest);

    Result<LoginResponse> login(String userName, String password);

    Result<UserResponse> getUserInfo(String token);

    Result updateUserInfo(String token, UserRequest userRequest);

    Result updateUserPassword(String token, UserRequest userRequest);
}

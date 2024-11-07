package com.wmsj.controller;

import com.wmsj.request.UserRequest;
import com.wmsj.response.LoginResponse;
import com.wmsj.response.UserResponse;
import com.wmsj.service.UserService;
import com.wmsj.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Result addUser(@RequestBody UserRequest userRequest) {
        log.info("User created: {}", userRequest);
        return userService.addUser(userRequest);
    }

    @GetMapping("/login")
    public Result<LoginResponse> login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        log.info("User logged in");
        return userService.login(userName,password);
    }

    @GetMapping("/getUserInfo")
    public Result<UserResponse> getUserInfo(@RequestHeader("token") String token) {
        return userService.getUserInfo(token);
    }

    @PostMapping("updateUserInfo")
    public Result updateUserInfo(@RequestHeader("token") String token,
                                 @RequestBody UserRequest userRequest) {
        return Result.ok(userService.updateUserInfo(token,userRequest));
    }

    @PostMapping("updatePassword")
    public Result updateUserPassword(@RequestHeader("token") String token,
                                     @RequestBody UserRequest userRequest) {
        log.info("User updated: {}", userRequest);
        return Result.ok(userService.updateUserPassword(token,userRequest));
    }
}

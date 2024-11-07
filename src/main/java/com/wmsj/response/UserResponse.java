package com.wmsj.response;

import lombok.Data;

@Data
public class UserResponse {
    private String userId;
    private String userName;
    private String nickname;
    private Integer userType;
    private String password;
    private String phone;
    private String email;
}

package com.wmsj.request;

import lombok.Data;

@Data
public class UserRequest {
    private String userName;
    private String nickname;
    private Integer userType;
    private String password;
    private String phone;
    private String email;
    private String newPassword;
    private String oldPassword;
}

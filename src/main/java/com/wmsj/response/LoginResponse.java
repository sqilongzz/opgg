package com.wmsj.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String nickname;

}

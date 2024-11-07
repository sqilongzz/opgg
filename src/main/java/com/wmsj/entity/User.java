package com.wmsj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_user")
public class User {
    //定义 serialVersionUID 是一个良好的实践，可以帮助管理类的版本，避免因类结构变化而导致的序列化和反序列化问题。
    private static final long serialVersionUID = 1L;

    private String userId;
    private String nickname;
    private String userName;
    private Integer userType;
    private String password;
    private String phone;
    private String email;

}

package com.imook.entry;

import lombok.Data;

import java.util.Date;

@Data
public class PersonInfo {
//  用户信息类
//1.String Long
    private Long userId;
    private String name;
    // 用户头像地址
    private String profileImg;
    private String email;
    private String gender;
    //  用户
    private Integer enableStatus;
    //1.顾客 2. 店家 3. 超级管理员  约定
    // 用户身份标识 类别
    private Integer userType;
    private Date createTime;
    private Date lastEditTime;


}

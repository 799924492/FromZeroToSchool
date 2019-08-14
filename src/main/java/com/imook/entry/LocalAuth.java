package com.imook.entry;

import lombok.Data;

import java.util.Date;
// 本地账号
@Data
public class LocalAuth {
    private Long localAuthid;
    private String userName;
    private String passWord;
    private Date createTime;
    private PersonInfo personInfo;  //根据用户id绑定一起


}

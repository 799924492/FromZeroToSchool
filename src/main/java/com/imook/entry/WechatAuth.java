package com.imook.entry;

import lombok.Data;

import java.util.Date;
@Data
public class WechatAuth {

// 微信id
    private Long wechatAuthId;
    private String openid;// 微信账号和公众号绑定 唯一标识

    private Date createTime;
// 绑定 用户Id
    private PersonInfo personInfo;


}

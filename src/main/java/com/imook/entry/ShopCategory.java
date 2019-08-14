package com.imook.entry;

import lombok.Data;

import java.util.Date;

//店铺分类名称
@Data
public class ShopCategory {
    // 店铺id
    private Long ShopCategoryId;
    // 店铺名称
    private String ShopCategoryName;
    // 店铺描述
    private String ShopCategoryDesc;
    // 图片链接地址
    private String ShopCategoryImg;
     //权重
    private Long priority;
    //创建时间
    private Date createTime;
    //最新修改时间
    private Date lastEditTime;
    //上级id
    private ShopCategory parent;


}

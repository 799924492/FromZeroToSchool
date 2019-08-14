package com.imook.entry;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data//  商品信息
public class Product {
    private Long productId;
    private Long productName;
    private Long productDesc;
    //缩略图
    private String imgAddr;
    private String normalPrize;  //  正常价位
    private String promoionPrize; //  打折价位
    private String priority;
    private Date createTime;
   private Date lastEditTime;
   //1. 0 下架 1. 在前段z展示系统展示
    private Integer enableStatus;
    private List<ProductImg> productImgList;
    private ProductCatagory productCatagory;//1   对商品分类的一个集合
    private Shop  shop; //店铺
}

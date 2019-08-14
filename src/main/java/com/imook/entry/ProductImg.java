package com.imook.entry;

import lombok.Data;

import java.util.Date;
@Data
public class ProductImg {
    private Long ProductImgId;
    private Long ImgAddr;
    private Long ImgDesc;
    private Long priority;
    private Date createTime;
    private Long  productid;

}

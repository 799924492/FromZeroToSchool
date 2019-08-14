package com.imook.entry;

import lombok.Data;

import java.util.Date;
//头条
@Data
public class HeadLine {

    private Long lineId;
    private String lineName;
    private String lineLink;
    private String lineImg;
    private String priority;// 权重
    //0 代表不可用 1 可用
    private Integer enableStatus;
    private Date createTime;
    private Date lastEditTime;


}

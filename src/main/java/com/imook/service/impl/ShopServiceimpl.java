package com.imook.service.impl;

import com.imook.Enum.ShopStateEnum;
import com.imook.dao.ShopDao;
import com.imook.dto.ShopExecution;
import com.imook.entry.Shop;
import com.imook.exception.ShopOperationException;
import com.imook.service.ShopService;
import com.imook.untils.ImageUtil;
import com.imook.untils.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.awt.*;
import java.beans.Transient;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
@Service
public class ShopServiceimpl implements ShopService {
    @Autowired
 private ShopDao shopDao;



    @Transactional  // 事务的标签
    public ShopExecution addShop(Shop shop, InputStream shopImg,String fileName) {
      // 控制判断
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOPID);
        }

        //1.往店铺增加信息
        try {
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //  往数据库添加， 添加店铺信息
            int effectedNum = shopDao.insertShop(shop);
            if(effectedNum<1){
                throw new ShopOperationException("店铺创建失败");
            }else {
                if(shopImg !=null){
                    //存储图片//大体思路//值传递
                    try {
                        addShopImg(shop,shopImg,fileName);
                    } catch (Exception e) {
                        throw new ShopOperationException("addShopImg error"+e.getMessage());
                    }
                    //更新店铺的图片的地址
                    effectedNum=shopDao.updatetShop(shop);
                    if(effectedNum<=0){
                        throw new ShopOperationException("更新图片失败");
                    }

                }
            }
        } catch (ShopOperationException e) {
          throw new ShopOperationException("addShop error"+e.getMessage());
        }

        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    private void addShopImg(Shop shop, InputStream shopImg,String fileName) throws IOException {
        //  获取shop图片目录的相对值路径
        String dest= PathUtil.getShopImagePath(shop.getShopId());
     String shopImgAddr=  ImageUtil.generateThumbnail(shopImg,fileName,dest);

     shop.setShopImg(shopImgAddr);
    }
}

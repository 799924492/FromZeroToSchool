package com.imooc.myo2o.service;

import com.imooc.myo2o.BaseTest;
import com.imook.Enum.ShopStateEnum;
import com.imook.dto.ShopExecution;
import com.imook.entry.Area;
import com.imook.entry.PersonInfo;
import com.imook.entry.Shop;
import com.imook.entry.ShopCategory;
import com.imook.service.ShopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
   private ShopService shopService;
    @Test
    public void  testAddShop() throws FileNotFoundException {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(3);
        shopCategory.setShopCategoryId(2l);

        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺ss");
        shop.setShopDesc("test1");
        shop.setShopAddr("test1");
        shop.setPhone("test1");

        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");

        File shopimg=new File("D:/Program Files (x86)/HotFoxDownstair/xiaohuangren.jpg");
        InputStream is=new FileInputStream(shopimg);
        ShopExecution se = shopService.addShop(shop, is, shopimg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
    }
}

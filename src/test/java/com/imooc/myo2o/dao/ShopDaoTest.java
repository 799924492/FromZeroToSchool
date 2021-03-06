package com.imooc.myo2o.dao;


import com.imooc.myo2o.BaseTest;
import com.imook.dao.ShopDao;
import com.imook.entry.Area;
import com.imook.entry.PersonInfo;
import com.imook.entry.Shop;
import com.imook.entry.ShopCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BaseTest {

    @Autowired
  private   ShopDao shopDao;

    @Test
    @Ignore
    public void testInsertShop() {
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
        shop.setShopName("测试的店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectNum = shopDao.insertShop(shop);
       assertEquals(1,effectNum);
    }
    @Test

    public void testUpdateShop() {
        Shop shop = new Shop();
        shop.setShopId(1L);

        shop.setShopDesc("测试藐视");
        shop.setShopAddr("测试地址");
        shop.setLastEditTime(new Date());


        int effectNum = shopDao.updatetShop(shop);
        assertEquals(1,effectNum);
    }
}

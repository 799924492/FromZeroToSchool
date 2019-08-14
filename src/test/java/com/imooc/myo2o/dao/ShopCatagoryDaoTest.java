package com.imooc.myo2o.dao;


import com.imooc.myo2o.BaseTest;
import com.imook.dao.ShopCategoryDao;
import com.imook.dao.ShopDao;
import com.imook.entry.Area;
import com.imook.entry.PersonInfo;
import com.imook.entry.Shop;
import com.imook.entry.ShopCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopCatagoryDaoTest extends BaseTest {

    @Autowired
  private ShopCategoryDao shopCategoryDao;

    @Test

    public void shopCategoryDao() {


        List<ShopCategory> shopCategories = shopCategoryDao.queryShopCategory(new ShopCategory());
        assertEquals(2,shopCategories.size());
        ShopCategory testCategory = new ShopCategory();
        ShopCategory parentCategory = new ShopCategory();
        parentCategory.setShopCategoryId(2L);
        testCategory.setParent(parentCategory);
        shopCategories = shopCategoryDao.queryShopCategory(testCategory);
        assertEquals(1,shopCategories.size());
        System.out.println(shopCategories.get(0).getShopCategoryId());
    }


}

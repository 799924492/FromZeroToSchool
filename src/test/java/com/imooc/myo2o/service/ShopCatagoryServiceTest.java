package com.imooc.myo2o.service;


import com.imooc.myo2o.BaseTest;
import com.imook.dao.ShopCategoryDao;
import com.imook.entry.ShopCategory;
import com.imook.service.ShopCatagoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopCatagoryServiceTest extends BaseTest {

    @Autowired
  private ShopCatagoryService shopCatagoryService;

    @Test

    public void shopCategoryDao() {

        List<ShopCategory> shopCategory = shopCatagoryService.getShopCategory(new ShopCategory());
        assertEquals(0,shopCategory.size());

    }


}

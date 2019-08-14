package com.imook.service.impl;

import com.imook.dao.ShopCategoryDao;
import com.imook.entry.ShopCategory;
import com.imook.service.ShopCatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopCatagoryServiceimpl implements ShopCatagoryService {

   @Autowired
  private ShopCategoryDao shopCategoryDao;
    @Override
    public List<ShopCategory> getShopCategory(ShopCategory shopCategoryCondition) {


        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }
}

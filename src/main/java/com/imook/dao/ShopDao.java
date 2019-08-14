package com.imook.dao;

import com.imook.entry.Shop;

public interface ShopDao {
/*新增店铺s
* */
    int insertShop(Shop shop);
    /* 更新店铺信息*/
    int updatetShop(Shop shop);
}

package com.imook.service;

import com.imook.dto.ShopExecution;
import com.imook.entry.Shop;
import com.imook.entry.ShopCategory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

public interface ShopCatagoryService {
    List<ShopCategory> getShopCategory(ShopCategory shopCategoryCondition);
}

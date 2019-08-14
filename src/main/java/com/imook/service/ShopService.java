package com.imook.service;

import com.imook.dto.ShopExecution;
import com.imook.entry.Shop;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.InputStream;

public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImg,String fileName);
}

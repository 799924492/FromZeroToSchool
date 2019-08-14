package com.imook.untils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PathUtil {
    /* 不同的操作系统*/
    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String bathPath = "";
        if (os.toLowerCase().startsWith("win")) {
            bathPath = "E:/Image/";

        } else {
            bathPath = "AAA";
        }
        return bathPath;
    }
/*各自商铺的id*/
   public static String getShopImagePath(long Shopid){

       String path = "/upload/item/shop" + Shopid + "/";
        return path;
   }
}

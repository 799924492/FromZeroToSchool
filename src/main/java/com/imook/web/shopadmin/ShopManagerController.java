package com.imook.web.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imook.Enum.ShopStateEnum;
import com.imook.dto.ShopExecution;
import com.imook.entry.Area;
import com.imook.entry.PersonInfo;
import com.imook.entry.Shop;
import com.imook.entry.ShopCategory;
import com.imook.service.AreaService;
import com.imook.service.ShopCatagoryService;
import com.imook.service.ShopService;
import com.imook.untils.CodeUnitl;
import com.imook.untils.HttpServiletRequestUntils;
import com.imook.untils.ImageUtil;
import com.imook.untils.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

/* 店家管理的后台
 * 店铺管理相关的逻辑
 * */
@Controller
@RequestMapping("/shopadmin")

public class ShopManagerController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopCatagoryService shopCatagoryService;
    @Autowired
    private AreaService areaService;

    @ResponseBody
    @RequestMapping(value = "/getshopinitinfo", method = RequestMethod.GET) // 接收方式
    public Map<String, Object> getShopInitInfo() {
        Map<String, Object> modelmap = new HashMap<>();//1.定义一个modelmapp对象
        List<ShopCategory> shopCategories = new ArrayList<>();
        List<Area> areaList = new ArrayList<Area>();
        try {
            shopCategories = shopCatagoryService.getShopCategory(new ShopCategory());
            areaList = areaService.findList();
            modelmap.put("areaList", areaList);
            modelmap.put("shopCategories", shopCategories);
            modelmap.put("success", true);
        } catch (Exception e) {
            modelmap.put("success", false);
            modelmap.put("errmsg", e.getMessage());
        }

        return modelmap;
    }

    // Map<String ,Object>  返回一些必要的键值对结果
    @ResponseBody  // json格式的数据转换
    @RequestMapping(value = "/registershop", method = RequestMethod.POST) // 接收方式


    public Map<String, Object> registerShop(HttpServletRequest request) throws IOException {

        Map<String, Object> modelMap = new HashMap<>();

        if (!CodeUnitl.checkVerifyCode(request)) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "输入了错误的验证码");
            return modelMap;
        }
        // 接收并转换相应的参数 包括店铺信息以及图片信息
        // 获取前端传过来的店铺信息 并将它转换成实体类
        //同时获取前段传递过来的文件流就收到shopimg中
        String shopStr = HttpServiletRequestUntils.getString(request, "shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        try {
            // 转换成shop对象
            shop = mapper.readValue(shopStr, Shop.class);
        } catch (IOException e) {
            modelMap.put("success", false);
            modelMap.put("errmsg", e.getMessage());

            return modelMap;
        }
        // 文件上传
        CommonsMultipartFile shopImg = null;
        //文件上传解析器 去解析requeest里面的文件信息
        MultipartResolver MultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (MultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        } else {
            modelMap.put("success", false);
            modelMap.put("errmsg", "上传文件 不能为空");
            return modelMap;

        }
        //2. 注册店铺
        if (shop != null && shopImg != null) {
            PersonInfo owner = new PersonInfo();
            owner.setUserId(1L);
            shop.setOwner(owner);
//            File shopImgFile=new File(PathUtil.getImgBasePath()+ ImageUtil.getRandomFileName());


            ShopExecution se;
            try {
                se = shopService.addShop(shop, shopImg.getInputStream(), shopImg.getOriginalFilename());
                if (se.getState() == ShopStateEnum.CHECK.getState()) {
                    modelMap.put("success", true);
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg ", se.getStateInfo());

                }
            } catch (Exception e) {
                modelMap.put("success", false);
                modelMap.put("errMsg ", "请输入店铺信息");

            }
            return modelMap;
        } else {

            modelMap.put("success", false);
            modelMap.put("errMsg ", "请输入店铺信息");

            return modelMap;
        }
    }
}


//3. 返回结果




/* 文件复制粘贴
 * 1. 获得一个带有数据的io流 读
 * 然后再写到File中
 *
 * */
//private static void InputStreamtoFile(InputStream ins, File file){
//    FileOutputStream os=null;
//    try {
//        os = new FileOutputStream(file);
//        int len ;
//        byte[] bytes = new byte[1024];
//        while ((len=ins.read(bytes)) != -1){
//            os.write(bytes,0,len);
//        }
//    } catch (Exception e) {
//        throw new RuntimeException("调用inputStream产生异常"+e.getMessage());
//    } finally {
//        try {
//            if (os !=null) {
//                os.close();
//            }
//            if (ins !=null) {
//                ins.close();
//            }
//
//        } catch (Exception e) {
//            throw new RuntimeException("关闭io产生异常"+e.getMessage());
//        }
//    }
//
//}


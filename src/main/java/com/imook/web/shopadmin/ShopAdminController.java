package com.imook.web.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imook.entry.Shop;
import com.imook.untils.HttpServiletRequestUntils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * */
@Controller
@RequestMapping(value = "shopadmin", method = RequestMethod.GET)

public class ShopAdminController {
    @RequestMapping(value = "/shopoperator")
    public String ShopOperatoion() {

        return "shop/shopoperator";
    }


}

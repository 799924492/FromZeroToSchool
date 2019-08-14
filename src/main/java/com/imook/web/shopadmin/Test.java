package com.imook.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "testSpringmvc")
public class Test {
    @RequestMapping(value = "/testSpringmvc")
    public  String vos(HttpServletRequest request) {
        System.out.println("...........................................");
        System.out.println(request.getSession().getServletContext().getRealPath("/"));
        System.out.println("...........................................");
        return "shop/shopoperator";

    }
}

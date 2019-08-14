package com.imook.web.superadmin;

import com.imook.entry.Area;
import com.imook.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/superadmin")
@RestController
public class AreaController {
 Logger logger=   LoggerFactory.getLogger(AreaController.class);
 @Autowired
AreaService areaService;
    @RequestMapping(value = "/listArea",method = RequestMethod.GET)

    private Map<String ,Object> listArea(){
        logger.info("========Start==");
        long startTime = System.currentTimeMillis();
        HashMap<String, Object> modelMap = new HashMap<>();
        ArrayList<Area> Arealist = new ArrayList<>();
      //service  可能出现的异常
        try {
            List<Area> list = areaService.findList();
            modelMap.put("rows",list);
            modelMap.put("total",list.size());
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errMsg",e.toString());
        }
        logger.error("test error!");


        long endTime = System.currentTimeMillis();
        logger.debug("costTime[{}ms]",endTime-startTime);
        logger.info("========end==");
        return modelMap;
    }
}

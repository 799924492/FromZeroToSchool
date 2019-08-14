package com.imooc.myo2o.service;

import com.imooc.myo2o.BaseTest;
import com.imook.entry.Area;
import com.imook.service.AreaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AreaServiceTest extends BaseTest {

@Autowired
private AreaService areaService;
@Test
    public void aa(){
        List<Area> list = areaService.findList();
        for (Area area : list) {
            System.out.println(area);
        }
    }
}

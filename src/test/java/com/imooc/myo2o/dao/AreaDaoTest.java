package com.imooc.myo2o.dao;

import com.imooc.myo2o.BaseTest;
import com.imook.dao.AreaDao;
import com.imook.entry.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AreaDaoTest extends BaseTest {

@Autowired
    AreaDao areaDao;
@Test
public void aa(){
    List<Area> list = areaDao.findList();
    for (Area area : list) {
        System.out.println(area);
    }
}
}

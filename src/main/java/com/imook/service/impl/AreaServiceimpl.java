package com.imook.service.impl;

import com.imook.dao.AreaDao;
import com.imook.entry.Area;
import com.imook.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AreaServiceimpl implements AreaService {
   @Autowired
   AreaDao areaDao;
    @Override
    public List<Area> findList() {
        return areaDao.findList();
    }
}

package com.imook.dao;

import com.imook.entry.Area;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AreaDao {
// 根据权威排序
    List<Area> findList();
}

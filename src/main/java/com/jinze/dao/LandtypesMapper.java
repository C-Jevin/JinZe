package com.jinze.dao;

import com.jinze.core.Mapper;
import com.jinze.entity.Landtypes;
import org.apache.ibatis.annotations.CacheNamespace;

import java.util.List;
import java.util.Map;
//@CacheNamespace
public interface LandtypesMapper extends Mapper<Landtypes> {
    Map selectUsedLandPercentage(Map map);
}
package com.jinze.dao;

import com.jinze.core.Mapper;
import com.jinze.entity.Subbasin;
import org.apache.ibatis.annotations.CacheNamespace;

import java.util.List;
import java.util.Map;
//@CacheNamespace
public interface SubbasinMapper extends Mapper<Subbasin> {
    List<Map> selectTimeSeries(Map map);
    List<Map> selectAnimationSeries(Map map);
    Map selectMaxAndMinTime(Map map);

}
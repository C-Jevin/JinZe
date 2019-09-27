package com.jinze.dao;

import com.jinze.core.Mapper;
import com.jinze.entity.Nodeout;

import java.util.List;
import java.util.Map;

public interface NodeoutMapper extends Mapper<Nodeout> {
    List<Map> selectTimeSeries(Map map);
    List<Map> selectAnimationSeries(Map map);
    Map selectMaxAndMinTime(Map map);
}
package com.jinze.dao;

import com.jinze.core.Mapper;
import com.jinze.entity.Linkout;

import java.util.List;
import java.util.Map;

public interface LinkoutMapper extends Mapper<Linkout> {
    List<Map> selectTimeSeries(Map map);
    List<Map> selectAnimationSeries(Map map);
    Map selectMaxAndMinTime(Map map);
}
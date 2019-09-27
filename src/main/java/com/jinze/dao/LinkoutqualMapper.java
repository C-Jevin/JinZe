package com.jinze.dao;

import com.jinze.core.Mapper;
import com.jinze.entity.Linkoutqual;

import java.util.List;
import java.util.Map;

public interface LinkoutqualMapper extends Mapper<Linkoutqual> {
    List<Map> selectTimeSeries(Map map);
    List<Map> selectAnimationSeries(Map map);
    Map selectMaxAndMinTime(Map map);
}
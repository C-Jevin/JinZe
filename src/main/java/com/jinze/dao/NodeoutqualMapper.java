package com.jinze.dao;

import com.jinze.core.Mapper;
import com.jinze.entity.Nodeoutqual;

import java.util.List;
import java.util.Map;

public interface NodeoutqualMapper extends Mapper<Nodeoutqual> {
    List<Map> selectTimeSeries(Map map);
    List<Map> selectAnimationSeries(Map map);
    Map selectMaxAndMinTime(Map map);
}
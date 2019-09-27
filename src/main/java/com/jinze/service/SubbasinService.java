package com.jinze.service;
import com.jinze.entity.Subbasin;
import com.jinze.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2019/09/11.
 */
public interface SubbasinService extends Service<Subbasin> {
    List<Map> selectTimeSeries(Map map);
    List<Map> selectAnimationSeries(Map map);
    Map selectMaxAndMinTime(Map map);
}

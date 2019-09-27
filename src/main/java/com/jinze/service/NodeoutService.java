package com.jinze.service;
import com.jinze.entity.Nodeout;
import com.jinze.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2019/09/27.
 */
public interface NodeoutService extends Service<Nodeout> {
    List<Map> selectTimeSeries(Map map);
    List<Map> selectAnimationSeries(Map map);
    Map selectMaxAndMinTime(Map map);
}

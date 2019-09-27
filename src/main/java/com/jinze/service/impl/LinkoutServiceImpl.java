package com.jinze.service.impl;

import com.jinze.dao.LinkoutMapper;
import com.jinze.entity.Linkout;
import com.jinze.service.LinkoutService;
import com.jinze.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2019/09/27.
 */
@Service
@Transactional
public class LinkoutServiceImpl extends AbstractService<Linkout> implements LinkoutService {
    @Resource
    private LinkoutMapper linkoutMapper;

    @Override
    public List<Map> selectTimeSeries(Map map) {
        return linkoutMapper.selectTimeSeries(map);
    }

    @Override
    public List<Map> selectAnimationSeries(Map map) {
        return linkoutMapper.selectAnimationSeries(map);
    }

    @Override
    public Map selectMaxAndMinTime(Map map) {
        return linkoutMapper.selectMaxAndMinTime(map);
    }
}

package com.jinze.service.impl;

import com.jinze.dao.SubbasinMapper;
import com.jinze.entity.Subbasin;
import com.jinze.service.SubbasinService;
import com.jinze.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2019/09/11.
 */
@Service
@Transactional
public class SubbasinServiceImpl extends AbstractService<Subbasin> implements SubbasinService {
    @Resource
    private SubbasinMapper subbasinMapper;

    @Override
    public List<Map> selectTimeSeries(Map map) {
        return subbasinMapper.selectTimeSeries(map);
    }

    @Override
    public List<Map> selectAnimationSeries(Map map) {
        return subbasinMapper.selectAnimationSeries(map);
    }

    @Override
    public Map selectMaxAndMinTime(Map map) {
        return subbasinMapper.selectMaxAndMinTime(map);
    }
}

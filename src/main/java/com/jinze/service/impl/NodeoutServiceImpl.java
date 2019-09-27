package com.jinze.service.impl;

import com.jinze.dao.NodeoutMapper;
import com.jinze.entity.Nodeout;
import com.jinze.service.NodeoutService;
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
public class NodeoutServiceImpl extends AbstractService<Nodeout> implements NodeoutService {
    @Resource
    private NodeoutMapper nodeoutMapper;

    @Override
    public List<Map> selectTimeSeries(Map map) {
        return nodeoutMapper.selectTimeSeries(map);
    }

    @Override
    public List<Map> selectAnimationSeries(Map map) {
        return nodeoutMapper.selectAnimationSeries(map);
    }

    @Override
    public Map selectMaxAndMinTime(Map map) {
        return nodeoutMapper.selectMaxAndMinTime(map);
    }
}

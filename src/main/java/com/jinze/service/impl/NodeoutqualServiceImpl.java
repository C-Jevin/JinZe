package com.jinze.service.impl;

import com.jinze.dao.NodeoutqualMapper;
import com.jinze.entity.Nodeoutqual;
import com.jinze.service.NodeoutqualService;
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
public class NodeoutqualServiceImpl extends AbstractService<Nodeoutqual> implements NodeoutqualService {
    @Resource
    private NodeoutqualMapper nodeoutqualMapper;

    @Override
    public List<Map> selectTimeSeries(Map map) {
        return nodeoutqualMapper.selectTimeSeries(map);
    }

    @Override
    public List<Map> selectAnimationSeries(Map map) {
        return nodeoutqualMapper.selectAnimationSeries(map);
    }

    @Override
    public Map selectMaxAndMinTime(Map map) {
        return nodeoutqualMapper.selectMaxAndMinTime(map);
    }
}

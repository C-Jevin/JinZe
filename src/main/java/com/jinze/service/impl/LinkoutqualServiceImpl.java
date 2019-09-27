package com.jinze.service.impl;

import com.jinze.dao.LinkoutqualMapper;
import com.jinze.entity.Linkoutqual;
import com.jinze.service.LinkoutqualService;
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
public class LinkoutqualServiceImpl extends AbstractService<Linkoutqual> implements LinkoutqualService {
    @Resource
    private LinkoutqualMapper linkoutqualMapper;

    @Override
    public List<Map> selectTimeSeries(Map map) {
        return linkoutqualMapper.selectTimeSeries(map);
    }

    @Override
    public List<Map> selectAnimationSeries(Map map) {
        return linkoutqualMapper.selectAnimationSeries(map);
    }

    @Override
    public Map selectMaxAndMinTime(Map map) {
        return linkoutqualMapper.selectMaxAndMinTime(map);
    }
}

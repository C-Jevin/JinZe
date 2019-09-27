package com.jinze.service.impl;

import com.jinze.dao.LandtypesMapper;
import com.jinze.entity.Landtypes;
import com.jinze.service.LandtypesService;
import com.jinze.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2019/09/16.
 */
@Service
@Transactional
public class LandtypesServiceImpl extends AbstractService<Landtypes> implements LandtypesService {
    @Resource
    private LandtypesMapper landtypesMapper;

    @Override
    public Map selectUsedLandPercentage(Map map) {
        return landtypesMapper.selectUsedLandPercentage(map);
    }
}

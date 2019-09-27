package com.jinze.service.impl;

import com.jinze.dao.DatastateMapper;
import com.jinze.entity.Datastate;
import com.jinze.service.DatastateService;
import com.jinze.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/09/11.
 */
@Service
@Transactional
public class DatastateServiceImpl extends AbstractService<Datastate> implements DatastateService {
    @Resource
    private DatastateMapper datastateMapper;

}

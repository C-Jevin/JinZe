package com.jinze.dao;

import com.jinze.core.Mapper;
import com.jinze.entity.Datastate;
import org.apache.ibatis.annotations.CacheNamespace;

@CacheNamespace
public interface DatastateMapper extends Mapper<Datastate> {
}
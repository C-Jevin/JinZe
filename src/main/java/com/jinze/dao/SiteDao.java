package com.jinze.dao;

import com.jinze.entity.Site;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SiteDao {
    Site findTbNameBySiteId(String siteId);
}

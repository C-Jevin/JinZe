package com.jinze.service.impl;

import com.jinze.dao.SiteDao;
import com.jinze.entity.Site;
import com.jinze.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    private SiteDao siteDao;
    public Site findTbNameBySiteId(String siteId){
       return siteDao.findTbNameBySiteId(siteId);
   }
}

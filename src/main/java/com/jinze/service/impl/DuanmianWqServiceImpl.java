package com.jinze.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jinze.dao.DuanmianWqDao;
import com.jinze.entity.DuanmianWq;
import com.jinze.service.DuanmianWqService;

@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
public class DuanmianWqServiceImpl implements DuanmianWqService{
	@Autowired
	private DuanmianWqDao duanmianWqDao;
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteName
	 * @return
	 */
	public List<DuanmianWq> selectDuanmianWqBySiteName(String siteName){
		return duanmianWqDao.selectDuanmianWqBySiteName(siteName);
	}
}

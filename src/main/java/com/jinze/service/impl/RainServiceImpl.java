package com.jinze.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jinze.dao.RainDao;
import com.jinze.entity.Rain;
import com.jinze.service.RainService;

@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
public class RainServiceImpl implements RainService{
	@Autowired
	private RainDao rainDao;
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteName
	 * @return
	 */
	public List<Rain> selectRainBySiteName(String siteName){
		return rainDao.selectRainBySiteName(siteName);
	}
}

package com.jinze.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jinze.dao.GroundWaterDao;
import com.jinze.entity.GroundWater;
import com.jinze.service.GroundWaterService;
@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
public class GroundWaterServiceImpl implements GroundWaterService{
	@Autowired
	private GroundWaterDao groundWaterDao;
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteName
	 * @return
	 */
	public List<GroundWater> selectGroundWaterBySiteName(String siteName){
		return groundWaterDao.selectGroundWaterBySiteName(siteName);
	}
}

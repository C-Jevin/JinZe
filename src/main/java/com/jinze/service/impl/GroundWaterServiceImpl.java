package com.jinze.service.impl;

import java.util.List;
import java.util.Map;

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
	 * @param siteId
	 * @return
	 */
	public List<GroundWater> selectGroundWaterBySiteId(String siteId){
		return groundWaterDao.selectGroundWaterBySiteId(siteId);
	}

	/**
	 * 根据条件查询表记录总数
	 * @param map
	 * @return
	 */
	public Long selectCount(Map<String, Object> map) {
		return groundWaterDao.selectCount(map);
	}

	/**
	 * 更新表记录
	 * @param groundWater
	 */
	public void update(GroundWater groundWater) {
		groundWaterDao.update(groundWater);
	}

	/**
	 * 根据ID删除
	 * @param id
	 */
	public void deleteById(String id) {
		groundWaterDao.deleteById(id);
	}

	/**
	 * 根据ID批量删除
	 * @param list
	 */
	public void deleteByList(List<String> list) {
		groundWaterDao.deleteByList(list);
	}

	/**
	 *新增记录
	 * @param groundWater
	 */
	public void insert(GroundWater groundWater) {
		groundWaterDao.insert(groundWater);
	}
}

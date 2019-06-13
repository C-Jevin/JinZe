package com.jinze.service;

import java.util.List;
import java.util.Map;

import com.jinze.entity.GroundWater;

/**
 * 地下水Service
 * @author JackVan
 *
 */
public interface GroundWaterService {
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteId
	 * @return
	 */
	List<GroundWater> selectGroundWaterBySiteId(String siteId);
	/**
	 *根据条件查询表记录总数
	 */
	Long selectCount(Map<String,Object> map);
	/**
	 * 更新表记录
	 */
	void update(GroundWater groundWater);
	/**
	 * 删除表记录
	 */
	void deleteById(String id);
	/**
	 * 批量删除表记录
	 */
	void deleteByList(List<String> list);
	/**
	 * 新增表记录
	 */
	void insert(GroundWater groundWater);
}

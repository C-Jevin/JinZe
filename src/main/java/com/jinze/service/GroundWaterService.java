package com.jinze.service;

import java.util.List;

import com.jinze.entity.GroundWater;

/**
 * 地下水Service
 * @author JackVan
 *
 */
public interface GroundWaterService {
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteName
	 * @return
	 */
	public List<GroundWater> selectGroundWaterBySiteName(String siteName);
}

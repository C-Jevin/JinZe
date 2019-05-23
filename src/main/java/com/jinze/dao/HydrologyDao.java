package com.jinze.dao;

import java.util.List;

import com.jinze.entity.Hydrology;

public interface HydrologyDao {
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteName
	 * @return
	 */
	public List<Hydrology> selectHydrologyBySiteName(String siteName);
}

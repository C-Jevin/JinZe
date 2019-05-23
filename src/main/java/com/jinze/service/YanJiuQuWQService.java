package com.jinze.service;

import java.util.List;

import com.jinze.entity.YanJiuQuWQ;

public interface YanJiuQuWQService {
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteName
	 * @return
	 */
	public List<YanJiuQuWQ> selectYanJiuQuWQBySiteName(String siteName);
}

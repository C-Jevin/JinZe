package com.jinze.service;

import java.util.List;

import com.jinze.entity.DuanmianWq;
/**
 * 水质断面Service层
 * @author JackVan
 *
 */
public interface DuanmianWqService {
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteName
	 * @return
	 */
	public List<DuanmianWq> selectDuanmianWqBySiteName(String siteName);
}

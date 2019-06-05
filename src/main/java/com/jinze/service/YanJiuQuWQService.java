package com.jinze.service;

import java.util.List;
import java.util.Map;

import com.jinze.entity.YanJiuQuWQ;

public interface YanJiuQuWQService {
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteName
	 * @return
	 */
	List<YanJiuQuWQ> selectYanJiuQuWQBySiteName(String siteName);
	/**
	 *根据条件查询表记录总数
	 */
	Long selectCount(Map<String,Object> map);
	/**
	 * 更新表记录
	 */
	void update(YanJiuQuWQ yanJiuQuWQ);
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
	void insert(YanJiuQuWQ yanJiuQuWQ);
	/**
	 查询日均 月均 年均数据
	 */
	List<YanJiuQuWQ> selectAverageByMap(Map<String,Object> map);
	/**
	 * 查询某时间段内的数据
	 * @param map
	 * @return
	 */
	List<YanJiuQuWQ> selectAverageByDate(Map<String,Object> map);
}

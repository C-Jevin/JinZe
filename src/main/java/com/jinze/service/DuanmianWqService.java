package com.jinze.service;

import java.util.List;
import java.util.Map;

import com.jinze.entity.DuanMianWq;
/**
 * 水质断面Service层
 * @author JackVan
 *
 */
public interface DuanmianWqService {
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteId
	 * @return
	 */
	 List<DuanMianWq> selectDuanmianWqBySiteId(String siteId);
	/**
	 *根据条件查询表记录总数
	 */
	Long selectCount(Map<String,Object> map);
	/**
	 * 更新表记录
	 */
	void update(DuanMianWq duanMianWq);
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
	void insert(DuanMianWq duanMianWq);
	/**
	 查询日均 月均 年均数据
	 */
	List<DuanMianWq> selectAverageByMap(Map<String,Object> map);

	/**
	 * 查询某时间段内的数据
	 * @param map
	 * @return
	 */
	List<DuanMianWq> selectAverageByDate(Map<String,Object> map);
}

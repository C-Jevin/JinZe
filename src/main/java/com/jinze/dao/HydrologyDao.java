package com.jinze.dao;

import java.util.List;
import java.util.Map;

import com.jinze.entity.Hydrology;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Repository
//@Mapper
//@CacheNamespace
public interface HydrologyDao {
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteId
	 * @return
	 */
	 List<Hydrology> selectHydrologyBySiteId(String siteId);
	/**
	 *根据条件查询表记录总数
	 */
	Long selectCount(Map<String,Object> map);
	/**
	 * 更新表记录
	 */
	void update(Hydrology hydrology);
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
	void insert(Hydrology hydrology);
	/**
	 查询日均 月均 年均数据
	 */
	List<Hydrology> selectAverageByMap(Map<String,Object> map);
	/**
	 * 查询某时间段内的数据
	 * @param map
	 * @return
	 */
	List<Hydrology> selectAverageByDate(Map<String,Object> map);
}

package com.jinze.service;

import java.util.List;
import java.util.Map;

import com.jinze.entity.MonomerBmp;

public interface MonomerBmpService {

	List<MonomerBmp> selectMonomerBmp(Map<String, Object> map);
	/**
	 *根据条件查询表记录总数
	 */
	Long selectCount(Map<String,Object> map);
	/**
	 * 更新表记录
	 */
	void update(MonomerBmp monomerBmp);
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
	void insert(MonomerBmp monomerBmp);
}

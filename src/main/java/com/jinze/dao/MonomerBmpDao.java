package com.jinze.dao;

import java.util.List;
import java.util.Map;

import com.jinze.entity.MonomerBmp;

public interface MonomerBmpDao {

	/**
	 * 根据相关条件查询评估参数
	 * @param
	 * @return
	 */
	public List<MonomerBmp> selectMonomerBmp(Map<String, Object> map);
}

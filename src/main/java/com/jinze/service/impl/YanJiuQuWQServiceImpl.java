package com.jinze.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jinze.dao.YanJiuQuWQDao;
import com.jinze.entity.YanJiuQuWQ;
import com.jinze.service.YanJiuQuWQService;

@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
public class YanJiuQuWQServiceImpl implements YanJiuQuWQService{
	@Autowired
	private YanJiuQuWQDao yanJiuQuWQDao;
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteName
	 * @return
	 */
	public List<YanJiuQuWQ> selectYanJiuQuWQBySiteName(String siteName){
		return yanJiuQuWQDao.selectYanJiuQuWQBySiteName(siteName);
	}
}

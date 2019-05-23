package com.jinze.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jinze.dao.HydrologyDao;
import com.jinze.entity.Hydrology;
import com.jinze.service.HydrologyService;
@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
public class HydrologyServiceImpl implements HydrologyService{
	@Autowired
	private HydrologyDao hydrologyDao;
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteName
	 * @return
	 */
	public List<Hydrology> selectHydrologyBySiteName(String siteName){
		return hydrologyDao.selectHydrologyBySiteName(siteName);
	}
}

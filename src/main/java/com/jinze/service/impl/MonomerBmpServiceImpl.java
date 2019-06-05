package com.jinze.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jinze.dao.MonomerBmpDao;
import com.jinze.entity.MonomerBmp;
import com.jinze.service.MonomerBmpService;
@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
public class MonomerBmpServiceImpl implements MonomerBmpService {

	@Autowired
	private MonomerBmpDao mBmpDao;
	
	/**
	 * 根据条件查询评估类型参数；
	 */
	public List<MonomerBmp> selectMonomerBmp(Map<String, Object> map) {
		return mBmpDao.selectMonomerBmp(map);
	}

	public Long selectCount(Map<String, Object> map) {
		return mBmpDao.selectCount(map);
	}

	public void update(MonomerBmp monomerBmp) {
		mBmpDao.update(monomerBmp);
	}

	public void deleteById(String id) {
		mBmpDao.deleteById(id);
	}

	public void deleteByList(List<String> list) {
		mBmpDao.deleteByList(list);
	}

	public void insert(MonomerBmp monomerBmp) {
		mBmpDao.insert(monomerBmp);
	}

}

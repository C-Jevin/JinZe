package com.jinze.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jinze.dao.WeatherDao;
import com.jinze.entity.Weather;
import com.jinze.service.WeatherService;
@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
public class WeatherServiceImpl implements WeatherService{
	@Autowired
	private WeatherDao weatherDao;
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteName
	 * @return
	 */
	public List<Weather> selectWeatherBySiteName(String siteName){
		return weatherDao.selectWeatherBySiteName(siteName);
	}
}

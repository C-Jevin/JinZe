package com.jinze.service;

import java.util.List;

import com.jinze.entity.Weather;

public interface WeatherService {
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteName
	 * @return
	 */
	public List<Weather> selectWeatherBySiteName(String siteName);
}

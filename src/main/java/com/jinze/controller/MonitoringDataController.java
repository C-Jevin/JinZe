package com.jinze.controller;

import java.util.List;


import com.jinze.core.Result;
import com.jinze.core.ResultGenerator;
import com.jinze.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jinze.entity.DuanMianWq;
import com.jinze.entity.GroundWater;
import com.jinze.entity.Hydrology;
import com.jinze.entity.Rain;
import com.jinze.entity.Weather;
import com.jinze.entity.YanJiuQuWQ;

@Api(value = "监测数据", description = "监测相关数据 API", position = 100, protocols = "http")
@RestController
@RequestMapping("/JinZeApi/monitorDate")
public class MonitoringDataController {
	@Autowired
	private DuanmianWqService duanmianWqService;
	@Autowired
	private GroundWaterService groundWaterService;
	@Autowired
	private HydrologyService hydrologyService;
	@Autowired
	private RainService rainService;
	@Autowired
	private WeatherService weatherService;
	@Autowired
	private YanJiuQuWQService yanJiuQuWQService;
	@Autowired
	private SiteService siteService;
	
	
	/**
	 * 根据表名和站点名查询数据
	 * @param siteId
	 */
	@ApiOperation(
			value = "查询表记录",
			notes = "根据表名和站点名查询数据",
			produces="application/json",
			consumes="application/json")
	@GetMapping(value = "/showData")
	public Result showData(@RequestParam(value = "siteId",required = true,defaultValue = "")String siteId) {
		try {
			String tName = siteService.findTbNameBySiteId(siteId).getTbName();
			System.err.println(siteId+" "+tName);
			//根据表名称来判断查询的表，及返回数据
			if(tName.equals("tb_rain")) {
				List<Rain> list = rainService.selectRainBySiteId(siteId);
				return ResultGenerator.genSuccessResult(list);
			}else if(tName.equals("tb_weather")) {
				List<Weather> list = weatherService.selectWeatherBySiteId(siteId);
				return ResultGenerator.genSuccessResult(list);
			}else if(tName.equals("tb_hydrology")) {
				List<Hydrology> list = hydrologyService.selectHydrologyBySiteId(siteId);
				return ResultGenerator.genSuccessResult(list);
			}else if(tName.equals("tb_duanmianwq")) {
				List<DuanMianWq> list = duanmianWqService.selectDuanmianWqBySiteId(siteId);
				return ResultGenerator.genSuccessResult(list);
			}else if(tName.equals("tb_yanjiuquwq")) {
				List<YanJiuQuWQ> list = yanJiuQuWQService.selectYanJiuQuWQBySiteId(siteId);
				return ResultGenerator.genSuccessResult(list);
			}else if(tName.equals("tb_groundWater")) {
				List<GroundWater> list = groundWaterService.selectGroundWaterBySiteId(siteId);
				for (GroundWater groundWater : list) {
					System.err.println(groundWater.toString());
				}
				return ResultGenerator.genSuccessResult(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResultGenerator.genFailResult(e.getMessage());
		}
		return  null;
	}

	
	
}

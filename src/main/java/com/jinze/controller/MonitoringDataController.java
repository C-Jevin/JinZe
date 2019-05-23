package com.jinze.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jinze.entity.DuanmianWq;
import com.jinze.entity.GroundWater;
import com.jinze.entity.Hydrology;
import com.jinze.entity.Rain;
import com.jinze.entity.Weather;
import com.jinze.entity.YanJiuQuWQ;
import com.jinze.service.DuanmianWqService;
import com.jinze.service.GroundWaterService;
import com.jinze.service.HydrologyService;
import com.jinze.service.RainService;
import com.jinze.service.WeatherService;
import com.jinze.service.YanJiuQuWQService;
import com.jinze.util.JsonUtil;


@RestController
@RequestMapping("monitoring")
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
	
	
	
	/**
	 * 根据表名和站点名查询数据
	 * @param sName
	 * @param tName
	 * @param response
	 */
	@RequestMapping(value = "/showData",method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public void showData(@RequestParam(value = "sName",required = true,defaultValue = "")String sName,
						 @RequestParam(value = "tName",required = true,defaultValue = "")String tName, HttpServletResponse response) {
		try {
			//response.setHeader("Access-Control-Allow-Origin", "*");
			System.err.println(sName+" "+tName);
			// 设置ajax json字符串编码格式
			response.setContentType("application/json;charset=utf-8");
			// out对象
			PrintWriter out = response.getWriter();
			//根据表名称来判断查询的表，及返回数据
			if(tName.equals("tb_rain")) {
				List<Rain> list = rainService.selectRainBySiteName(sName);
				out.print(JsonUtil.toJson(list));
			}else if(tName.equals("tb_weather")) {
				List<Weather> list = weatherService.selectWeatherBySiteName(sName);
				out.print(JsonUtil.toJson(list));
			}else if(tName.equals("tb_hydrology")) {
				List<Hydrology> list = hydrologyService.selectHydrologyBySiteName(sName);
				out.print(JsonUtil.toJson(list));
			}else if(tName.equals("tb_duanmianWQ")) {
				List<DuanmianWq> list = duanmianWqService.selectDuanmianWqBySiteName(sName);
				out.print(JsonUtil.toJson(list));
			}else if(tName.equals("tb_yanjiuquWQ")) {
				List<YanJiuQuWQ> list = yanJiuQuWQService.selectYanJiuQuWQBySiteName(sName);
				out.print(JsonUtil.toJson(list));
			}else if(tName.equals("tb_groundWater")) {
				List<GroundWater> list = groundWaterService.selectGroundWaterBySiteName(sName);
				for (GroundWater groundWater : list) {
					System.err.println(groundWater.toString());
				}
				out.print(JsonUtil.toJson(list));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}

package com.jinze.controller;

import com.jinze.core.Result;
import com.jinze.core.ResultGenerator;
import com.jinze.entity.SearchCond;
import com.jinze.entity.Subbasin;
import com.jinze.service.SubbasinService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinze.util.AverageDateUtil;
import com.jinze.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by CodeGenerator on 2019/09/11.
 */
@Api(value = "子流域结果", description = "子流域结果 API", position = 100, protocols = "http")
@RestController
@RequestMapping("/JinZeApi/subbasin")
public class SubbasinController {

    private static Logger Log = LoggerFactory.getLogger(SubbasinController.class);

    @Resource
    private SubbasinService subbasinService;


    @ApiOperation(
            value = "查询时间序列污染物值",
            notes = "根据子流域(subid),开始结束时间(startTime/endTime),污染物(pollutant),情景ID(stateid)查询",
            produces = "application/json",
            consumes = "application/json")
    @PostMapping("/timeSeries")
    public Result timeSeriesOfSubBasin(@RequestBody Map map) {
        try {
            if (map.get("subid").equals("")) {
                throw new Exception("子流域id不能为空");
            }
            if (map.get("pollutant").equals("")) {
                throw new Exception("污染物指标不能为空");
            }
            if (map.get("stateid")==null) {
                throw new Exception("情景ID不能为空");
            }
            if (!map.get("startTime").equals("") && !map.get("endTime").equals("")) {
                String st = DateUtil.getStrFromDate(DateUtil.getDateFromStr(String.valueOf(map.get("startTime")),"yyyy/MM/dd"),"yyyy/MM/dd");
                String et = DateUtil.getStrFromDate(DateUtil.getDateFromStr(String.valueOf(map.get("endTime")),"yyyy/MM/dd"),"yyyy/MM/dd");
                map.put("startTime", "\'" + st+ "\'");
                map.put("endTime", "\'" + et + "\'");
            }
            //map.put("subid","\'"+map.get("subid") + "\'");
            List<Map> result = subbasinService.selectTimeSeries(map);
            return ResultGenerator.genSuccessResult(result);
        } catch (Exception e) {
            e.printStackTrace();
            Log.error(e.getMessage());
            return ResultGenerator.genFailResult(e.getMessage());
        }

    }

    @ApiOperation(
            value = "查询动画演变序列污染物值",
            notes = "开始结束时间(startTime/endTime),污染物(pollutant),情景ID(stateid)查询",
            produces = "application/json",
            consumes = "application/json")
    @PostMapping("/animationSeries")
    public Result animationSeriesOfSubBasin(@RequestBody Map map) {
        try {
            if (map.get("pollutant").equals(""))
                throw new Exception("污染物指标不能为空");
            if (map.get("stateid")==null)
                throw new Exception("情景ID不能为空");
            SearchCond searchCond = new SearchCond();
            List<String> timeList;
            if (!map.get("startTime").equals("") && !map.get("endTime").equals("")) {
                searchCond.setCondition("Day");
                String st = (String) map.get("startTime");
                String et = (String) map.get("endTime");
                searchCond.setStartTime(st.substring(0,4)+"-"+st.substring(5,7)+"-"+st.substring(8));
                searchCond.setEndTime(et.substring(0,4)+"-"+et.substring(5,7)+"-"+et.substring(8));
                //System.out.println(searchCond.getStartTime()+"======"+searchCond.getEndTime());
                timeList = AverageDateUtil.splitDate(searchCond);
                //map.put("startTime","\'"+map.get("startTime")+"\'");
                //map.put("endTime","\'"+map.get("endTime")+"\'");
            } else {
                Map timeMap = subbasinService.selectMaxAndMinTime(map);
                //System.out.println(timeMap.get("MaxDt"));
                searchCond.setCondition("Day");
                searchCond.setStartTime(DateUtil.getStrFromDate((Date) timeMap.get("MinDt"), "yyyy-MM-dd"));
                searchCond.setEndTime(DateUtil.getStrFromDate((Date) timeMap.get("MaxDt"), "yyyy-MM-dd"));
                timeList = AverageDateUtil.splitDate(searchCond);
            }
            Map codiMap = new HashMap();
            codiMap.put("pollutant",map.get("pollutant"));
            //List<Map> result = new ArrayList<>();
            Map resMap = new HashMap();
            //使用缓存，首次加载查询走sql，第二次走缓存
            //List<Map> result;
            for (int i = 0; i < timeList.size(); i++) {
                codiMap.put("Time", "\'" + timeList.get(i) + "\'");
                List<Map> result  = subbasinService.selectAnimationSeries(codiMap);
                resMap.put(timeList.get(i),result);
                //resMap.put(timeList.get(i),((ArrayList<Map>) result).clone());
                //result.clear();
            }
            return ResultGenerator.genSuccessResult(resMap);
        } catch (Exception e) {
            e.printStackTrace();
            Log.error(e.getMessage());
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @ApiOperation(
            value = "查询子流域起始时间和结束时间",
            notes = "根据情景ID(stateid)查询",
            produces = "application/json",
            consumes = "application/json")
    @GetMapping("/getTime")
    public Result getTimeOfSubbasin(@RequestParam Integer stateid){
        try {
            if (stateid==null)
                throw new Exception("情景ID不能为空");
            Map map = new HashMap();
            map.put("stateid",stateid);
            Map resMap = new HashMap();
            resMap = subbasinService.selectMaxAndMinTime(map);
            return  ResultGenerator.genSuccessResult(resMap);
        }catch (Exception e){
            e.printStackTrace();
            Log.error(e.getMessage());
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }
}

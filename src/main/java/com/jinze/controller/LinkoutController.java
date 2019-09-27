package com.jinze.controller;

import com.jinze.core.Result;
import com.jinze.core.ResultGenerator;
import com.jinze.entity.SearchCond;
import com.jinze.service.LinkoutService;
import com.jinze.service.LinkoutqualService;
import com.jinze.util.AverageDateUtil;
import com.jinze.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by CodeGenerator on 2019/09/27.
*/

@Api(value = "DB-管网结果", description = "DB-管网结果 API", position = 100, protocols = "http")
@RestController
@RequestMapping("/JinZeApi/DBlinkout")
public class LinkoutController {
    private static Logger Log = LoggerFactory.getLogger(LinkoutController.class);
    @Resource
    private LinkoutService linkoutService;

    @Resource
    private LinkoutqualService linkoutqualService;

    @ApiOperation(
            value = "查询管段时间序列污染物值",
            notes = "根据管段(linkId),开始结束时间(startTime/endTime),污染物(pollutant),情景ID(stateid)查询",
            produces = "application/json",
            consumes = "application/json")
    @PostMapping("/timeSeries")
    public Result timeSeriesOfSubBasin(@RequestBody Map map) {
        try {
            if (map.get("linkId").equals("")) {
                throw new Exception("linkId不能为空");
            }
            if (map.get("pollutant").equals("")) {
                throw new Exception("污染物指标不能为空");
            }
            if (map.get("stateid")==null) {
                throw new Exception("情景ID不能为空");
            }
            if (!map.get("endTime").equals("") && !map.get("startTime").equals("")) {
                Date sdt = DateUtil.getDateFromStr((String) map.get("startTime"), "yyyy/MM/dd");
                Date edt = DateUtil.getDateFromStr((String) map.get("endTime"), "yyyy/MM/dd");
                if (edt.before(sdt))
                    throw new Exception("开始时间不能晚于结束时间");
            }
            List<Map> result;
            if ("flow".equals(map.get("pollutant"))){
                result = linkoutService.selectTimeSeries(map);
            }else {
                result = linkoutqualService.selectTimeSeries(map);
            }

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
                throw new Exception("污染物指标不能为空.");
            if (map.get("stateid")==null)
                throw new Exception("情景ID不能为空");
            SearchCond searchCond = new SearchCond();
            List<String> timeList;
            if (!map.get("endTime").equals("") && !map.get("startTime").equals("")) {
                searchCond.setCondition("Day");
                String st = (String) map.get("startTime");
                String et = (String) map.get("endTime");
                searchCond.setEndTime(et.substring(0,4)+"-"+et.substring(5,7)+"-"+et.substring(8));
                searchCond.setStartTime(st.substring(0,4)+"-"+st.substring(5,7)+"-"+st.substring(8));
                timeList = AverageDateUtil.splitDate(searchCond);
            } else {
                Map timeMap = linkoutService.selectMaxAndMinTime(map);
                searchCond.setCondition("Day");
                searchCond.setEndTime(DateUtil.getStrFromDate((Date) timeMap.get("MaxDt"), "yyyy-MM-dd"));
                searchCond.setStartTime(DateUtil.getStrFromDate((Date) timeMap.get("MinDt"), "yyyy-MM-dd"));
                timeList = AverageDateUtil.splitDate(searchCond);
            }
            Map codiMap = new HashMap();
            codiMap.put("pollutant",map.get("pollutant"));
            Map resMap = new HashMap();
            //使用缓存，首次加载查询走sql，第二次走缓存
            for (int i = 0; i < timeList.size(); i++) {
                codiMap.put("Time", timeList.get(i));
                if (map.get("pollutant").equals("flow")){
                    List<Map> result  = linkoutService.selectAnimationSeries(codiMap);
                    resMap.put(timeList.get(i),result);
                }else {
                    List<Map> result  = linkoutqualService.selectAnimationSeries(codiMap);
                    resMap.put(timeList.get(i),result);
                }
            }
            return ResultGenerator.genSuccessResult(resMap);
        } catch (Exception e) {
            e.printStackTrace();
            Log.error(e.getMessage());
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @ApiOperation(
            value = "查询管段起始时间和结束时间",
            notes = "根据情景ID(stateid)查询",
            produces = "application/json",
            consumes = "application/json")
    @GetMapping("/getTime")
    public Result getTimeOfSubbasin(@RequestParam Integer stateid){
        try {
            if (stateid==null)
                throw new Exception("情景ID不能为空.");
            Map map = new HashMap();
            map.put("stateid",stateid);
            Map resMap = new HashMap();
            resMap = linkoutService.selectMaxAndMinTime(map);
            return  ResultGenerator.genSuccessResult(resMap);
        }catch (Exception e){
            e.printStackTrace();
            Log.error(e.getMessage());
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }
}

package com.jinze.controller;

import com.jinze.core.Result;
import com.jinze.core.ResultGenerator;
import com.jinze.entity.*;
import com.jinze.service.*;
import com.jinze.util.AverageDateUtil;
import com.jinze.util.DateUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "计算年月日平均值", description = "计算水文水质年月日平均/降雨和操作 API", position = 100, protocols = "http")
@RestController
@RequestMapping("/JinZeApi")
public class AverageDataController {

    @Autowired
    private DuanmianWqService duanmianWqService;
    @Autowired
    private HydrologyService hydrologyService;
    @Autowired
    private RainService rainService;
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private YanJiuQuWQService yanJiuQuWQService;

    @ApiOperation(
            value = "水文水质年月日平均值",
            notes = "根据条件计算出相关的平均值",
            produces="application/json",
            consumes="application/json")
    @PostMapping(value = "averData" )
    public Result selectAverByDate(@RequestBody @ApiParam(name="查询条件",value="传入json格式",required=true)SearchCond searchCond , HttpServletResponse response){
        try{
            response.setContentType("application/json;charset=utf-8");
            Map<String,Object> param = new HashMap<>();
            //判空
            if(searchCond.getStartTime().equals("")||searchCond.getEndTime().equals("")){
                throw new NullPointerException("开始时间和结束时间不能为空！");
            }
            Date sDate = DateUtil.getDateFromStr(searchCond.getStartTime(),"yyyy-MM-dd");
            Date eDate = DateUtil.getDateFromStr(searchCond.getEndTime(),"yyyy-MM-dd");
            //判断时间大小以及 其他条件判空
            if(eDate.before(sDate)){
                throw new Exception("开始时间不能小于结束时间！");
            }
            if(searchCond.getTbName().equals("")){
                throw new NullPointerException("数据表名不能为空！");
            }
            if(searchCond.getSiteId().equals("")){
                throw new NullPointerException("站点ID不能为空！");
            }
            if(searchCond.getCondition().equals("")){
                throw new NullPointerException("计算条件不能为空！");
            }
            List<String> dateList = AverageDateUtil.splitDate(searchCond);
            System.err.println("时间范围："+dateList.toString());
            param.put("siteId",searchCond.getSiteId());
            param.put("list",dateList);
            param.put("searchDate",searchCond.getCondition());
            if (searchCond.getTbName().equals("tb_duanmianwq")){
                List<DuanMianWq> resList = duanmianWqService.selectAverageByDate(param);
                for (DuanMianWq duanMianWq : resList){
                    System.err.println(duanMianWq.toString());
                }
                return ResultGenerator.genSuccessResult(resList);
            }else if (searchCond.getTbName().equals("tb_hydrology")){
                List<Hydrology> resList = hydrologyService.selectAverageByDate(param);
                return ResultGenerator.genSuccessResult(resList);
            }else if (searchCond.getTbName().equals("tb_weather")){
                List<Weather> resList = weatherService.selectAverageByDate(param);
                return ResultGenerator.genSuccessResult(resList);
            }else if (searchCond.getTbName().equals("tb_yanjiuquwq")){
                List<YanJiuQuWQ> resList = yanJiuQuWQService.selectAverageByDate(param);
                return ResultGenerator.genSuccessResult(resList);
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult(e.getMessage());
        }
        return null;
    }

    @ApiOperation(
            value = "降雨累加和",
            notes = "根据条件计算出相关降雨累加和值",
            produces="application/json",
            consumes="application/json")
    @PostMapping(value = "rainPlus")
    public Result selectRainPlus(@RequestBody @ApiParam(name="查询条件",value="传入json格式",required=true)SearchCond searchCond, HttpServletResponse response){
        try{
            response.setContentType("application/json;charset=utf-8");
            Map<String,Object> param = new HashMap<>();
            //判空
            if(searchCond.getStartTime().equals("")||searchCond.getEndTime().equals("")){
                throw new NullPointerException("开始时间和结束时间不能为空！");
            }
            Date sDate = DateUtil.getDateFromStr(searchCond.getStartTime(),"yyyy-MM-dd");
            Date eDate = DateUtil.getDateFromStr(searchCond.getEndTime(),"yyyy-MM-dd");
            //判断时间大小以及 其他条件判空
            if(eDate.before(sDate)){
                throw new Exception("开始时间不能小于结束时间！");
            }
            if(searchCond.getTbName().equals("")){
                throw new NullPointerException("数据表名不能为空！");
            }
            if(searchCond.getSiteId().equals("")){
                throw new NullPointerException("站点ID不能为空！");
            }
            if(searchCond.getCondition().equals("")){
                throw new NullPointerException("计算条件不能为空！");
            }
            List<String> dateList = AverageDateUtil.splitDate(searchCond);
            System.err.println("时间范围："+dateList.toString());
            param.put("siteId",searchCond.getSiteId());
            param.put("list",dateList);
            param.put("searchDate",searchCond.getCondition());
            if(searchCond.getTbName().equals("tb_rain")){
                List<Rain> resList = rainService.selectPlusByDate(param);
                if(resList.size()>0){
                    return ResultGenerator.genSuccessResult(resList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult(e.getMessage());
        }
        return  null;
    }
}

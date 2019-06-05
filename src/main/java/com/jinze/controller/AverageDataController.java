package com.jinze.controller;

import com.jinze.entity.*;
import com.jinze.service.*;
import com.jinze.util.AverageDateUtil;
import com.jinze.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
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

    @RequestMapping(value = "averData" ,method = RequestMethod.POST)
    public void selectAverByDate(@RequestBody Map<String,Object> map , HttpServletResponse response){
        try{
            System.err.println(map.toString());
            response.setContentType("application/json;charset=utf-8");
            Map<String,Object> param = new HashMap<>();
            PrintWriter out = response.getWriter();
            String tbName = (String) map.get("tbName");
            String cond = (String)map.get("condition");
            System.err.println("========="+cond+"========");
            List<String> dateList = AverageDateUtil.splitDate(map);
            System.err.println(dateList.toString());
            String siteId = (String)map.get("siteId");
            param.put("siteId",siteId);
            param.put("list",dateList);
            param.put("searchDate",cond);
            if (tbName.equals("tb_duanmianwq")){
                List<DuanMianWq> resList = duanmianWqService.selectAverageByDate(param);
                out.print(JsonUtil.toJson(resList));
                for (DuanMianWq duanMianWq : resList){
                    System.err.println(duanMianWq.toString());
                }
            }else if (tbName.equals("tb_hydrology")){
                List<Hydrology> resList = hydrologyService.selectAverageByDate(param);
                out.print(JsonUtil.toJson(resList));
            }else if (tbName.equals("tb_weather")){
                List<Weather> resList = weatherService.selectAverageByDate(param);
                out.print(JsonUtil.toJson(resList));
            }else if (tbName.equals("tb_yanjiuquwq")){
                List<YanJiuQuWQ> resList = yanJiuQuWQService.selectAverageByDate(param);
                out.print(JsonUtil.toJson(resList));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "rainPlus" ,method = RequestMethod.POST)
    public void selectRainPlus(@RequestBody Map<String,Object> map,HttpServletResponse response){
        try{
            response.setContentType("application/json;charset=utf-8");
            Map<String,Object> param = new HashMap<>();
            PrintWriter out = response.getWriter();
            String tbName = (String) map.get("tbName");
            String cond = (String)map.get("condition");
            System.err.println("========="+cond+"========");
            List<String> dateList = AverageDateUtil.splitDate(map);
            System.err.println(dateList.toString());
            String siteId = (String)map.get("siteId");
            param.put("siteId",siteId);
            param.put("list",dateList);
            param.put("searchDate",cond);
            if(tbName.equals("tb_rain")){
                List<Rain> resList = rainService.selectPlusByDate(param);
                if(resList.size()>0){
                    out.print(JsonUtil.toJson(resList));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

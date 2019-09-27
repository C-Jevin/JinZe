package com.jinze.controller;

import com.jinze.core.PythonProcessFactory;
import com.jinze.core.Result;
import com.jinze.core.ResultGenerator;
import com.jinze.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@Api(value = "linkout", description = "管段结果api", position = 100, protocols = "http")
@RestController
@RequestMapping("/JinZeApi/linkout")
public class HDFLinkOutController {
    private static Logger Log = LoggerFactory.getLogger(HDFLinkOutController.class);

    /**
     * 根据时间和污染物和linkID，查找浓度和流量
     *
     * @param map
     * @return
     */

    @ApiOperation(
            value = "根据管段(linkId),开始结束时间(startTime/endTime),污染物指标(pollutant),查询时间序列",
            notes = "根据管段(linkId),开始结束时间(startTime/endTime),污染物指标(pollutant),查询时间序列",
            produces = "application/json",
            consumes = "application/json")
    @PostMapping("/timeSeries")
    public Result timeSeriesOfLink(@RequestBody Map map) {
        try {
            //异常捕捉
            if (map.isEmpty() || !map.containsKey("linkId") || !map.containsKey("startTime") || !map.containsKey("endTime") || !map.containsKey("pollutant"))
                throw new Exception("json入参为空或不完整");
            if ("".equals(map.get("linkId")))
                throw new Exception("linkId不能为空");
            if ("".equals(map.get("pollutant")))
                throw new Exception("污染物指标不为空");
            if (!"".equals(map.get("startTime")) && !"".equals(map.get("endTime"))) {
                Date sdt = DateUtil.getDateFromStr((String) map.get("startTime"), "yyyy/MM/dd HH:mm:ss");
                Date edt = DateUtil.getDateFromStr((String) map.get("endTime"), "yyyy/MM/dd HH:mm:ss");
                if (edt.before(sdt))
                    throw new Exception("开始时间不能晚于结束时间");
            }else {
                map.put("startTime","0");
                map.put("endTime","0");
            }

            //调用python脚本命令拼接
            StringBuffer arguments = new StringBuffer();
            arguments.append("python D:\\JinZe\\JinZeHdf\\pysrc\\mainFunc.py 1").append(" ")
                    .append("\"").append(map.get("startTime")).append("\"").append(" ")
                    .append("\"").append(map.get("endTime")).append("\"").append(" ")
                    .append(map.get("linkId")).append(" ")
                    .append(map.get("pollutant")).append(" ");
            String[] resList = PythonProcessFactory.pyProcess(arguments);
            List<Map> result = new ArrayList<>();
            List<BigDecimal> dataList = new ArrayList<>();
            //List<BigDecimal> qualList = new ArrayList<>();
            List<String> timeList = new ArrayList<>();
            BigDecimal decimalFormat;
            int index = 0;
            for (String str : resList) {
                index++;
                if (str.equals("DATA"))
                    continue;
                if (str.equals("TIME"))
                    break;
                decimalFormat = new BigDecimal(str);
                dataList.add(decimalFormat);
            }
            for (int i = index; i < resList.length; i++) {
                if (resList[i].equals("TIME"))
                    continue;
                timeList.add(resList[i]);
            }
            for (int i = 0; i < timeList.size(); i++) {
                Map resMap = new HashMap();
                resMap.put("dt", timeList.get(i));
                resMap.put("value", dataList.get(i));
                result.add(resMap);
            }
            return ResultGenerator.genSuccessResult(result);
        } catch (Exception e) {
            e.printStackTrace();
            Log.error(e.getMessage());
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }


    @ApiOperation(
            value = "根据开始结束时间(startTime/endTime),污染物指标(pollutant),查询动画演变序列",
            notes = "开始结束时间(startTime/endTime),污染物指标(pollutant),查询动画演变序列",
            produces = "application/json",
            consumes = "application/json")
    @PostMapping("/animationSeries")
    public Result animationSeriesOfLink(@RequestBody Map map){
        try {
            //异常捕捉
            if (map.isEmpty() || !map.containsKey("startTime") || !map.containsKey("endTime") || !map.containsKey("pollutant"))
                throw new Exception("json入参为空或不完整");
            if ("".equals(map.get("pollutant")))
                throw new Exception("污染物指标不为空");
            if (!"".equals(map.get("startTime")) && !"".equals(map.get("endTime"))) {
                Date sdt = DateUtil.getDateFromStr((String) map.get("startTime"), "yyyy/MM/dd HH:mm:ss");
                Date edt = DateUtil.getDateFromStr((String) map.get("endTime"), "yyyy/MM/dd HH:mm:ss");
                if (edt.before(sdt))
                    throw new Exception("开始时间不能晚于结束时间。");
            }else {
                map.put("startTime","0");
                map.put("endTime","0");
            }

            //调用python脚本命令拼接
            StringBuffer arguments = new StringBuffer();
            arguments.append("python D:\\JinZe\\JinZeHdf\\pysrc\\mainFunc.py 2").append(" ")
                    .append("\"").append(map.get("startTime")).append("\"").append(" ")
                    .append("\"").append(map.get("endTime")).append("\"").append(" ")
                    .append(map.get("pollutant")).append(" ");
            String[] resList = PythonProcessFactory.pyProcess(arguments);
            List<BigDecimal> dataList = new ArrayList<>();
            //List<BigDecimal> qualList = new ArrayList<>();
            List<String> timeList = new ArrayList<>();
            List<String> linkList = new ArrayList<>();
            BigDecimal decimalFormat;
            int index = 0;
            for (String str : resList) {
                index++;
                if (str.equals("LINK"))
                    continue;
                if (str.equals("DATA"))
                    break;
                linkList.add(str);
            }
            for (int i = index; i < resList.length; i++) {
                index++;
                if (resList[i].equals("DATA"))
                    continue;
                if (resList[i].equals("TIME"))
                    break;
                decimalFormat = new BigDecimal(resList[i]);
                dataList.add(decimalFormat);
            }
            for (int i = index; i < resList.length; i++) {
                if (resList[i].equals("TIME"))
                    continue;
                timeList.add(resList[i]);
            }
            Map result = new HashMap();
            int step = dataList.size()/timeList.size();
            int indexof = 0;
            for (int i = 0; i<timeList.size(); i++){
                List<Map> timeMapL = new ArrayList<>();
                for(int j = 0; j<step; j++){
                    Map map1 = new HashMap();
                    map1.put("link", linkList.get(j));
                    map1.put("value", dataList.get(indexof));
                    //map1.put("qual", qualList.get(indexof));
                    timeMapL.add(map1);
                    indexof++;
                }
                result.put(timeList.get(i),timeMapL);
            }
            //System.out.println(dataList.get(447));
            return ResultGenerator.genSuccessResult(result);
        }catch (Exception e){
            e.printStackTrace();
            Log.error(e.getMessage());
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

    @ApiOperation(
            value = "查询管网起始时间和结束时间",
            notes = "根据情景ID(stateid)查询",
            produces = "application/json",
            consumes = "application/json")
    @GetMapping("/getTime")
    public Result getTimeOfLinkOut(@RequestParam Integer stateid){
        try {
            if (stateid==null)
                throw new Exception("情景ID不能为空");
            //调用python脚本命令拼接
            StringBuffer arguments = new StringBuffer();
            arguments.append("python D:\\JinZe\\JinZeHdf\\pysrc\\mainFunc.py 3");
            String[] resList = PythonProcessFactory.pyProcess(arguments);
            Map map = new HashMap();
            map.put("startTime",resList[0]);
            map.put("endTime",resList[1]);
            return  ResultGenerator.genSuccessResult(map);
        }catch (Exception e){
            e.printStackTrace();
            Log.error(e.getMessage());
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }

}

package com.jinze.controller;

import com.jinze.core.PythonProcessFactory;
import com.jinze.core.Result;
import com.jinze.core.ResultGenerator;
import com.jinze.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

@Api(value = "nodeout", description = "节点结果 api", position = 100, protocols = "http")
@RestController
@RequestMapping("/JinZeApi/nodeout")
public class HDFNodeOutController {
    private static Logger Log = LoggerFactory.getLogger(HDFNodeOutController.class);

    /**
     * 根据时间和污染物和nodeID，查找浓度和流量
     *
     * @param map
     * @return
     */

    @ApiOperation(
            value = "根据管段(nodeId),开始结束时间(startTime/endTime),污染物指标(pollutant),查询时间序列",
            notes = "根据管段(nodeId),开始结束时间(startTime/endTime),污染物指标(pollutant),查询时间序列",
            produces = "application/json",
            consumes = "application/json")
    @PostMapping("/timeSeries")
    public Result timeSeriesOfLink(@RequestBody Map map) {
        try {
            //异常捕捉
            if (map.isEmpty() || !map.containsKey("nodeId") || !map.containsKey("startTime") || !map.containsKey("endTime") || !map.containsKey("pollutant"))
                throw new Exception("json入参为空或不完整");
            if ("".equals(map.get("nodeId")))
                throw new Exception("nodeId不能为空");
            if ("".equals(map.get("pollutant")))
                throw new Exception("污染物指标不为空");
            if (!"".equals(map.get("startTime")) && !"".equals(map.get("endTime"))) {
                Date sdt = DateUtil.getDateFromStr((String) map.get("startTime"), "yyyy/MM/dd HH:mm:ss");
                Date edt = DateUtil.getDateFromStr((String) map.get("endTime"), "yyyy/MM/dd HH:mm:ss");
                if (edt.before(sdt))
                    throw new Exception("开始时间不能晚于结束时间.");
            }else {
                map.put("startTime","0");
                map.put("endTime","0");
            }

            //调用python脚本命令拼接
            StringBuffer arguments = new StringBuffer();
            arguments.append("python D:\\JinZe\\JinZeHdf\\pysrc\\mainFunc.py 4").append(" ")
                    .append("\"").append(map.get("startTime")).append("\"").append(" ")
                    .append("\"").append(map.get("endTime")).append("\"").append(" ")
                    .append(map.get("nodeId")).append(" ")
                    .append(map.get("pollutant")).append(" ");
            String[] resList = PythonProcessFactory.pyProcess(arguments);
            List<Map> result = new ArrayList<>();
            List<BigDecimal> dataList = new ArrayList<>();
            List<String> timeList = new ArrayList<>();
            BigDecimal decimalFormat;
            int index = 0;
            for (String str : resList) {
                index++;
                if (str.equals("TIME"))
                    break;
                if (str.equals("DATA"))
                    continue;
                decimalFormat = new BigDecimal(str);
                dataList.add(decimalFormat);
            }
            for (int i = index; i < resList.length; i++) {
                if (resList[i].equals("TIME"))
                    continue;
                timeList.add(resList[i]);
            }
            for (int i = 0; i < timeList.size(); i++) {
                Map<String,Object> resMap = new HashMap<String,Object>();
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
}

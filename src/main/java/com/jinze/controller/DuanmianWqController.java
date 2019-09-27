package com.jinze.controller;

import com.jinze.core.Result;
import com.jinze.core.ResultGenerator;
import com.jinze.entity.DuanMianWq;
import com.jinze.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 数据库基本操作
 */
@Api(value = "水质-断面", description = "水质-断面基础数据操作 API", position = 100, protocols = "http")
@RestController
@RequestMapping("/JinZeApi/duanMian")
public class DuanmianWqController {
    private static Logger Log = LoggerFactory.getLogger(DuanmianWqController.class);
    @Autowired
    private DuanmianWqService duanmianWqService;

    /**
     * 查询表记录总数
     * @param response
     */
   /* @ApiOperation(
            value = "查询表记录总数",
            notes = "根据条件查询表记录总数",
            produces="application/json",
            consumes="application/json")
    @GetMapping(value = "/findCount")
    public Result findCount(HttpServletResponse response){
        try {
            Map<String,Object> map = new HashMap<>();
            Long count = duanmianWqService.selectCount(map);
            System.err.println("========="+count+"========");
            Map<String,Object> res = new HashMap<>();
            res.put("Count",count);
            return ResultGenerator.genSuccessResult(res);
        }catch (Exception e){
            Log.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }*/

    /**
     * 根据ID更新duanmian记录
     * @param duanMianWq
     */
    /*@ApiOperation(
            value = "更新表记录",
            notes = "根据条件更新表记录",
            produces="application/json",
            consumes="application/json")
    @PutMapping(value = "/update")
    public Result update(@RequestBody @ApiParam(name = "更新参数" ,value="传入json格式",required = true) DuanMianWq duanMianWq){
        System.err.println(duanMianWq.toString());
        duanmianWqService.update(duanMianWq);
        System.err.println("更新完成->");
        return ResultGenerator.genSuccessResult();
    }

    *//**
     * 新增一条记录
     * @param duanMianWq
     *//*
    @ApiOperation(
            value = "新增一条表记录",
            notes = "添加一条表记录",
            produces="application/json",
            consumes="application/json")
    @PostMapping(value = "/insert")
    public Result insert(@RequestBody @ApiParam(name = "新增参数" ,value="传入json格式",required = true) DuanMianWq duanMianWq){
        if ("".equals(duanMianWq.getDT())||duanMianWq.getDT()==null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            duanMianWq.setDT(sdf.format(new Date()));
        }
        System.err.println(duanMianWq.toString());
        duanmianWqService.insert(duanMianWq);
        System.err.println("插入完成->");
        return ResultGenerator.genSuccessResult();
    }

    *//**
     * 根据ID删除记录
     * @param id
     *//*
    @ApiOperation(
            value = "删除一条表记录",
            notes = "根据id删除",
            produces="application/json",
            consumes="application/json")
    @DeleteMapping(value = "/{id}")
    public Result deleteById(@PathVariable String id){
        System.err.println("id: "+id);
        duanmianWqService.deleteById(id);
        System.err.println("成功删除ID："+id+"的数据");
        return ResultGenerator.genSuccessResult();
    }

    *//**
     * 批量删除
     * @param list
     *//*
    @ApiOperation(
            value = "批量删除表记录",
            notes = "根据ids删除",
            produces="application/json",
            consumes="application/json")
    @DeleteMapping(value = "deleteByList")
    public Result deleteByList(@RequestBody List<String> list){
        System.err.println(list);
        for (String str:list) {
            System.err.println(str);
        }
        duanmianWqService.deleteByList(list);
        return ResultGenerator.genSuccessResult();
    }
*/
    /*@RequestMapping(value = "averData-one" ,method = RequestMethod.GET)
    public void searchDuanMianAverage(@RequestParam(value = "siteId",required = true,defaultValue = "SZDMP0001") String siteId,
                                      @RequestParam(value = "Dt",required = true,defaultValue = "")String Dt,
                                      @RequestParam(value = "condition",required = true,defaultValue = "Year")String condition,
                                      HttpServletResponse response){
        System.err.println("siteId:"+ siteId+"  "+"Dt:"+Dt +"  "+"condition:"+condition);
        response.setContentType("application/json;charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            Map<String,Object> map = new HashMap<>();
            SimpleDateFormat sdf = null;
            map.put("searchDate",condition);
            map.put("siteId",siteId);
            if (condition.equals("Year")){
                sdf = new SimpleDateFormat("yyyy");
                Date dt = sdf.parse(Dt);
                String strDT = sdf.format(dt);
                System.err.println(strDT);
                map.put("DT",strDT);
            }else if (condition.equals("Month")){
                sdf = new SimpleDateFormat("yyyy-MM");
                Date dt = sdf.parse(Dt);
                String strDT = sdf.format(dt);
                map.put("DT",strDT);
            }else if (condition.equals("Day")){
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dt = sdf.parse(Dt);
                String strDT = sdf.format(dt);
                map.put("DT",strDT);
            }
            //DuanMianWq resList = duanmianWqService.selectAverageByMap(map);
            //out.print(JsonUtil.toJson(resList));
            //System.err.println(resList);
            //System.err.println(resList.size());
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/


}

package com.jinze.controller;

import com.jinze.core.Result;
import com.jinze.core.ResultGenerator;
import com.jinze.entity.GroundWater;
import com.jinze.service.GroundWaterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库基本操作
 */
@Api(value = "地下水", description = "地下水基础数据操作 API", position = 100, protocols = "http")
@RestController
@RequestMapping("/JinZeApi/groundWater")
public class GroundWaterController {
    private static Logger Log = LoggerFactory.getLogger(GroundWaterController.class);
    @Autowired
    private GroundWaterService groundWaterService;

    /**
     * 查询表记录总数
     * @param
     */
    /*@ApiOperation(
            value = "查询表记录总数",
            notes = "根据条件查询表记录总数",
            produces="application/json",
            consumes="application/json")
    @GetMapping(value = "/findCount")
    public Result findCount(){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> res = new HashMap<>();
        res.put("Count",groundWaterService.selectCount(map));
        return ResultGenerator.genSuccessResult(res);
    }*/

    /**
     * 根据ID更新记录
     * @param groundWater
     */
    /*@ApiOperation(
            value = "更新表记录",
            notes = "根据条件更新表记录",
            produces="application/json",
            consumes="application/json")
    @PutMapping(value = "/update")
    public Result update(@RequestBody @ApiParam(name = "更新参数" ,value="传入json格式",required = true) GroundWater groundWater){
        System.err.println(groundWater.toString());
        groundWaterService.update(groundWater);
        System.err.println("更新完成->");
        return  ResultGenerator.genSuccessResult();
    }

    *//**
     * 新增一条记录
     * @param groundWater
     *//*
    @ApiOperation(
            value = "新增一条表记录",
            notes = "添加一条表记录",
            produces="application/json",
            consumes="application/json")
    @PostMapping(value = "/insert")
    public Result insert(@RequestBody @ApiParam(name = "新增参数" ,value="传入json格式",required = true)GroundWater groundWater){
        System.err.println(groundWater.toString());
        groundWaterService.insert(groundWater);
        System.err.println("插入完成->");
        return  ResultGenerator.genSuccessResult();
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
        groundWaterService.deleteById(id);
        System.err.println("成功删除ID："+id+"的数据");
        return  ResultGenerator.genSuccessResult();
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
        groundWaterService.deleteByList(list);
        return  ResultGenerator.genSuccessResult();
    }*/
}

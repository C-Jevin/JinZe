package com.jinze.controller;

import com.jinze.core.Result;
import com.jinze.core.ResultGenerator;
import com.jinze.entity.Hydrology;
import com.jinze.service.HydrologyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "水文", description = "水文数据基础操作 API", position = 100, protocols = "http")
@RestController
@RequestMapping("/JinZeApi/hydrology")
public class HydrologyController {
    private static Logger Log = LoggerFactory.getLogger(HydrologyController.class);
    @Autowired
    private HydrologyService hydrologyService;

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
            Long count = hydrologyService.selectCount(map);
            //System.err.println("========="+count+"========");
            Map<String,Object> res = new HashMap<>();
            res.put("Count",count);
            return ResultGenerator.genSuccessResult(res);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }*/

    /**
     * 根据ID更新hydrology记录
     * @param hydrology
     */
   /* @ApiOperation(
            value = "更新表记录",
            notes = "根据条件更新表记录",
            produces="application/json",
            consumes="application/json")
    @PutMapping(value = "/update")
    public Result update(@RequestBody @ApiParam(name = "更新参数" ,value="传入json格式",required = true) Hydrology hydrology){
        System.err.println(hydrology.toString());
        hydrologyService.update(hydrology);
        System.err.println("更新完成->");
        return  ResultGenerator.genSuccessResult();
    }

    *//**
     * 新增一条记录
     * @param hydrology
     *//*
    @ApiOperation(
            value = "新增一条表记录",
            notes = "添加一条表记录",
            produces="application/json",
            consumes="application/json")
    @PostMapping(value = "/insert")
    public Result insert(@RequestBody @ApiParam(name = "新增参数" ,value="传入json格式",required = true)Hydrology hydrology){
        //JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        // hydrology = (Hydrology) JSONObject.toBean(jsonObject,Hydrology.class);//将前台传来的json字符串转换为json对象
        if ("".equals(hydrology.getDt())||hydrology.getDt()==null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            hydrology.setDt(sdf.format(new Date()));
        }
        System.err.println(hydrology.toString());
        hydrologyService.insert(hydrology);
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
        hydrologyService.deleteById(id);
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
        //JSONArray jsonArray = JSONArray.fromObject(list);
        //ArrayList<String> ls = (A) jsonArray.toArray();
        for (String str:list) {
            System.err.println(str);
        }
        hydrologyService.deleteByList(list);
        return  ResultGenerator.genSuccessResult();
    }
*/

}

package com.jinze.controller;

import com.jinze.core.Result;
import com.jinze.core.ResultGenerator;
import com.jinze.entity.Rain;
import com.jinze.entity.YanJiuQuWQ;
import com.jinze.service.YanJiuQuWQService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库基本操作
 */
@Api(value = "研究区", description = "研究区基础数据操作 API", position = 100, protocols = "http")
@RestController
@RequestMapping("/JinZeApi/yanJiuQu")
public class YanJiuQuWqController {

    private static Logger Log = LoggerFactory.getLogger(YanJiuQuWqController.class);
    @Autowired
    private YanJiuQuWQService yanJiuQuWQService;
    /**
     * 查询表记录总数
     * @param response
     *//*
    @ApiOperation(
            value = "查询表记录总数",
            notes = "根据条件查询表记录总数",
            produces="application/json",
            consumes="application/json")
    @GetMapping(value = "/findCount")
    public Result findCount(HttpServletResponse response){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> res = new HashMap<>();
        res.put("Count",yanJiuQuWQService.selectCount(map));
        return ResultGenerator.genSuccessResult(res);
    }*/

    /**
     * 根据ID更新记录
     * @param yanJiuQuWQ
     */
    /*@ApiOperation(
            value = "更新表记录",
            notes = "根据条件更新表记录",
            produces="application/json",
            consumes="application/json")
    @PutMapping(value = "/update")
    public Result update(@RequestBody @ApiParam(name = "更新参数" ,value="传入json格式",required = true) YanJiuQuWQ yanJiuQuWQ){
        System.err.println(yanJiuQuWQ.toString());
        yanJiuQuWQService.update(yanJiuQuWQ);
        System.err.println("更新完成->");
        return  ResultGenerator.genSuccessResult();
    }

    *//**
     * 新增一条记录
     * @param rain
     *//*
    @ApiOperation(
            value = "新增一条表记录",
            notes = "添加一条表记录",
            produces="application/json",
            consumes="application/json")
    @PostMapping(value = "/insert")
    public Result insert(@RequestBody @ApiParam(name = "新增参数" ,value="传入json格式",required = true)YanJiuQuWQ yanJiuQuWQ){
        try {
            if ("".equals(yanJiuQuWQ.getDt())){
                throw new RuntimeException("时间不能为空！");
            }
            System.err.println(yanJiuQuWQ.toString());
            yanJiuQuWQService.insert(yanJiuQuWQ);
            System.err.println("插入完成->");
            return  ResultGenerator.genSuccessResult();
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult(e.getMessage());
        }
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
        yanJiuQuWQService.deleteById(id);
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
        yanJiuQuWQService.deleteByList(list);
        return  ResultGenerator.genSuccessResult();
    }
*/
}

package com.jinze.controller;

import com.jinze.core.Result;
import com.jinze.core.ResultGenerator;
import com.jinze.entity.Datastate;
import com.jinze.service.DatastateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/09/11.
*/
@Api(value = "情景查询", description = "情景查询 API", position = 100, protocols = "http")
@RestController
@RequestMapping("/JinZeApi/datastate")
public class DatastateController {
    @Resource
    private DatastateService datastateService;

    /*@PostMapping
    public Result add(@RequestBody Datastate datastate) {
        datastateService.save(datastate);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        datastateService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Datastate datastate) {
        datastateService.update(datastate);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Datastate datastate = datastateService.findById(id);
        return ResultGenerator.genSuccessResult(datastate);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Datastate> list = datastateService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }*/
    @ApiOperation(
            value = "查询所有情景名称和情景id(stateid)",
            notes = "查询所有情景名称和情景id(stateid)",
            produces="application/json",
            consumes="application/json")
    @GetMapping()
    public Result allDataState(){
        List<Datastate> resList = datastateService.findAll();
        return ResultGenerator.genSuccessResult(resList);
    }
}

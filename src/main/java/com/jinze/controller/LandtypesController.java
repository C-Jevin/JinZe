package com.jinze.controller;

import com.jinze.core.Result;
import com.jinze.core.ResultGenerator;
import com.jinze.entity.Landtypes;
import com.jinze.service.LandtypesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
* Created by CodeGenerator on 2019/09/16.
*/
@Api(value = "用地类型百分比", description = "用地类型百分比 API", position = 100, protocols = "http")
@RestController
@RequestMapping("/JinZeApi/landtypes")
public class LandtypesController {
    private static Logger Log = LoggerFactory.getLogger(LandtypesController.class);
    @Resource
    private LandtypesService landtypesService;

   /* @PostMapping
    public Result add(@RequestBody Landtypes landtypes) {
        landtypesService.save(landtypes);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        landtypesService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Landtypes landtypes) {
        landtypesService.update(landtypes);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Landtypes landtypes = landtypesService.findById(id);
        return ResultGenerator.genSuccessResult(landtypes);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Landtypes> list = landtypesService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }*/

    @ApiOperation(
            value = "查询用地类型百分比",
            notes = "根据子流域(subid),用地类型查询",
            produces="application/json",
            consumes="application/json")
   @GetMapping()
   public Result usedLandPercentage(@RequestParam("subid") Integer subid , @RequestParam("stateid") Integer stateid){
       try {
           if (subid==null ){
               throw new Exception("子流域id不能为空");
           }
           if (stateid==null){
               throw new Exception("用地类型不能为空");
           }
           Map<String,Object> condiMap = new HashMap<>();
           condiMap.put("subid",subid);
           condiMap.put("stateid",stateid);

           Map result = landtypesService.selectUsedLandPercentage(condiMap);
           //System.out.println(resList.get(0).getJiaotong()/resList.get(0).getTotalland());
           //Map<String , Object> resMap = new HashMap<>();
           Float totalland = (Float) result.get("totalland");
           Set<Map.Entry<String, Float>> entries = result.entrySet();
           Iterator<Map.Entry<String, Float>> it = entries.iterator();
           while (it.hasNext()){
               Map.Entry<String, Float> next = it.next();
               Float oldData = next.getValue();
               next.setValue(oldData/totalland);
               System.out.println(next);
           }

           //resMap.put(landtype,resList.get(0).getJiaotong()/resList.get(0).getTotalland());
           return ResultGenerator.genSuccessResult(result);
       }catch (Exception e){
           e.printStackTrace();
           return ResultGenerator.genFailResult(e.getMessage());
       }

   }


}

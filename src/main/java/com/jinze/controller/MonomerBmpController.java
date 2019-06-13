package com.jinze.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.jinze.core.Result;
import com.jinze.core.ResultGenerator;
import com.jinze.entity.Hydrology;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jinze.entity.MonomerBmp;
import com.jinze.service.MonomerBmpService;

@Api(value = "单体BMP效益评估", description = "单体BMP效益评估 API", position = 100, protocols = "http")
@RestController
@RequestMapping("/JinZeApi/monomerBmp")
public class MonomerBmpController {

	@Autowired
	private MonomerBmpService monomerBmpService;
	/**
	 * 根据以下条件查询效益评估
	 * @param pgType
	 * @param type
	 * @param land
	 * @param bmp
	 */
	@ApiOperation(
			value = "查询效益评估或参数评估",
			notes = "根据条件查询效益评估或参数评估",
			produces="application/json",
			consumes="application/json")
	@GetMapping(value = "/showDataOfMonomerBmp")
	public Result showDataOfMonomerBmp(Integer pgType, String type, String land, String bmp, HttpServletResponse response){
		try {
			System.err.println("=========================="+pgType+" "+type+" "+land+" "+bmp+"=================================");
			// 设置ajax json字符串编码格式
			//response.setContentType("application/json;charset=utf-8");
			// out对象
			//PrintWriter out = response.getWriter();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pgType", pgType);
			map.put("type", type);
			map.put("Land", land);
			map.put("BMP", bmp);
			List<MonomerBmp> list = monomerBmpService.selectMonomerBmp(map);
			List<Map<String, Object>> result = new ArrayList<>();
			for (MonomerBmp monomerBmp : list) {
				Map<String, Object> resMap = new HashMap<>();
				System.err.println(monomerBmp.toString());
				//NumberFormat num = NumberFormat.getPercentInstance();
				resMap.put("RorT", monomerBmp.getRorT());
				resMap.put("AAFV", (int)(monomerBmp.getAAFV()*100));//转换为百分比
				resMap.put("TSS_AAL",(int)(monomerBmp.getTSS_AAL()*100));
				resMap.put("TN_AAL", (int)(monomerBmp.getTN_AAL()*100));
				resMap.put("TP_AAL", (int)(monomerBmp.getTP_AAL()*100));
				result.add(resMap);
			}
			//out.print(JsonUtil.toJson(result));
			return ResultGenerator.genSuccessResult(result);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return  null;
	}

	/**
	 * 查询表记录总数
	 * @param response
	 */
	@ApiOperation(
			value = "查询表记录总数",
			notes = "根据条件查询表记录总数",
			produces="application/json",
			consumes="application/json")
	@GetMapping(value = "/findCount")
	public Result findCount(HttpServletResponse response){
		try {
			Map<String,Object> map = new HashMap<>();
			Map<String,Object> res = new HashMap<>();
			res.put("Count",monomerBmpService.selectCount(map));
			return ResultGenerator.genSuccessResult(res);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据ID更新记录
	 * @param monomerBmp
	 */
	@ApiOperation(
			value = "更新表记录",
			notes = "根据条件更新表记录",
			produces="application/json",
			consumes="application/json")
	@PutMapping(value = "/update")
	public Result update(@RequestBody @ApiParam(name = "更新参数" ,value="传入json格式",required = true) MonomerBmp monomerBmp){
		monomerBmpService.update(monomerBmp);
		System.err.println("更新完成->");
		return  ResultGenerator.genSuccessResult();
	}

	/**
	 * 新增一条记录
	 * @param monomerBmp
	 */
	@ApiOperation(
			value = "新增一条表记录",
			notes = "添加一条表记录",
			produces="application/json",
			consumes="application/json")
	@PostMapping(value = "/insert")
	public Result insert(@RequestBody @ApiParam(name = "新增参数" ,value="传入json格式",required = true)MonomerBmp monomerBmp){
		System.err.println(monomerBmp.toString());
		monomerBmpService.insert(monomerBmp);
		System.err.println("插入完成->");
		return  ResultGenerator.genSuccessResult();
	}

	/**
	 * 根据ID删除记录
	 * @param id
	 */
	@ApiOperation(
			value = "删除一条表记录",
			notes = "根据id删除",
			produces="application/json",
			consumes="application/json")
	@DeleteMapping(value = "/{id}")
	public Result deleteById(@PathVariable String id){
		System.err.println("id: "+id);
		monomerBmpService.deleteById(id);
		System.err.println("成功删除ID："+id+"的数据");
		return  ResultGenerator.genSuccessResult();
	}

	/**
	 * 批量删除
	 * @param list
	 */
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
		monomerBmpService.deleteByList(list);
		return  ResultGenerator.genSuccessResult();
	}

}

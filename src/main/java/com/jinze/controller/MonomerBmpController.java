package com.jinze.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jinze.entity.MonomerBmp;
import com.jinze.service.MonomerBmpService;
import com.jinze.util.JsonUtil;

@RestController
@RequestMapping("monomerBmp")
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
	@RequestMapping(value = "/showDataOfMonomerBmp",method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public void showDataOfMonomerBmp(Integer pgType,String type,String land,String bmp, HttpServletResponse response){
		try {
			System.err.println("=========================="+pgType+" "+type+" "+land+" "+bmp+"=================================");
			// 设置ajax json字符串编码格式
			response.setContentType("application/json;charset=utf-8");
			// out对象
			PrintWriter out = response.getWriter();
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
			out.print(JsonUtil.toJson(result));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

package com.jinze.controller;

import com.jinze.entity.DuanMianWq;
import com.jinze.entity.Hydrology;
import com.jinze.service.HydrologyService;
import com.jinze.util.JsonUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("hydrology")
public class HydrologyController {
    @Autowired
    private HydrologyService hydrologyService;

    /**
     * 查询表记录总数
     * @param response
     */
    @RequestMapping(value = "/findCount",method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public void findCount(HttpServletResponse response){
        try {
            Map<String,Object> map = new HashMap<>();
            Long count = hydrologyService.selectCount(map);
            //System.err.println("========="+count+"========");
            PrintWriter out = response.getWriter();
            Map<String,Object> res = new HashMap<>();
            res.put("Count",count);
            out.print(JsonUtil.toJson(res));
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * 根据ID更新hydrology记录
     * @param hydrology
     * @param response
     */
    @RequestMapping(value = "/update",method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public void update(Hydrology hydrology, HttpServletResponse response){
        System.err.println(hydrology.toString());
        hydrologyService.update(hydrology);
        System.err.println("更新完成->");
    }

    /**
     * 新增一条记录
     * @param jsonStr
     * @param response
     */
    @RequestMapping(value = {"/insert"},method = RequestMethod.POST)
    public void insert(@RequestBody String jsonStr, HttpServletResponse response){
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        Hydrology hydrology = (Hydrology) JSONObject.toBean(jsonObject,Hydrology.class);//将前台传来的json字符串转换为json对象
        if ("".equals(hydrology.getDt())||hydrology.getDt()==null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            hydrology.setDt(sdf.format(new Date()));
        }
        System.err.println(hydrology.toString());
        hydrologyService.insert(hydrology);
        System.err.println("插入完成->");
    }

    /**
     * 根据ID删除记录
     * @param id
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteById(@PathVariable String id){
        System.err.println("id: "+id);
        hydrologyService.deleteById(id);
        System.err.println("成功删除ID："+id+"的数据");
    }

    /**
     * 批量删除
     * @param list
     */
    @RequestMapping(value = "deleteByList" ,method = RequestMethod.DELETE)
    public void deleteByList(@RequestBody List<String> list){

        System.err.println(list);
        //JSONArray jsonArray = JSONArray.fromObject(list);
        //ArrayList<String> ls = (A) jsonArray.toArray();
        for (String str:list) {
            System.err.println(str);
        }
        hydrologyService.deleteByList(list);
    }

    /*@RequestMapping(value = "searchDuanMianAverage" ,method = RequestMethod.GET)
    public void searchHydrologyAverage(@RequestParam(value = "siteId",required = true,defaultValue = "SZDMP0001") String siteId,
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
                //System.err.println(strDT);
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
            Hydrology resList = hydrologyService.selectAverageByMap(map);
            out.print(JsonUtil.toJson(resList));
            System.err.println(resList);
            //System.err.println(resList.size());
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
}

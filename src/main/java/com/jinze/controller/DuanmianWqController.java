package com.jinze.controller;

import com.jinze.entity.DuanMianWq;
import com.jinze.service.*;
import com.jinze.util.AverageDateUtil;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

import com.jinze.util.JsonUtil;

/**
 * 数据库基本操作
 */
@RestController
@RequestMapping("duanmian")
public class DuanmianWqController {
    @Autowired
    private DuanmianWqService duanmianWqService;

    /**
     * 查询表记录总数
     * @param response
     */
    @RequestMapping(value = "/findCount",method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public void findCount(HttpServletResponse response){
        try {
            Map<String,Object> map = new HashMap<>();
            Long count = duanmianWqService.selectCount(map);
            System.err.println("========="+count+"========");
            PrintWriter out = response.getWriter();
            Map<String,Object> res = new HashMap<>();
            res.put("Count",count);
            out.print(JsonUtil.toJson(res));
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * 根据ID更新duanmian记录
     * @param duanMianWq
     * @param response
     */
    @RequestMapping(value = "/update",method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public void update(DuanMianWq duanMianWq, HttpServletResponse response){
        System.err.println(duanMianWq.toString());
        duanmianWqService.update(duanMianWq);
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
        DuanMianWq duanMianWq = (DuanMianWq) JSONObject.toBean(jsonObject,DuanMianWq.class);//将前台传来的json字符串转换为json对象
        if ("".equals(duanMianWq.getDT())||duanMianWq.getDT()==null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            duanMianWq.setDT(sdf.format(new Date()));
        }
        System.err.println(duanMianWq.toString());
        duanmianWqService.insert(duanMianWq);
        System.err.println("插入完成->");
    }

    /**
     * 根据ID删除记录
     * @param id
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteById(@PathVariable String id){
        System.err.println("id: "+id);
        duanmianWqService.deleteById(id);
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
        duanmianWqService.deleteByList(list);
    }

    @RequestMapping(value = "averData-one" ,method = RequestMethod.GET)
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
    }


}

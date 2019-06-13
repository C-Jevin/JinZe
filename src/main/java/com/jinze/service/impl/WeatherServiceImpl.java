package com.jinze.service.impl;

import com.jinze.dao.WeatherDao;
import com.jinze.entity.Weather;
import com.jinze.service.WeatherService;
import com.jinze.util.AverageDateUtil;
import com.jinze.util.EmptySentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private WeatherDao weatherDao;
    public List<Weather> selectWeatherBySiteId(String siteId) {
        return weatherDao.selectWeatherBySiteId(siteId);
    }

    public Long selectCount(Map<String, Object> map) {
        return weatherDao.selectCount(map);
    }

    public void update(Weather weather) {
        weatherDao.update(weather);
    }

    public void deleteById(String id) {
        weatherDao.deleteById(id);
    }

    public void deleteByList(List<String> list) {
        weatherDao.deleteByList(list);
    }

    public void insert(Weather weather) {
        weatherDao.insert(weather);
    }

    public List<Weather> selectAverageByMap(Map<String, Object> map) {
        return null;
    }

    public List<Weather> selectAverageByDate(Map<String, Object> param) {
        List<Weather> sameResult = new ArrayList<>();
        List<Weather> resList = weatherDao.selectAverageByDate(param);
        for (Weather weather : resList){
            System.err.println(weather.toString());
        }
        List<String> dateList = (List<String>) param.get("list");
        String cond = (String)param.get("searchDate");
        for (int i=0;i<dateList.size();i++) {
            String date = dateList.get(i);
            List<Weather> sameDateRes = new ArrayList<>();
            //遍历相同时间段的数据
            for (Weather weather : resList) {
                String strDate = weather.getDt();
                boolean fsame = AverageDateUtil.findSame(cond,strDate,date);
                if (fsame){
                    sameDateRes.add(weather);
                }
            }
            if (sameDateRes.size()>0){
                Double totalRrr = 0d;
                Double totalT = 0d;
                Double totalDd = 0d;
                Double totalFf = 0d;
                Double totalPo = 0d;
                Integer resSize = sameDateRes.size();
                for(Weather wt : sameDateRes){
                    totalRrr+=EmptySentence.judeEmpty(wt.getRRR());
                    totalT+=EmptySentence.judeEmpty(wt.getT());
                    totalDd+=EmptySentence.judeEmpty(wt.getDD());
                    totalFf+=EmptySentence.judeEmpty(wt.getFF());
                    totalPo+=EmptySentence.judeEmpty(wt.getPO());
                }
                Double averRrr = totalRrr/resSize;
                Double averT = totalT/resSize;
                Double averDd = totalDd/resSize;
                Double averFf = totalFf/resSize;
                Double averPo = totalPo/resSize;
                Weather weather = new Weather();
                weather.setRRR(averRrr);
                weather.setDD(averDd);
                weather.setT(averT);
                weather.setFF(averFf);
                weather.setPO(averPo);
                weather.setDt(dateList.get(i));
                weather.setSiteId(sameDateRes.get(0).getSiteId());
                weather.setSiteName(sameDateRes.get(0).getSiteName());
                sameResult.add(weather);
            }
        }

        return sameResult;
    }
}

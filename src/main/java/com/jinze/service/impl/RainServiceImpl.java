package com.jinze.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jinze.entity.YanJiuQuWQ;
import com.jinze.util.AverageDateUtil;
import com.jinze.util.EmptySentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jinze.dao.RainDao;
import com.jinze.entity.Rain;
import com.jinze.service.RainService;

@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
public class RainServiceImpl implements RainService{
	@Autowired
	private RainDao rainDao;
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteId
	 * @return
	 */
	public List<Rain> selectRainBySiteId(String siteId){
		return rainDao.selectRainBySiteId(siteId);
	}

	public Long selectCount(Map<String, Object> map) {
		return rainDao.selectCount(map);
	}

	public void update(Rain rain) {
		rainDao.update(rain);
	}

	public void deleteById(String id) {
		rainDao.deleteById(id);
	}

	public void deleteByList(List<String> list) {
		rainDao.deleteByList(list);
	}

	public void insert(Rain rain) {
		rainDao.insert(rain);
	}

	public List<Rain> selectPlusByDate(Map<String, Object> param) {
		List<Rain> sameResult = new ArrayList<>();
		List<Rain> resList = rainDao.selectPlusByDate(param);
		List<String> dateList = (List<String>) param.get("list");
		String cond = (String)param.get("searchDate");
		for (int i=0;i<dateList.size();i++) {
			String date = dateList.get(i);
			List<Rain> sameDateRes = new ArrayList<>();
			//遍历相同时间段的数据
			for (Rain rain : resList) {
				String strDate = rain.getDt();
				boolean fsame = AverageDateUtil.findSame(cond, strDate, date);
				if (fsame) {
					sameDateRes.add(rain);
				}
			}
			if (sameDateRes.size() > 0) {
				Double totalRainFall = 0d;
				for (Rain rain:sameDateRes){
					totalRainFall+=EmptySentence.judeEmpty(rain.getRainFall()) ;
				}
				Rain rainPlus = new Rain();
				rainPlus.setRainFall(totalRainFall);
				rainPlus.setDt(dateList.get(i));
				rainPlus.setSiteId(sameDateRes.get(0).getSiteId());
				rainPlus.setSiteName(sameDateRes.get(0).getSiteName());
				sameResult.add(rainPlus);
			}
		}
		return sameResult;
	}


}

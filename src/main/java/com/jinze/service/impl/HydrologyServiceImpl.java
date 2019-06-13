package com.jinze.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jinze.entity.DuanMianWq;
import com.jinze.util.AverageDateUtil;
import com.jinze.util.DateUtil;
import com.jinze.util.EmptySentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jinze.dao.HydrologyDao;
import com.jinze.entity.Hydrology;
import com.jinze.service.HydrologyService;
@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
public class HydrologyServiceImpl implements HydrologyService{
	@Autowired
	private HydrologyDao hydrologyDao;
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteId
	 * @return
	 */
	public List<Hydrology> selectHydrologyBySiteId(String siteId){
		return hydrologyDao.selectHydrologyBySiteId(siteId);
	}

	public Long selectCount(Map<String, Object> map) {
		return hydrologyDao.selectCount(map);
	}

	public void update(Hydrology hydrology) {
		hydrologyDao.update(hydrology);
	}

	public void deleteById(String id) {
		hydrologyDao.deleteById(id);
	}

	public void deleteByList(List<String> list) {
		hydrologyDao.deleteByList(list);
	}

	public void insert(Hydrology hydrology) {
		hydrologyDao.insert(hydrology);
	}

	public List<Hydrology> selectAverageByMap(Map<String, Object> map) {
		List<Hydrology> resList = hydrologyDao.selectAverageByMap(map);
		Double totalLevel = 0d;
		int resSize = resList.size();
		for(Hydrology hy : resList){
			totalLevel+=EmptySentence.judeEmpty(hy.getLevel());
		}
		Double averLevel = totalLevel/resSize;
		Hydrology hydrology = new Hydrology();
		hydrology.setLevel(averLevel);
		hydrology.setDt((String)map.get("DT"));
		hydrology.setSiteId(resList.get(0).getSiteId());
		hydrology.setSiteName(resList.get(0).getSiteName());
		resList.add(hydrology);
		return resList;
	}

	public List<Hydrology> selectAverageByDate(Map<String, Object> param) {
		List<Hydrology> sameResult = new ArrayList<>();
		List<Hydrology> resList = hydrologyDao.selectAverageByDate(param);
		List<String> dateList = (List<String>) param.get("list");
		String cond = (String)param.get("searchDate");
		for (int i=0;i<dateList.size();i++) {
			String date = dateList.get(i);
			List<Hydrology> sameDateRes = new ArrayList<>();
			//遍历相同时间段的数据
			for (Hydrology hydrology : resList) {
				String strDate = hydrology.getDt();
				boolean fsame = AverageDateUtil.findSame(cond,strDate,date);
				if (fsame){
					sameDateRes.add(hydrology);
				}
			}
			if (sameDateRes.size()>0){
				Double totalLevel = 0d;
				int resSize = sameDateRes.size();
				for(Hydrology hy : sameDateRes){
					totalLevel+=EmptySentence.judeEmpty(hy.getLevel());
				}
				Double averLevel = totalLevel/resSize;
				Hydrology hydrology = new Hydrology();
				hydrology.setLevel(averLevel);
				hydrology.setDt(dateList.get(i));
				hydrology.setSiteId(sameDateRes.get(0).getSiteId());
				hydrology.setSiteName(sameDateRes.get(0).getSiteName());
				sameResult.add(hydrology);
			}
		}

		return sameResult;
	}
}

package com.jinze.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jinze.util.AverageDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jinze.dao.YanJiuQuWQDao;
import com.jinze.entity.YanJiuQuWQ;
import com.jinze.service.YanJiuQuWQService;

@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
public class YanJiuQuWQServiceImpl implements YanJiuQuWQService{
	@Autowired
	private YanJiuQuWQDao yanJiuQuWQDao;
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteName
	 * @return
	 */
	public List<YanJiuQuWQ> selectYanJiuQuWQBySiteName(String siteName){
		return yanJiuQuWQDao.selectYanJiuQuWQBySiteName(siteName);
	}

	public Long selectCount(Map<String, Object> map) {
		return yanJiuQuWQDao.selectCount(map);
	}

	public void update(YanJiuQuWQ yanJiuQuWQ) {
		yanJiuQuWQDao.update(yanJiuQuWQ);
	}

	public void deleteById(String id) {
		yanJiuQuWQDao.deleteById(id);
	}

	public void deleteByList(List<String> list) {
		yanJiuQuWQDao.deleteByList(list);
	}

	public void insert(YanJiuQuWQ yanJiuQuWQ) {
		yanJiuQuWQDao.insert(yanJiuQuWQ);
	}

	public List<YanJiuQuWQ> selectAverageByMap(Map<String, Object> map) {
		return null;
	}

	public List<YanJiuQuWQ> selectAverageByDate(Map<String, Object> param) {
		List<YanJiuQuWQ> sameResult = new ArrayList<>();
		List<YanJiuQuWQ> resList = yanJiuQuWQDao.selectAverageByDate(param);
		List<String> dateList = (List<String>) param.get("list");
		String cond = (String)param.get("searchDate");
		for (int i=0;i<dateList.size();i++) {
			String date = dateList.get(i);
			List<YanJiuQuWQ> sameDateRes = new ArrayList<>();
			//遍历相同时间段的数据
			for (YanJiuQuWQ yanJiuQuWQ : resList) {
				String strDate = yanJiuQuWQ.getDt();
				boolean fsame = AverageDateUtil.findSame(cond,strDate,date);
				if (fsame){
					sameDateRes.add(yanJiuQuWQ);
				}
			}
			if (sameDateRes.size()>0){
				Double totalNh3_n = 0d;
				Double totalCodmn = 0d;
				Double totalCod = 0d;
				Double totalDo = 0d;
				Double totalBod5 = 0d;
				Double totalTp = 0d;
				int resSize = sameDateRes.size();
				for(YanJiuQuWQ yj : sameDateRes){
					totalNh3_n+=yj.getNH3_N();
					totalCodmn+=yj.getCODmn();
					totalCod+= yj.getCOD();
					totalDo+= yj.getDO();
					totalBod5+= yj.getBOD5();
					totalTp+= yj.getTP();
				}
				Double averNh3_n = totalNh3_n/resSize;
				Double averCodmn = totalCodmn/resSize;
				Double averCod = totalCod/resSize;
				Double averDo = totalDo/resSize;
				Double averBod5 = totalBod5/resSize;
				Double averTp = totalTp/resSize;
				YanJiuQuWQ yanJiuQuWQ = new YanJiuQuWQ();
				yanJiuQuWQ.setNH3_N(averNh3_n);
				yanJiuQuWQ.setCODmn(averCodmn);
				yanJiuQuWQ.setCOD(averCod);
				yanJiuQuWQ.setBOD5(averBod5);
				yanJiuQuWQ.setTP(averTp);
				yanJiuQuWQ.setDO(averDo);
				yanJiuQuWQ.setSiteId(sameDateRes.get(0).getSiteId());
				yanJiuQuWQ.setSiteName(sameDateRes.get(0).getSiteName());
				yanJiuQuWQ.setDt(dateList.get(i));
				sameResult.add(yanJiuQuWQ);
			}
		}

		return sameResult;
	}
}

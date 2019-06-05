package com.jinze.service.impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jinze.util.AverageDateUtil;
import com.jinze.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinze.dao.DuanmianWqDao;
import com.jinze.entity.DuanMianWq;
import com.jinze.service.DuanmianWqService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
public class DuanmianWqServiceImpl implements DuanmianWqService{
	@Autowired
	private DuanmianWqDao duanmianWqDao;
	/**
	 * 根据站点名称查询所有符合条件的数据
	 * @param siteName
	 * @return
	 */
	public List<DuanMianWq> selectDuanmianWqBySiteName(String siteName){
		return duanmianWqDao.selectDuanmianWqBySiteName(siteName);
	}
	/**
	 *根据条件查询表记录总数
	 */
	public Long selectCount(Map<String, Object> map) {
		return duanmianWqDao.selectCount(map);
	}
	/**
	 * 更新表记录
	 */
	public void update(DuanMianWq duanmianWq) {
		duanmianWqDao.update(duanmianWq);
	}
	/**
	 * 删除表记录
	 */
	public void deleteById(String id) {
		duanmianWqDao.deleteById(id);
	}
	/**
	 * 批量删除表记录
	 */
	public void deleteByList(List<String> list) {
		duanmianWqDao.deleteByList(list);
	}
	/**
	 * 新增表记录
	 */
	public void insert(DuanMianWq duanmianWq) {
		duanmianWqDao.insert(duanmianWq);
	}

	/**
	 * 查询某确定时间的日均 月均 年均数据
	 * @param map
	 * @return
	 */
	public List<DuanMianWq> selectAverageByMap(Map<String, Object> map) {
	    List<DuanMianWq> resList = duanmianWqDao.selectAverageByMap(map);
        int resSize = resList.size();
        Double totalDO= 0d;
        Double totalCOD = 0d;
        Double totalNH3_N = 0d;
        Double totalTP = 0d;
        Double totalTN = 0d;
        Double totalNO3_N = 0d;
        Double totalPO4 = 0d;
        Double totalSS = 0d;
        /*for (DuanMianWq dm: resList) {
            totalDO+=dm.getDO();
            totalCOD+=dm.getCOD();
            totalNH3_N+=dm.getNH3_N();
            totalNO3_N+=dm.getNO3_N();
            totalPO4+=dm.getPO4();
            totalTN+=dm.getTN();
            totalTP+=dm.getTP();
            totalSS+=dm.getSS();
        }*/
        Double AverDO= totalDO/resSize;
        Double AverCOD = totalCOD/resSize;
        Double AverNH3_N = totalNH3_N/resSize;
        Double AverTP = totalTP/resSize;
        Double AverTN = totalTN/resSize;
        Double AverNO3_N = totalNO3_N/resSize;
        Double AverPO4 = totalPO4/resSize;
        Double AverSS = totalSS/resSize;
        DuanMianWq duanMianWq = new DuanMianWq();
        duanMianWq.setDO(AverDO);
        duanMianWq.setCOD(AverCOD);
        duanMianWq.setNH3_N(AverNH3_N);
        duanMianWq.setNO3_N(AverNO3_N);
        duanMianWq.setPO4(AverPO4);
        duanMianWq.setTN(AverTN);
        duanMianWq.setTP(AverTP);
        duanMianWq.setSS(AverSS);
        duanMianWq.setSiteId(resList.get(0).getSiteId());
        duanMianWq.setDT((String) map.get("DT"));
        duanMianWq.setSiteName(resList.get(0).getSiteName());
        List<DuanMianWq> result = new ArrayList<>();
        result.add(duanMianWq);
		return resList;
	}

	/**
	 * 计算某时间段内的日均或月均或年均值
	 * @param param
	 * @return
	 */
	public List<DuanMianWq> selectAverageByDate(Map<String,Object> param){
		//List<List> splitResList = new ArrayList<>();
		List<DuanMianWq> sameResult = new ArrayList<>();
		List<DuanMianWq> resList = duanmianWqDao.selectAverageByDate(param);
		/*for (DuanMianWq duanMianWq : resList){
			System.err.println(duanMianWq.toString());
		}*/
		List<String> dateList = (List<String>) param.get("list");
		String cond = (String)param.get("searchDate");
		for (int i=0;i<dateList.size();i++){
			String date = dateList.get(i);
			List<DuanMianWq> sameDateRes = new ArrayList<>();
			//遍历相同时间段的数据
			for(DuanMianWq duanMianWq : resList){
				String strDate = duanMianWq.getDT();
				boolean fsame = AverageDateUtil.findSame(cond,strDate,date);
				if (fsame){
					sameDateRes.add(duanMianWq);
				}
				/*if(cond.equals("Year")){
					Date dateFromStr = DateUtil.getDateFromStr(strDate,"yyyy");
					String strFromDate = DateUtil.getStrFromDate(dateFromStr,"yyyy");
					if (date.equals(strFromDate)){
						sameDateRes.add(duanMianWq);
					}
				}else if (cond.equals("Mon")){
					Date dateFromStr = DateUtil.getDateFromStr(strDate,"yyyy-MM");
					String strFromDate = DateUtil.getStrFromDate(dateFromStr,"yyyy-MM");
					if (date.equals(strFromDate)){
						sameDateRes.add(duanMianWq);
					}
				}else if(cond.equals("Day")){
					Date dateFromStr = DateUtil.getDateFromStr(strDate,"yyyy-MM-dd");
					String strFromDate = DateUtil.getStrFromDate(dateFromStr,"yyyy-MM-dd");
					if (date.equals(strFromDate)){
						sameDateRes.add(duanMianWq);
					}
				}*/
			}

			if (sameDateRes.size()>0){
			//计算平均值
			Double totalDO= 0d;
			Double totalCOD = 0d;
			Double totalNH3_N = 0d;
			Double totalTP = 0d;
			Double totalTN = 0d;
			Double totalNO3_N = 0d;
			Double totalPO4 = 0d;
			Double totalSS = 0d;
			int resSize = sameDateRes.size();
			for(DuanMianWq dmw :sameDateRes){
				totalDO+=dmw.getDO();
				totalCOD+=dmw.getCOD();
				totalNH3_N+=dmw.getNH3_N();
				totalNO3_N+=dmw.getNO3_N();
				totalPO4+=dmw.getPO4();
				totalTN+=dmw.getTN();
				totalTP+=dmw.getTP();
				totalSS+=dmw.getSS();
			}
			Double AverDO= totalDO/resSize;
			Double AverCOD = totalCOD/resSize;
			Double AverNH3_N = totalNH3_N/resSize;
			Double AverTP = totalTP/resSize;
			Double AverTN = totalTN/resSize;
			Double AverNO3_N = totalNO3_N/resSize;
			Double AverPO4 = totalPO4/resSize;
			Double AverSS = totalSS/resSize;
			DuanMianWq duanMianWq = new DuanMianWq();
			duanMianWq.setDO(AverDO);
			duanMianWq.setCOD(AverCOD);
			duanMianWq.setNH3_N(AverNH3_N);
			duanMianWq.setNO3_N(AverNO3_N);
			duanMianWq.setPO4(AverPO4);
			duanMianWq.setTN(AverTN);
			duanMianWq.setTP(AverTP);
			duanMianWq.setSS(AverSS);
			duanMianWq.setSiteId(sameDateRes.get(0).getSiteId());
			duanMianWq.setDT(dateList.get(i));
			duanMianWq.setSiteName(sameDateRes.get(0).getSiteName());
			//封装到List集合
			sameResult.add(duanMianWq);
			//splitResList.add(sameResult);
			}
		}
		return sameResult;
	}
}

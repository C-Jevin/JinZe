package com.jinze.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author JackVan
 *
 */

public class Weather implements Serializable{
	private static final long serialVersionUID = 2139044733063224162L;
	private String ID;//序号
	private String siteId;//站点ID
	private String siteName;//站点名称
	private String Dt;//时间
	private Double RRR;//降雨
	private Double T;//气温
	private Double DD;//风向
	private Double FF;//风速
	private Double PO;//气压
	//生成getter&setter方法
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getDt() {
		return Dt;
	}
	public void setDt(String dt) {
		Dt = dt;
	}
	public Double getRRR() {
		return RRR;
	}
	public void setRRR(Double rRR) {
		RRR = rRR;
	}
	public Double getT() {
		return T;
	}
	public void setT(Double t) {
		T = t;
	}
	public Double getDD() {
		return DD;
	}
	public void setDD(Double dD) {
		DD = dD;
	}
	public Double getFF() {
		return FF;
	}
	public void setFF(Double fF) {
		FF = fF;
	}
	public Double getPO() {
		return PO;
	}
	public void setPO(Double PO) {
		this.PO = PO;
	}

	@Override
	public String toString() {
		return "Weather{" +
				"ID='" + ID + '\'' +
				", siteId='" + siteId + '\'' +
				", siteName='" + siteName + '\'' +
				", Dt='" + Dt + '\'' +
				", RRR=" + RRR +
				", T=" + T +
				", DD=" + DD +
				", FF=" + FF +
				", PO=" + PO +
				'}';
	}
}

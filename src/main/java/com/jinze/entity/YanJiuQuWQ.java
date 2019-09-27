package com.jinze.entity;

import java.io.Serializable;

public class YanJiuQuWQ implements Serializable{
	private static final long serialVersionUID = 5047693855225747610L;
	private String ID;//序号
	private String siteId;//站点ID
	private String siteName;//站点名称
	private String Dt;//时间
	private Double NH3_N;//氨氮
	private Double CODmn;//高锰酸盐指数
	private Double COD;//化学需氧量
	private Double DO;//溶解氧
	private Double BOD5;//五日生化需氧量
	private Double TP;//总磷
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
	public Double getNH3_N() {
		return NH3_N;
	}
	public void setNH3_N(Double nH3_N) {
		NH3_N = nH3_N;
	}
	public Double getCODmn() {
		return CODmn;
	}
	public void setCODmn(Double cODmn) {
		CODmn = cODmn;
	}
	public Double getCOD() {
		return COD;
	}
	public void setCOD(Double cOD) {
		COD = cOD;
	}
	public Double getDO() {
		return DO;
	}
	public void setDO(Double dO) {
		DO = dO;
	}
	public Double getBOD5() {
		return BOD5;
	}
	public void setBOD5(Double bOD5) {
		BOD5 = bOD5;
	}
	public Double getTP() {
		return TP;
	}
	public void setTP(Double tP) {
		TP = tP;
	}

	@Override
	public String toString() {
		return "YanJiuQuWQ{" +
				"ID='" + ID + '\'' +
				", siteId='" + siteId + '\'' +
				", siteName='" + siteName + '\'' +
				", Dt='" + Dt + '\'' +
				", NH3_N=" + NH3_N +
				", CODmn=" + CODmn +
				", COD=" + COD +
				", DO=" + DO +
				", BOD5=" + BOD5 +
				", TP=" + TP +
				'}';
	}
}

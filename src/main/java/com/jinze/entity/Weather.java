package com.jinze.entity;

import java.io.Serializable;
/**
 * 
 * @author JackVan
 *
 */
public class Weather implements Serializable{
	private String ID;//序号
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
	public void setPO(Double pO) {
		PO = pO;
	}
	//生成tostring方法
	@Override
	public String toString() {
		return "Weather [ID=" + ID + ", siteName=" + siteName + ", Dt=" + Dt + ", RRR=" + RRR + ", T=" + T + ", DD="
				+ DD + ", FF=" + FF + ", PO=" + PO + "]";
	}
}

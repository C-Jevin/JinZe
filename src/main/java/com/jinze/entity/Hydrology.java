package com.jinze.entity;

import java.io.Serializable;
/**
 * 水文
 * @author JackVan
 *
 */
public class Hydrology implements Serializable{
	private String ID;//序号
	private String siteName;//站点名称
	private String Dt;//时间
	private double level;//水位
	//生成setter&getter方法
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
	public double getLevel() {
		return level;
	}
	public void setLevel(double level) {
		this.level = level;
	}
	@Override
	//生成tostring方法
	public String toString() {
		return "Hydrology [ID=" + ID + ", siteName=" + siteName + ", Dt=" + Dt + ", level=" + level + "]";
	}
}

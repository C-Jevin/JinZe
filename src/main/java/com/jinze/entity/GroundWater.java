package com.jinze.entity;

import java.io.Serializable;
/**
 * 地下水
 * @author JackVan
 *
 */
public class GroundWater implements Serializable{
	private String ID;//序号
	private String siteName;//站点名称
	private Integer type;//1、平水年；2、丰水年；3、枯水年
	private Double DXSMS;//地下水埋深
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Double getDXSMS() {
		return DXSMS;
	}
	public void setDXSMS(Double dXSMS) {
		DXSMS = dXSMS;
	}
	//生成tostring的方法
	@Override
	public String toString() {
		return "GroundWater [ID=" + ID + ", siteName=" + siteName + ", type=" + type + ", DXSMS=" + DXSMS + "]";
	}
}

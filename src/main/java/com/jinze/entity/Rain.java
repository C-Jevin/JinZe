package com.jinze.entity;

import java.io.Serializable;
/**
 * 降雨
 * @author JackVan
 *
 */
public class Rain implements Serializable{
	private String ID;//序号
	private String siteId;//站点ID
	private String siteName;//站点名称
	private String Dt;//时间
	private Double RainFall;//降雨
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

	public Double getRainFall() {
		return RainFall;
	}

	public void setRainFall(Double rainFall) {
		RainFall = rainFall;
	}

	@Override
	public String toString() {
		return "Rain{" +
				"ID='" + ID + '\'' +
				", siteId='" + siteId + '\'' +
				", siteName='" + siteName + '\'' +
				", Dt='" + Dt + '\'' +
				", RainFall=" + RainFall +
				'}';
	}
}

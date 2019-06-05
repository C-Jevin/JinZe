package com.jinze.entity;


import java.io.Serializable;

/**
 * 水质断面
 * @author JackVan
 */
public class DuanMianWq implements Serializable{
	private String ID;//编号
	private String siteId;//站点ID
	private String siteName;//站点名称
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String DT;//时间
	private Double DO;//溶解氧
	private Double COD;//化学需氧量
	private Double NH3_N;//氨氮
	private Double TP;//总磷
	private Double TN;//总氮
	private Double NO3_N;//硝酸盐氮
	private Double PO4;//磷酸盐
	private Double SS;//悬浮物

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

	public String getDT() {
		return DT;
	}

	public void setDT(String dt) {
		DT = dt;
	}

	public Double getDO() {
		return DO;
	}

	public void setDO(Double dO) {
		DO = dO;
	}

	public Double getCOD() {
		return COD;
	}

	public void setCOD(Double cOD) {
		COD = cOD;
	}

	public Double getNH3_N() {
		return NH3_N;
	}

	public void setNH3_N(Double nH3_N) {
		NH3_N = nH3_N;
	}

	public Double getTP() {
		return TP;
	}

	public void setTP(Double tP) {
		TP = tP;
	}

	public Double getTN() {
		return TN;
	}

	public void setTN(Double tN) {
		TN = tN;
	}

	public Double getNO3_N() {
		return NO3_N;
	}

	public void setNO3_N(Double nO3_N) {
		NO3_N = nO3_N;
	}

	public Double getPO4() {
		return PO4;
	}

	public void setPO4(Double pO4) {
		PO4 = pO4;
	}

	public Double getSS() {
		return SS;
	}

	public void setSS(Double sS) {
		SS = sS;
	}
	@Override
	public String toString() {
		return "DuanMianWq{" +
				"ID='" + ID + '\'' +
				", siteId='" + siteId + '\'' +
				", siteName='" + siteName + '\'' +
				", DT='" + DT + '\'' +
				", DO=" + DO +
				", COD=" + COD +
				", NH3_N=" + NH3_N +
				", TP=" + TP +
				", TN=" + TN +
				", NO3_N=" + NO3_N +
				", PO4=" + PO4 +
				", SS=" + SS +
				'}';
	}
}

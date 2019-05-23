package com.jinze.entity;

import java.io.Serializable;

public class MonomerBmp implements Serializable{
	private String ID;//序号
	private Integer pgType;//评估类别 1-效益评估，2-参数优化评估
	private String type;//类型
	private String Land;//用地类型或情景
	private String BMP;//BMP或过滤型厚度
	private Double RorT;//占汇水区面积比例或厚度
	private Double AAFV;//AAFV消减百分比
	private Double TSS_AAL;//TSS_AAL消减百分比
	private Double TN_AAL;//TN_AAL消减百分比
	private Double TP_AAL;//TP_AAL消减百分比
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Integer getPgType() {
		return pgType;
	}
	public void setPgType(Integer pgType) {
		this.pgType = pgType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLand() {
		return Land;
	}
	public void setLand(String land) {
		Land = land;
	}
	public String getBMP() {
		return BMP;
	}
	public void setBMP(String bMP) {
		BMP = bMP;
	}
	public Double getRorT() {
		return RorT;
	}
	public void setRorT(Double rorT) {
		RorT = rorT;
	}
	public Double getAAFV() {
		return AAFV;
	}
	public void setAAFV(Double aAFV) {
		AAFV = aAFV;
	}
	public Double getTSS_AAL() {
		return TSS_AAL;
	}
	public void setTSS_AAL(Double tSS_AAL) {
		TSS_AAL = tSS_AAL;
	}
	public Double getTN_AAL() {
		return TN_AAL;
	}
	public void setTN_AAL(Double tN_AAL) {
		TN_AAL = tN_AAL;
	}
	public Double getTP_AAL() {
		return TP_AAL;
	}
	public void setTP_AAL(Double tP_AAL) {
		TP_AAL = tP_AAL;
	}
	@Override
	public String toString() {
		return "MonomerBmp [ID=" + ID + ", pgType=" + pgType + ", type=" + type + ", Land=" + Land + ", BMP=" + BMP
				+ ", RorT=" + RorT + ", AAFV=" + AAFV + ", TSS_AAL=" + TSS_AAL + ", TN_AAL=" + TN_AAL + ", TP_AAL="
				+ TP_AAL + "]";
	}
	
}

package com.jinze.entity;

/**
 * 查询条件实体类
 */
public class SearchCond {
    private String siteId;//站点ID
    private String tbName;//表名
    private String startTime;//开始时间
    private String endTime;//结束时间
    private String condition;//查询年均、月均、日均等（Year/Mon/Day）

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getTbName() {
        return tbName;
    }

    public void setTbName(String tbName) {
        this.tbName = tbName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "SearchCond{" +
                "siteId='" + siteId + '\'' +
                ", tbName='" + tbName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}

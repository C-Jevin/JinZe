package com.jinze.entity;

public class Site {
    private Integer id;
    private String siteId;
    private String siteName;
    private String tbName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTbName() {
        return tbName;
    }

    public void setTbName(String tbName) {
        this.tbName = tbName;
    }

    @Override
    public String toString() {
        return "Site{" +
                "id=" + id +
                ", siteId='" + siteId + '\'' +
                ", siteName='" + siteName + '\'' +
                ", tbName='" + tbName + '\'' +
                '}';
    }
}

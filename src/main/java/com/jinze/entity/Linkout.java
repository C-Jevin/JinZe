package com.jinze.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Linkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 情景ID
     */
    private Integer stateid;

    /**
     * 时间
     */
    private Date dt;

    /**
     * 管段ID
     */
    private String link;

    /**
     * 流量
     */
    private BigDecimal flow;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取情景ID
     *
     * @return stateid - 情景ID
     */
    public Integer getStateid() {
        return stateid;
    }

    /**
     * 设置情景ID
     *
     * @param stateid 情景ID
     */
    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    /**
     * 获取时间
     *
     * @return dt - 时间
     */
    public Date getDt() {
        return dt;
    }

    /**
     * 设置时间
     *
     * @param dt 时间
     */
    public void setDt(Date dt) {
        this.dt = dt;
    }

    /**
     * 获取管段ID
     *
     * @return link - 管段ID
     */
    public String getLink() {
        return link;
    }

    /**
     * 设置管段ID
     *
     * @param link 管段ID
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 获取流量
     *
     * @return flow - 流量
     */
    public BigDecimal getFlow() {
        return flow;
    }

    /**
     * 设置流量
     *
     * @param flow 流量
     */
    public void setFlow(BigDecimal flow) {
        this.flow = flow;
    }
}
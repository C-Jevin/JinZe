package com.jinze.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Linkoutqual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer stateid;

    private Date dt;

    private String link;

    private String pollutant;

    private BigDecimal qual;

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
     * @return stateid
     */
    public Integer getStateid() {
        return stateid;
    }

    /**
     * @param stateid
     */
    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    /**
     * @return dt
     */
    public Date getDt() {
        return dt;
    }

    /**
     * @param dt
     */
    public void setDt(Date dt) {
        this.dt = dt;
    }

    /**
     * @return link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return pollutant
     */
    public String getPollutant() {
        return pollutant;
    }

    /**
     * @param pollutant
     */
    public void setPollutant(String pollutant) {
        this.pollutant = pollutant;
    }

    /**
     * @return qual
     */
    public BigDecimal getQual() {
        return qual;
    }

    /**
     * @param qual
     */
    public void setQual(BigDecimal qual) {
        this.qual = qual;
    }
}
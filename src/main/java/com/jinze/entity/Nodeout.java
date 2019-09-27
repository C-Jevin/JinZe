package com.jinze.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Nodeout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer stateid;

    private Date dt;

    private String node;

    private BigDecimal head;

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
     * @return node
     */
    public String getNode() {
        return node;
    }

    /**
     * @param node
     */
    public void setNode(String node) {
        this.node = node;
    }

    /**
     * @return head
     */
    public BigDecimal getHead() {
        return head;
    }

    /**
     * @param head
     */
    public void setHead(BigDecimal head) {
        this.head = head;
    }
}
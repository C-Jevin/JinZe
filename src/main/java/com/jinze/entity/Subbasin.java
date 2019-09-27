package com.jinze.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
@Table(name = "subbasin")
public class Subbasin  implements Serializable {
    private static final long serialVersionUID = 735655488285535299L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 子流域id
     */
    private Integer subid;

    /**
     * 数据状态
     */
    private Integer stateid;

    /**
     * 时间
     */
    private Date dt;

    /**
     * 流量（m3/s）
     */
    @Column(name = "RO")
    private BigDecimal ro;

    /**
     * NH4 (mg/l )
     */
    @Column(name = "NH4")
    private BigDecimal nh4;

    /**
     * TN (mg/l)
     */
    @Column(name = "TN")
    private BigDecimal tn;

    /**
     * TP  (mg/l)
     */
    @Column(name = "TP")
    private BigDecimal tp;

    /**
     * COD (mg/l)
     */
    @Column(name = "COD")
    private BigDecimal cod;

    /**
     * TSS (mg/l)
     */
    @Column(name = "TSS")
    private BigDecimal tss;

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
     * 获取子流域id
     *
     * @return subid - 子流域id
     */
    public Integer getSubid() {
        return subid;
    }

    /**
     * 设置子流域id
     *
     * @param subid 子流域id
     */
    public void setSubid(Integer subid) {
        this.subid = subid;
    }

    /**
     * 获取数据状态
     *
     * @return stateid - 数据状态
     */
    public Integer getStateid() {
        return stateid;
    }

    /**
     * 设置数据状态
     *
     * @param stateid 数据状态
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
     * 获取流量（m3/s）
     *
     * @return RO - 流量（m3/s）
     */
    public BigDecimal getRo() {
        return ro;
    }

    /**
     * 设置流量（m3/s）
     *
     * @param ro 流量（m3/s）
     */
    public void setRo(BigDecimal ro) {
        this.ro = ro;
    }

    /**
     * 获取NH4 (mg/l )
     *
     * @return NH4 - NH4 (mg/l )
     */
    public BigDecimal getNh4() {
        return nh4;
    }

    /**
     * 设置NH4 (mg/l )
     *
     * @param nh4 NH4 (mg/l )
     */
    public void setNh4(BigDecimal nh4) {
        this.nh4 = nh4;
    }

    /**
     * 获取TN (mg/l)
     *
     * @return TN - TN (mg/l)
     */
    public BigDecimal getTn() {
        return tn;
    }

    /**
     * 设置TN (mg/l)
     *
     * @param tn TN (mg/l)
     */
    public void setTn(BigDecimal tn) {
        this.tn = tn;
    }

    /**
     * 获取TP  (mg/l)
     *
     * @return TP - TP  (mg/l)
     */
    public BigDecimal getTp() {
        return tp;
    }

    /**
     * 设置TP  (mg/l)
     *
     * @param tp TP  (mg/l)
     */
    public void setTp(BigDecimal tp) {
        this.tp = tp;
    }

    /**
     * 获取COD (mg/l)
     *
     * @return COD - COD (mg/l)
     */
    public BigDecimal getCod() {
        return cod;
    }

    /**
     * 设置COD (mg/l)
     *
     * @param cod COD (mg/l)
     */
    public void setCod(BigDecimal cod) {
        this.cod = cod;
    }

    /**
     * 获取TSS (mg/l)
     *
     * @return TSS - TSS (mg/l)
     */
    public BigDecimal getTss() {
        return tss;
    }

    /**
     * 设置TSS (mg/l)
     *
     * @param tss TSS (mg/l)
     */
    public void setTss(BigDecimal tss) {
        this.tss = tss;
    }
}
package com.jinze.entity;

import javax.persistence.*;
import java.io.Serializable;

public class Landtypes implements Serializable {
    private static final long serialVersionUID = 1740189563104367515L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 子流域id
     */
    private Integer subid;

    /**
     * 工业仓储用地 单位：m2
     */
    private Float gongyecc;

    /**
     * 居住用地
     */
    private Float juzhu;

    /**
     * 公共建筑用地或市政工程用地
     */
    private Float ggjzszgc;

    /**
     * 交通用地
     */
    private Float jiaotong;

    /**
     * 水产养殖
     */
    private Float shuichanyz;

    /**
     * 河流湖泊水库
     */
    private Float heliuhuposk;

    /**
     * 在建或待建用地
     */
    private Float zaijiandaijian;

    /**
     * 林地绿地
     */
    private Float lindilvdi;

    /**
     * 耕地
     */
    private Float gengdi;

    /**
     * 总面积
     */
    private Float totalland;

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
     * 获取工业仓储用地 单位：m2
     *
     * @return gongyecc - 工业仓储用地 单位：m2
     */
    public Float getGongyecc() {
        return gongyecc;
    }

    /**
     * 设置工业仓储用地 单位：m2
     *
     * @param gongyecc 工业仓储用地 单位：m2
     */
    public void setGongyecc(Float gongyecc) {
        this.gongyecc = gongyecc;
    }

    /**
     * 获取居住用地
     *
     * @return juzhu - 居住用地
     */
    public Float getJuzhu() {
        return juzhu;
    }

    /**
     * 设置居住用地
     *
     * @param juzhu 居住用地
     */
    public void setJuzhu(Float juzhu) {
        this.juzhu = juzhu;
    }

    /**
     * 获取公共建筑用地或市政工程用地
     *
     * @return ggjzszgc - 公共建筑用地或市政工程用地
     */
    public Float getGgjzszgc() {
        return ggjzszgc;
    }

    /**
     * 设置公共建筑用地或市政工程用地
     *
     * @param ggjzszgc 公共建筑用地或市政工程用地
     */
    public void setGgjzszgc(Float ggjzszgc) {
        this.ggjzszgc = ggjzszgc;
    }

    /**
     * 获取交通用地
     *
     * @return jiaotong - 交通用地
     */
    public Float getJiaotong() {
        return jiaotong;
    }

    /**
     * 设置交通用地
     *
     * @param jiaotong 交通用地
     */
    public void setJiaotong(Float jiaotong) {
        this.jiaotong = jiaotong;
    }

    /**
     * 获取水产养殖
     *
     * @return shuichanyz - 水产养殖
     */
    public Float getShuichanyz() {
        return shuichanyz;
    }

    /**
     * 设置水产养殖
     *
     * @param shuichanyz 水产养殖
     */
    public void setShuichanyz(Float shuichanyz) {
        this.shuichanyz = shuichanyz;
    }

    /**
     * 获取河流湖泊水库
     *
     * @return heliuhuposk - 河流湖泊水库
     */
    public Float getHeliuhuposk() {
        return heliuhuposk;
    }

    /**
     * 设置河流湖泊水库
     *
     * @param heliuhuposk 河流湖泊水库
     */
    public void setHeliuhuposk(Float heliuhuposk) {
        this.heliuhuposk = heliuhuposk;
    }

    /**
     * 获取在建或待建用地
     *
     * @return zaijiandaijian - 在建或待建用地
     */
    public Float getZaijiandaijian() {
        return zaijiandaijian;
    }

    /**
     * 设置在建或待建用地
     *
     * @param zaijiandaijian 在建或待建用地
     */
    public void setZaijiandaijian(Float zaijiandaijian) {
        this.zaijiandaijian = zaijiandaijian;
    }

    /**
     * 获取林地绿地
     *
     * @return lindilvdi - 林地绿地
     */
    public Float getLindilvdi() {
        return lindilvdi;
    }

    /**
     * 设置林地绿地
     *
     * @param lindilvdi 林地绿地
     */
    public void setLindilvdi(Float lindilvdi) {
        this.lindilvdi = lindilvdi;
    }

    /**
     * 获取耕地
     *
     * @return gengdi - 耕地
     */
    public Float getGengdi() {
        return gengdi;
    }

    /**
     * 设置耕地
     *
     * @param gengdi 耕地
     */
    public void setGengdi(Float gengdi) {
        this.gengdi = gengdi;
    }

    /**
     * 获取总面积
     *
     * @return totalland - 总面积
     */
    public Float getTotalland() {
        return totalland;
    }

    /**
     * 设置总面积
     *
     * @param totalland 总面积
     */
    public void setTotalland(Float totalland) {
        this.totalland = totalland;
    }
}
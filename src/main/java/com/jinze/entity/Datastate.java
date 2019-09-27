package com.jinze.entity;

import javax.persistence.*;
import java.io.Serializable;

public class Datastate implements Serializable {

    private static final long serialVersionUID = -8671339714554951679L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer stateid;

    private String name;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
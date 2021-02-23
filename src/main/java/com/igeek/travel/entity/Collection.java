package com.igeek.travel.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author yl
 * @Date 2021/2/22 16:01
 */
public class Collection {
    private Map<String,Commodity> map = new HashMap<>();


    public Collection() {
    }

    public Collection(Map<String, Commodity> map) {
        this.map = map;
    }

    /**
     * 获取
     * @return map
     */
    public Map<String, Commodity> getMap() {
        return map;
    }

    /**
     * 设置
     * @param map
     */
    public void setMap(Map<String, Commodity> map) {
        this.map = map;
    }

    public String toString() {
        return "Collection{map = " + map + "}";
    }
}
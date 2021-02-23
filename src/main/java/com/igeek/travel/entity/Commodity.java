package com.igeek.travel.entity;

import java.util.Date;

/**
 * @Description 旅游商品实体类
 * @Author yl
 * @Date 2021/1/31 20:22
 */
public class Commodity {
    private String rid;            //商品编号
    private String rname;          //商品名称
    private Double price;          //价格
    private String routeIntroduce; //商品描述
    private String rflag;
    private String rdate;          //上架日期
    private String rThemeTour;     //主题旅游
    private int count;             //商品数量
    private int cid;
    private String rimage;         //商品图片
    private int sid;
    private String sourceId;


    public Commodity() {
    }

    public Commodity(String rid, String rname, Double price, String routeIntroduce, String rflag, String rdate, String rThemeTour, int count, int cid, String rimage, int sid, String sourceId) {
        this.rid = rid;
        this.rname = rname;
        this.price = price;
        this.routeIntroduce = routeIntroduce;
        this.rflag = rflag;
        this.rdate = rdate;
        this.rThemeTour = rThemeTour;
        this.count = count;
        this.cid = cid;
        this.rimage = rimage;
        this.sid = sid;
        this.sourceId = sourceId;
    }

    /**
     * 获取
     * @return rid
     */
    public String getRid() {
        return rid;
    }

    /**
     * 设置
     * @param rid
     */
    public void setRid(String rid) {
        this.rid = rid;
    }

    /**
     * 获取
     * @return rname
     */
    public String getRname() {
        return rname;
    }

    /**
     * 设置
     * @param rname
     */
    public void setRname(String rname) {
        this.rname = rname;
    }

    /**
     * 获取
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取
     * @return routeIntroduce
     */
    public String getRouteIntroduce() {
        return routeIntroduce;
    }

    /**
     * 设置
     * @param routeIntroduce
     */
    public void setRouteIntroduce(String routeIntroduce) {
        this.routeIntroduce = routeIntroduce;
    }

    /**
     * 获取
     * @return rflag
     */
    public String getRflag() {
        return rflag;
    }

    /**
     * 设置
     * @param rflag
     */
    public void setRflag(String rflag) {
        this.rflag = rflag;
    }

    /**
     * 获取
     * @return rdate
     */
    public String getRdate() {
        return rdate;
    }

    /**
     * 设置
     * @param rdate
     */
    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    /**
     * 获取
     * @return rThemeTour
     */
    public String getRThemeTour() {
        return rThemeTour;
    }

    /**
     * 设置
     * @param rThemeTour
     */
    public void setRThemeTour(String rThemeTour) {
        this.rThemeTour = rThemeTour;
    }

    /**
     * 获取
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * 获取
     * @return cid
     */
    public int getCid() {
        return cid;
    }

    /**
     * 设置
     * @param cid
     */
    public void setCid(int cid) {
        this.cid = cid;
    }

    /**
     * 获取
     * @return rimage
     */
    public String getRimage() {
        return rimage;
    }

    /**
     * 设置
     * @param rimage
     */
    public void setRimage(String rimage) {
        this.rimage = rimage;
    }

    /**
     * 获取
     * @return sid
     */
    public int getSid() {
        return sid;
    }

    /**
     * 设置
     * @param sid
     */
    public void setSid(int sid) {
        this.sid = sid;
    }

    /**
     * 获取
     * @return sourceId
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 设置
     * @param sourceId
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String toString() {
        return "Commodity{rid = " + rid + ", rname = " + rname + ", price = " + price + ", routeIntroduce = " + routeIntroduce + ", rflag = " + rflag + ", rdate = " + rdate + ", rThemeTour = " + rThemeTour + ", count = " + count + ", cid = " + cid + ", rimage = " + rimage + ", sid = " + sid + ", sourceId = " + sourceId + "}";
    }
}
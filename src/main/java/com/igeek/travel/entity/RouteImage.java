package com.igeek.travel.entity;

/**
 * @Description TODO
 * @Author yl
 * @Date 2021/2/22 21:01
 */
public class RouteImage {
    private int rgid;
    private int rid;
    private String bigPic;
    private String smallPic;


    public RouteImage() {
    }

    public RouteImage(int rgid, int rid, String bigPic, String smallPic) {
        this.rgid = rgid;
        this.rid = rid;
        this.bigPic = bigPic;
        this.smallPic = smallPic;
    }

    /**
     * 获取
     * @return rgid
     */
    public int getRgid() {
        return rgid;
    }

    /**
     * 设置
     * @param rgid
     */
    public void setRgid(int rgid) {
        this.rgid = rgid;
    }

    /**
     * 获取
     * @return rid
     */
    public int getRid() {
        return rid;
    }

    /**
     * 设置
     * @param rid
     */
    public void setRid(int rid) {
        this.rid = rid;
    }

    /**
     * 获取
     * @return bigPic
     */
    public String getBigPic() {
        return bigPic;
    }

    /**
     * 设置
     * @param bigPic
     */
    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    /**
     * 获取
     * @return smallPic
     */
    public String getSmallPic() {
        return smallPic;
    }

    /**
     * 设置
     * @param smallPic
     */
    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    public String toString() {
        return "RouteImage{rgid = " + rgid + ", rid = " + rid + ", bigPic = " + bigPic + ", smallPic = " + smallPic + "}";
    }
}
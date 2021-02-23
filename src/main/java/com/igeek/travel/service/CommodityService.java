package com.igeek.travel.service;

import com.igeek.travel.dao.CommodityDao;
import com.igeek.travel.entity.Commodity;
import com.igeek.travel.vo.PageVo;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author yl
 * @Date 2021/1/31 21:31
 */
public class CommodityService {

    private CommodityDao dao = new CommodityDao();

    public List<Commodity> viewHot(){
        try {
            return dao.selectHot();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Commodity> viewNew(){
        try {
            return dao.selectNew();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Commodity> viewThemeTour(){
        try {
            return dao.selectThemeTour();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Commodity> viewAbroad(){
        try {
            return dao.selectAbroad();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Commodity> viewDomestic(){
        try {
            return dao.selectDomestic();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //查询商品列表
    public PageVo<Commodity> viewProductsByCidPname(String rid,String rname,Integer pageNow){
        PageVo<Commodity> vo = null;
        try {
            //获得总记录数
            int counts = dao.selectCounts(rid, rname);

            //计算总页数
            int myPages = (int)(counts%8==0?counts/8:Math.ceil(counts/8.0));

            //计算出起始值
            int begin = (pageNow-1)*8;

            //查询数据
            List<Commodity> productList = dao.selectCommodity(rid, rname, begin);

            //封装PageVO
            vo = new PageVo<>(rid,rname,pageNow,myPages,productList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vo;
    }

    //查询具体商品
    public Commodity viewCommodityByrid(String rid){
        Commodity commodity = null;
        try {
            commodity =  dao.selectCommodityByrid(rid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commodity;
    }


}
package com.igeek.travel.service;

import com.igeek.travel.dao.CommodityDao;
import com.igeek.travel.entity.Commodity;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author yl
 * @Date 2021/1/31 21:31
 */
public class CommodityServer {

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
}
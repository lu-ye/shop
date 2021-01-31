package com.igeek.travel.dao;

import com.igeek.travel.entity.Commodity;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author yl
 * @Date 2021/1/31 20:48
 */
public class CommodityDao extends BasicDao{

    //热门旅游查询
    public List<Commodity> selectHot() throws SQLException {
        String sql = "select * from tab_route where rflag = 1 limit 0,?";
        List list = this.getBeanList(sql, Commodity.class, 4);
        return list;
    }

    //最新旅游查询
    public List<Commodity> selectNew() throws SQLException {
        String sql = "select * from tab_route order by rdate desc limit 0,?";
        List list = this.getBeanList(sql, Commodity.class, 4);
        return list;
    }

    //主题旅游查询
    public List<Commodity> selectThemeTour() throws SQLException {
        String sql = "select * from tab_route where isThemeTour = 1 limit 0,?";
        List list = this.getBeanList(sql, Commodity.class, 4);
        return list;
    }





}
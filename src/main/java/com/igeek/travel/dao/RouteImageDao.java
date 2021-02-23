package com.igeek.travel.dao;

import com.igeek.travel.entity.RouteImage;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author yl
 * @Date 2021/2/22 21:03
 */
public class RouteImageDao extends BasicDao<RouteImage>{
    public List<RouteImage> selectBigByRid(int rid) throws SQLException {
        String sql = "select bigPic from tab_route_img where rid = ?";
        return this.getBeanList(sql,RouteImage.class,rid);
    }
}
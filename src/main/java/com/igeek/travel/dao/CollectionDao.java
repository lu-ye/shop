package com.igeek.travel.dao;

import java.sql.SQLException;

/**
 * @Description TODO
 * @Author yl
 * @Date 2021/2/22 19:38
 */
public class CollectionDao extends BasicDao{
    public int updateCount(int count,String rid) throws SQLException {
        String sql = "update tab_route set count = ? where rid = ?";
        return this.update(sql, count, rid);
    }
}
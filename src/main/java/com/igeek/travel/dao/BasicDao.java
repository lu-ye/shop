package com.igeek.travel.dao;

import com.igeek.travel.untils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @Description TODO
 * @Author yl
 * @Date 2021/1/27 10:22
 */
public class BasicDao<T> {

    QueryRunner runner = new QueryRunner();

    //增删改
    public int update(String sql,Object...params) throws SQLException {
        return runner.update(DataSourceUtils.getConnection(),sql,params);

    }


}
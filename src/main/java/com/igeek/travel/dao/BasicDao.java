package com.igeek.travel.dao;

import com.igeek.travel.untils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

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
    //查询单个值
    public Object getSelectOne(String sql , Object...params) throws SQLException {
        return runner.query(DataSourceUtils.getConnection(),sql,new ScalarHandler<>(),params);
    }

    //查询列表

    public List<T> getBeanList(String sql,Class<T> clazz,Object...params) throws SQLException {
        return runner.query(DataSourceUtils.getConnection(),sql,new BeanListHandler<>(clazz),params);
    }


}
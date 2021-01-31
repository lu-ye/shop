package com.igeek.travel.dao;

import com.igeek.travel.entity.User;

import java.sql.SQLException;

/**
 * @Description TODO
 * @Author yl
 * @Date 2021/1/29 10:21
 */
public class UserDao extends BasicDao<User>{

    //插入注册数据
    public int insert(User user) throws SQLException {
        String sql = "insert into tab_user values(?,?,?,?,?,?,?,?,0,?)";
        int i = this.update(sql, user.getUid(), user.getUsername(), user.getPassword(), user.getName(),
                user.getBirthday(), user.getSex(), user.getTelephone(), user.getEmail(), user.getCode()
        );
        return i;

    }
    //更新状态码

    public int updateState(String code) throws SQLException {
        String sql = "update tab_user set status = ? where code = ?";
        int i = this.update(sql, 1, code);
        return i;
    }

    //登录

    public User selectOne(String username,String password) throws SQLException {
        String sql = "select from user where username = ? and password = ?";
        User user = (User) this.getSelectOne(sql,username,password);
        return user;

    }



}
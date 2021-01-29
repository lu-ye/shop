package com.igeek.travel.dao;

import com.igeek.travel.entity.User;

import java.sql.SQLException;

/**
 * @Description TODO
 * @Author yl
 * @Date 2021/1/29 10:21
 */
public class UserDao extends BasicDao<User>{

    //插入数据
    public int insert(User user) throws SQLException {
        String sql = "insert into tab_user values(?,?,?,?,?,?,?,?,0,?)";
        int i = this.update(sql, user.getUid(), user.getUsername(), user.getPassword(), user.getName(),
                user.getBirthday(), user.getSex(), user.getTelephone(), user.getEmail(), user.getCode()
        );
        return i;

    }


}
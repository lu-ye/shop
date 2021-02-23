package com.igeek.travel.service;

import com.igeek.travel.dao.CollectionDao;
import com.igeek.travel.entity.Collection;

import java.sql.SQLException;

/**
 * @Description TODO
 * @Author yl
 * @Date 2021/2/22 20:00
 */
public class CollectionService {
    private CollectionDao dao = new CollectionDao();
    public int changeCount(String rid,int count){
        int i = 0;
        try {
             i = dao.updateCount(count, rid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
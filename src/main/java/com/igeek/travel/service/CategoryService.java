package com.igeek.travel.service;

import com.igeek.travel.dao.CategoryDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author yl
 * @Date 2021/2/15 21:02
 */
public class CategoryService {
    private CategoryDao dao = new CategoryDao();

    public List viewAllCategory(){

        try {
            return dao.selectAllCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String viewOneCategory(String cid){

        try {
            return dao.selectOneCategory(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
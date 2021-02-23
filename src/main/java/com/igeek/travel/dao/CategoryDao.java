package com.igeek.travel.dao;

import com.igeek.travel.entity.Category;
import com.igeek.travel.entity.Commodity;

import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author yl
 * @Date 2021/2/15 20:50
 */
public class CategoryDao extends BasicDao<Category>{

    public List selectAllCategory() throws SQLException {
        return this.getBeanList("select * from tab_category",Category.class);
    }

    //通过商品类别的编号查询商品类别的名称
    public String selectOneCategory(String cid) throws SQLException {
        Object value = this.getSingleValue("select cname from tab_category where cid = ?", cid);
        return value.toString();
    }




}
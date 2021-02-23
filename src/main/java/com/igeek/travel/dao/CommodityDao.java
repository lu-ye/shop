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

    //查找境外游
    public List<Commodity> selectAbroad() throws SQLException {
        String sql = "select * from tab_route where rid > 500 limit 0,?";
        List list = this.getBeanList(sql, Commodity.class, 6);
        return list;
    }

    //查找境内游
    public List<Commodity> selectDomestic() throws SQLException {
        String sql = "select * from tab_route where rid < 500 limit 0,?";
        List list = this.getBeanList(sql, Commodity.class, 6);
        return list;
    }

    //查询符合商品总记录数
    public int selectCounts(String cid,String cname) throws SQLException {
        Long value = 0L;
        if(cid==null||cid.equals("")){
            String sql = "select count(*) from tab_route where rname like concat('%',?,'%')";
            value = (Long)this.getSingleValue(sql, cname);
        }
        else {
            String sql = "select count(*) from tab_route where cid=? and rname like concat('%',?,'%')";
            value = (Long)this.getSingleValue(sql,cid,cname);
        }
        return value.intValue();
    }

    //查询商品列表
    public List selectCommodity(String cid, String cname, int begin) throws SQLException {
        List list = null;
        if(cid==null||cid.equals("")){
            String sql = "select * from tab_route where rname like concat('%',?,'%') limit ?,8";
           list =  this.getBeanList(sql,Commodity.class,cname,begin);

        }
        else {
            String sql = "select * from tab_route where cid=? and rname like concat('%',?,'%') limit ?,8";
            list =  this.getBeanList(sql,Commodity.class,cid,cname,begin);

        }
        return list;
    }

    //通过商品编号查询商品
    public Commodity selectCommodityByrid(String rid) throws SQLException {
        String sql = "select * from tab_route where rid = ?";
        Commodity commodity =  (Commodity)this.getBean(sql,Commodity.class,rid);
        return commodity;
    }
    //通过商品编号查找相关图片


}
package com.igeek.travel.controller;

import com.igeek.travel.entity.Commodity;
import com.igeek.travel.service.CategoryService;
import com.igeek.travel.service.CommodityService;
import com.igeek.travel.vo.PageVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description TODO
 * @Author yl
 * @Date 2021/1/31 21:36
 */
@WebServlet(name = "CommodityServlet" , urlPatterns = "/commodity")
public class CommodityServlet extends BasicServlet{
    private CommodityService commodityServer = new CommodityService();
    private CategoryService categoryServer= new CategoryService();
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Commodity> hot = commodityServer.viewHot();
        request.setAttribute("hot",hot);
        List<Commodity> aNew = commodityServer.viewNew();
        request.setAttribute("aNew",aNew);
        List<Commodity> viewThemeTour = commodityServer.viewThemeTour();
        request.setAttribute("viewThemeTour",viewThemeTour);
        List<Commodity> viewAbroad = commodityServer.viewAbroad();
        request.setAttribute("viewAbroad",viewAbroad);
        List<Commodity> viewDomestic = commodityServer.viewDomestic();
        request.setAttribute("viewDomestic",viewDomestic);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
    public void viewCommodityListByCidPname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从请求参数中获取当前页
        String page = request.getParameter("pageNow");
        int pageNow = 1;   //默认查询第一页
        if(page!=null){
            pageNow = Integer.parseInt(page);
        }

        //从请求参数中获取查询条件 cid cname
        String cid = request.getParameter("cid");
        if(cid!=null && !"".equals(cid)){
            String cname = categoryServer.viewOneCategory(cid);
            request.setAttribute("cname",cname);
        }

        String pname = request.getParameter("pname");
        if(pname==null){
            pname = "";  //默认查询所有商品信息
        }

        //查询所有的商品信息
        PageVo<Commodity> vo = commodityServer.viewProductsByCidPname(cid, pname, pageNow);
        request.setAttribute("vo",vo);
        request.getRequestDispatcher("route_list.jsp").forward(request,response);
    }

    public void viewCommodityByrid (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String rid = request.getParameter("rid");
        System.out.println(rid);
        Commodity commodity = commodityServer.viewCommodityByrid(rid);
        System.out.println(commodity);
        request.setAttribute("commodity",commodity);
        String cid = request.getParameter("cid");
        if(cid!=null){
            String cname = categoryServer.viewOneCategory(cid);
            request.setAttribute("cname",cname);
            request.setAttribute("cid",cid);
        }
        String pageNow = request.getParameter("pageNow");
        request.setAttribute("pageNow",pageNow);
        String pname = request.getParameter("pname");
        request.setAttribute("pname",pname);
        request.getRequestDispatcher("route_detail.jsp").forward(request,response);
    }
}
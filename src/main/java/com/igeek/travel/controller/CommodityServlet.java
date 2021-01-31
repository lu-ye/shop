package com.igeek.travel.controller;

import com.igeek.travel.entity.Commodity;
import com.igeek.travel.service.CommodityServer;

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
@WebServlet(name = "CommodityServlet" , urlPatterns = "/Commodity")
public class CommodityServlet extends BasicServlet{
    private CommodityServer commodityServer = new CommodityServer();

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Commodity> hot = commodityServer.viewHot();
        request.setAttribute("hot",hot);
        List<Commodity> aNew = commodityServer.viewNew();
        request.setAttribute("aNew",aNew);
        List<Commodity> viewThemeTour = commodityServer.viewThemeTour();
        request.setAttribute("viewThemeTour",viewThemeTour);

        request.getRequestDispatcher("index").forward(request,response);
    }
}
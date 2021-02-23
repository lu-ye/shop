package com.igeek.travel.controller;

import com.google.gson.Gson;
import com.igeek.travel.service.CategoryService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet",urlPatterns = "/category")
public class CategoryServlet extends BasicServlet {
   private CategoryService server = new CategoryService();

   //查询商品分类
   public void viewAllCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
       List category = server.viewAllCategory();
       Gson gson = new Gson();
       String json = gson.toJson(category);
       response.getWriter().write(json);
   }
}

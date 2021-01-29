package com.igeek.travel.controller;

import com.igeek.travel.dao.UserDao;
import com.igeek.travel.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BasicServlet {
    private UserService userService = new UserService();

    public void register(HttpServletRequest request,HttpServletResponse response){
        Map<String, String[]> map = request.getParameterMap();

        System.out.println(map);

    }

}

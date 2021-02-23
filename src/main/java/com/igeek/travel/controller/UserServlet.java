package com.igeek.travel.controller;

import com.google.gson.internal.$Gson$Preconditions;
import com.igeek.travel.dao.UserDao;
import com.igeek.travel.entity.User;
import com.igeek.travel.service.UserService;
import com.igeek.travel.untils.CommonUtils;
import com.igeek.travel.untils.MD5Utils;
import com.igeek.travel.untils.MailUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BasicServlet {
    private UserService userService = new UserService();

    public void register(final HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();

        //System.out.println(map);

        User user = new User();

        //日期的处理
        ConvertUtils.register(new Converter() {
            @Override
            public Object convert(Class Clazz, Object o) {
                Date birthday = null;
                if(o instanceof String){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        birthday = sdf.parse(request.getParameter("birthday"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                return birthday;
            }

        },Date.class);

        //给user赋值
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        user.setUid(CommonUtils.getUUID().replaceAll("-",""));
        String code = CommonUtils.getUUID().replaceAll("-","");
        user.setCode(code);


        user.setPassword(MD5Utils.md5(user.getPassword()));

        boolean register = userService.register(user);
        if(register){
            String emailMsg = "恭喜您注册成功，这是一封激活邮件，请点击<a href='http://localhost:8080/user?method=active&code="+code+"'>"+code+"</a>激活";
            try {
                MailUtils.sendMail(user.getEmail(),"注册激活邮件",emailMsg);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("register_ok.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("register_fail.jsp").forward(request,response);
        }


    }
    public void active(final HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");
        boolean active = userService.active(code);
        if(active){
            response.sendRedirect("login.jsp");
        }else {
            response.sendRedirect("error.jsp");

        }


    }
    //登录控制
    public void login(final HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String code = request.getParameter("code");
        if(code==null){
            //不是自动登录
            password = MD5Utils.md5(password);
        }


        User user = userService.login(username, password);


        if(user!=null){
            //选择自动登录
            String free = request.getParameter("free");
            if(free!=null && "free".equals(free)){
                Cookie usernameCookie = new Cookie("username", URLEncoder.encode(username,"UTF-8"));
                Cookie passwordCookie = new Cookie("password",password);
                usernameCookie.setMaxAge(7*24*60*60);
                passwordCookie.setMaxAge(7*24*60*60);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            //跳转至首页
            request.getRequestDispatcher(request.getContextPath()+"/commodity?method=index").forward(request,response);
        }else{
            request.setAttribute("msg","用户名与密码不匹配");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }

    //登出控制
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //销毁会话
        session.invalidate();

        //清楚Cookie
        Cookie usernameCookie = new Cookie("username", "");
        Cookie passwordCookie = new Cookie("password","");

        usernameCookie.setMaxAge(0);
        passwordCookie.setMaxAge(0);

        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);

        request.getRequestDispatcher(request.getContextPath()+"/commodity?method=index").forward(request,response);
    }

}

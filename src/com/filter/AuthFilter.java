package com.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String servletPath = request.getServletPath();

        Cookie[] cookies = request.getCookies();
        List<Cookie> cookieArrayList = Arrays.asList(cookies);
        if(servletPath.contains("ErrorPage.jsp") || servletPath.contains("LoginFailed.jsp") || servletPath.contains("index.jsp") || servletPath.contains("servlet/LoginServlet")){
            chain.doFilter(req, resp);
        }else if(cookieArrayList.contains("vinson-auth")){
            System.out.println("鉴权通过..........");
            chain.doFilter(req, resp);
        }else {
            response.sendRedirect("/ErrorPage.jsp");
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}

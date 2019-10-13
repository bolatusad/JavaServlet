package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

@WebFilter(filterName = "LogFilter",urlPatterns = {"*"})
public class LogFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String remoteAddr = req.getRemoteAddr();
        System.out.println("IP:" + remoteAddr + "-Time:" + new Date().toString());
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        String initParameter = config.getInitParameter("test-parm");
        System.out.println("TestParma:" + initParameter);
    }

}

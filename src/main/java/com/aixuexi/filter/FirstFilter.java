package com.aixuexi.filter;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liuao on 2018/11/13.
 */
@Component
@Order(1)
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("======init======");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入filter");
            Cookie cookie = new Cookie("liuao", "123");
            HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String a = (String) request.getAttribute("liu");
        String b = request.getParameter("liu");
            response.addCookie(cookie);
        cookie.setMaxAge(30);
        response.addHeader("xiaoliu", "asda");
//        response.sendRedirect("https://testsso.sohu-inc.com/login?service=http://localhost:8081/userFootMarkStatistics/query.html");
//        return;
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("离开filter");
    }

    @Override
    public void destroy() {
        System.out.println("======destroy======");
    }
}

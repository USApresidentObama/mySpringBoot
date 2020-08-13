package com.aixuexi.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liuao on 2018/11/13.
 */
@WebFilter
@Component
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("======init======");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入filter");
        Cookie cookie = new Cookie("liuao","123");
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        response.addCookie(cookie);
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("离开filter");
    }

    @Override
    public void destroy() {
        System.out.println("======destroy======");
    }
}

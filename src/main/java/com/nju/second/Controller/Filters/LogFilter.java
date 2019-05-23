package com.nju.second.Controller.Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "logFilter2")
public class LogFilter implements Filter {

    String[] includeUrls = new String[]{"noLogin","/login","/register","/json",".js",".css",".ico",".jpg",".png"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();

        //是否需要过滤
        boolean needFilter = isNeedFilter(uri);
        if (!needFilter) { //不需要过滤直接传给下一个过滤器
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // session中包含user对象,则是登录状态
        if (session != null && session.getAttribute("User") != null) {
            filterChain.doFilter(request, response);
        } else {
            String requestType = request.getHeader("X-Requested-With");
            //判断是否是ajax请求
            if (requestType != null && "XMLHttpRequest".equals(requestType)) {
                response.getWriter().write("NO LOGIN!");
            } else {
                //重定向到登录页(需要在static文件夹下建立此html文件)
                response.sendRedirect( "/user/noLogin");
            }
            return;
        }

    }

    @Override
    public void destroy() {
    }


    public boolean isNeedFilter(String uri) {
        for (String includeUrl : includeUrls) {
            if (uri.indexOf(includeUrl) != -1) {
                return false;
            }
        }
        return true;
    }
}
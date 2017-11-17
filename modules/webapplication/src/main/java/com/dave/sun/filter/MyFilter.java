package com.dave.sun.filter;

import com.dave.sun.service.impl.DemoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by Super.Sun on 2017/11/17.
 */
@WebFilter(filterName="myFilter",urlPatterns="/*")
public class MyFilter implements Filter{

    private static final Logger LOGGER= LoggerFactory.getLogger(MyFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //LOGGER.info("myFilter初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //LOGGER.info("myFilter过滤");
        String name= request.getParameter("name");
        //LOGGER.info("name="+name);
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {
        //LOGGER.info("myFilter销毁");
    }
}

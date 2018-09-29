package com.dytian.spring.dytianboot.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "customFilter",urlPatterns = {"/*"})
public class CustomeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      //  log.info("filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
     //   log.info("doFilter...........");
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
      //  log.info("filter destroy");
    }
}

package com.landkay.springboot.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 90818
 * @Title: MainFilter
 * @ProjectName springboot
 * @Description: 过滤器的触发时机是容器后，servlet之前
 * @date 2018/8/216:26
 */
@Slf4j
public class MainFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("**********  filter -- init **************");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.info("**********  filter -- doFilter **************");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.info("**********  filter -- destroy **************");
    }
}

package com.lwf.filter;

import com.lwf.util.WordFilter;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lwf
 * @title: MinGanCiFilter
 * @projectName 11_17ServletFilter
 * @description: TODO
 * @date 2020/11/1811:19
 */
@WebFilter("/test1")
public class MinGanCiFilter implements Filter {
    private static final WordFilter wordFilter=new WordFilter();
    private static final Logger logger=Logger.getLogger(MinGanCiFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        String queryString = request.getQueryString();
        logger.info("开始过滤铭感词:"+queryString);
        if (queryString!=null&&wordFilter.doFilter(queryString)) {
            logger.info("包含铭感词");
        } else {
             logger.info("不包含敏感词,放行");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}

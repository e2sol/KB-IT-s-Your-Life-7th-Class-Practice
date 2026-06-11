package org.scoula.ex04.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;

public class PerformanceMonitorFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        long start = System.currentTimeMillis();

        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();

        LocalDateTime receiveTime = LocalDateTime.now();

        chain.doFilter(request, response);

        long end = System.currentTimeMillis();

        System.out.println(
                "[" + receiveTime + "] "
                        + uri
                        + " - "
                        + (end - start)
                        + "ms 소요."
        );
    }

    @Override
    public void destroy() {
    }
}
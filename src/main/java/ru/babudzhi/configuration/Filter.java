package ru.babudzhi.configuration;

import javax.servlet.*;
import java.io.IOException;

public class Filter implements javax.servlet.Filter {
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException, ServletException {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            next.doFilter(request, response);
        }
    @Override
    public void destroy() {

    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

}

package com.neu.edu.Filter;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/*"})
public class Filter implements jakarta.servlet.Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        if(request1.getRequestURI().endsWith("Login.jsp")||request1.getRequestURI().endsWith("LoginServlet")||request1.getRequestURI().endsWith("login.css")){
            chain.doFilter(request,response);
        }
        else if(request1.getSession().getAttribute("isLogin") == null){
            HttpServletResponse response1 = (HttpServletResponse) response;
            response1.sendRedirect("Login.jsp?notLogin=true");
        }
        else if (request1.getSession().getAttribute("authority").equals("teacher")&&
                (request1.getRequestURI().endsWith("student_main.jsp")||
                    request1.getRequestURI().endsWith("student_approval_list.jsp")
                )
        ) {
            HttpServletResponse response1 = (HttpServletResponse) response;
            response1.sendRedirect("Login.jsp?noAuthority=true");
        }
        else if (request1.getSession().getAttribute("authority").equals("student")&&
                (request1.getRequestURI().endsWith("teacher_main.jsp")||
                    request1.getRequestURI().endsWith("teacher_approval_list.jsp")
                )
        ) {
            HttpServletResponse response1 = (HttpServletResponse) response;
            response1.sendRedirect("Login.jsp?noAuthority=true");
       }
        else {
            chain.doFilter(request, response);
        }
    }
}

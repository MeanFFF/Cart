package Filter;


import bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();

        if (uri.endsWith(".css") || uri.endsWith(".js")) {
            filterChain.doFilter(request, response);
            return;
        }

        if(uri.endsWith("login.jsp") || uri.endsWith("login")){
            filterChain.doFilter(request, response);
            return;
        }

        User user = (User) request.getSession().getAttribute("user");

        if(user == null){
            response.sendRedirect("login.jsp");
            return;
        }

        filterChain.doFilter(request, response);


    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init()");
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroy()");
    }
}

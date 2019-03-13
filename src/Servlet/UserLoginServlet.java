package Servlet;

import bean.User;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        User user = new UserDAO().getUser(name, password);
        if(user != null){
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/listProduct").forward(req,resp);
        }else{
            resp.sendRedirect("login.jsp");
        }
    }
}

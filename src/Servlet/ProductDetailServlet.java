package Servlet;

import bean.Product;
import dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ProductDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pid = Integer.parseInt(req.getParameter("pid"));

        Product product = new ProductDAO().getProduct(pid);
        req.getSession().setAttribute("product", product);

        Cookie[] cookies = req.getCookies();
        String list = "";


        if(cookies.length>0 && cookies != null){

            if(cookies.length > 10){
                list = "";
            }
            for(Cookie c : cookies){
                if(c.getName().equals("LastViewProduct")){
                    list = c.getValue();
                }
            }
        }
        list +=pid + "#";
        Cookie cookie = new Cookie("LastViewProduct", list);

        ArrayList<Product> lastViewProducts = ProductDAO.listLastViewProduct(cookie.getValue());
        req.getSession().setAttribute("lastViewProducts", lastViewProducts);


        resp.addCookie(cookie);


        resp.sendRedirect("detailProduct.jsp");
    }
}

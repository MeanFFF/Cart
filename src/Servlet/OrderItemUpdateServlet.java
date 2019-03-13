package Servlet;

import bean.Order;
import bean.OrderItem;
import dao.OrderItemDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderItemUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int num = Integer.parseInt(req.getParameter("newNum"));

        System.out.println(id + " " + num);

        List<OrderItem> ois = (List<OrderItem>) req.getSession().getAttribute("ois");
        OrderItem orderItem = null;
        if(ois != null){
            for(OrderItem oi : ois){
                if(oi.getProduct().getId() == id){
                    orderItem = oi;
                }
            }
        }
        orderItem.setNum(num);

        resp.sendRedirect("/listOrderItem");

    }
}

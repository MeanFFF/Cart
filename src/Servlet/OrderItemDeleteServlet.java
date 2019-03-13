package Servlet;

import bean.OrderItem;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderItemDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<OrderItem> ois = (List<OrderItem>) req.getSession().getAttribute("ois");
        OrderItem orderItem = null;
        if(ois != null){
            for(OrderItem oi : ois){
                if(oi.getProduct().getId() == id){
                    orderItem = oi;
                }
            }
        }

        ois.remove(orderItem);
        resp.sendRedirect("/listOrderItem");
    }
}

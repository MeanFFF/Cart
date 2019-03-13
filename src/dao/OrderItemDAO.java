package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.OrderItem;
import bean.Product;

public class OrderItemDAO {

    public static void main(String[] args) {

    }

    public void insert(OrderItem oi) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8&serverTimezone=GMT",
                    "root", "15659170386");

            String sql = "insert into orderitem values(null,?,?,?)";

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1,oi.getProduct().getId());
            ps.setInt(2,oi.getNum());
            ps.setInt(3,oi.getOrder().getId());

            ps.execute();

            ps.close();

            c.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public OrderItem getOrderItemById(int id) {
        OrderItem oi = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8&serverTimezone=GMT",
                    "root", "15659170386");

            String sql = "select * from orderitem where id = ?";

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, id);


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                oi = new OrderItem();


                oi.setId(id);
                int pid = rs.getInt(2);
                int num = rs.getInt(3);
                int oid = rs.getInt(4);

                oi.setProduct(new ProductDAO().getProduct(pid));
                oi.setNum(num);
                oi.setOrder(new OrderDAO().getOrderById(oid));


            }

            ps.close();

            c.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return oi;
    }

}
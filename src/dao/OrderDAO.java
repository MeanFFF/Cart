package dao;

import java.sql.*;

import bean.Order;

public class OrderDAO {

    public void insert(Order o) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8&serverTimezone=GMT",
                    "root", "15659170386");

            String sql = "insert into order_ values(null,?)";

            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, o.getUser().getId());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                o.setId(id);
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

    }

    public Order getOrderById(int id) {
        Order o = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8&serverTimezone=GMT",
                    "root", "15659170386");

            String sql = "select * order_ where id = ?";

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1, id);


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                o = new Order();


                o.setId(id);
                int uid = rs.getInt(2);

                o.setUser(new UserDAO().getUserById(uid));


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
        return o;
    }
}

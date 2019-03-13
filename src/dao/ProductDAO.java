package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import bean.Product;

public class ProductDAO {

    public static void main(String[] args) {

        System.out.println(new ProductDAO().ListProduct().size());

    }

    public Product getProduct(int id) {
        Product result = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8&serverTimezone=GMT",
                    "root", "15659170386");

            String sql = "select * from product where id = ?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                result = new Product();
                result.setId(id);

                String name = rs.getString(2);
                float price = rs.getFloat(3);

                result.setName(name);
                result.setPrice(price);

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
        return result;
    }

    public List<Product> ListProduct() {
        List<Product> products = new ArrayList<Product>();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8&serverTimezone=GMT",
                    "root", "15659170386");

            String sql = "select * from product order by id desc";

            PreparedStatement ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float price = rs.getFloat(3);

                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                products.add(product);

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
        return products;
    }

    public static ArrayList<Product> listLastViewProduct(String cookie){
        ArrayList<Product> products = new ArrayList<>();
        HashSet<Integer> noRepeatRecords = new HashSet<>();
        String[] records = cookie.split("#");
        int count = 5;
        int i = records.length - 1;
        while(noRepeatRecords.size() < count && i >= 0){
            noRepeatRecords.add(Integer.valueOf(records[i]));
            i --;
        }
        Iterator<Integer> it = noRepeatRecords.iterator();
        while(it.hasNext()){
            products.add(new ProductDAO().getProduct(it.next()));
        }

        return products;
    }
}

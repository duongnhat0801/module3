package com.example.hnsc.repositories.product;

import com.example.hnsc.database.DBConnect;
import com.example.hnsc.models.Category;
import com.example.hnsc.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepo implements IProductRepo {
    @Override
    public List<Product> selectAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = new DBConnect().getConnection();
        String sql = "select a.* , b.name as \"category_name\" from products a join categories b on a.category_id = b.id;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setSku(rs.getString("sku"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setDescription(rs.getString("description"));
            product.setAvatar(rs.getString("avatar"));
            product.setCostPrice(rs.getDouble("cost_price"));
            product.setQuantity(rs.getInt("quantity"));
            Category category = new Category();
            category.setName(rs.getString("category_name"));
            product.setCategory(category);
            products.add(product);
        }
        return products;
    }

    @Override
    public void insert(Product product) throws SQLException {
        Connection connection = new DBConnect().getConnection();
        String sql = "insert into products(sku,name,price,description, avatar, cost_price, quantity, category_id) value(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, product.getSku());
        ps.setString(2, product.getName());
        ps.setDouble(3, product.getPrice());
        ps.setString(4, product.getDescription());
        ps.setString(5, product.getAvatar());
        ps.setDouble(6, product.getCostPrice());
        ps.setInt(7, product.getQuantity());
        ps.setInt(8, product.getCategoryId());
        ps.executeUpdate();

    }

    @Override
    public Product selectProduct(int id) throws SQLException {
        Product product = null;
        Connection connection = new DBConnect().getConnection();
        String sql = "select p.*, c.id as category_id from products p join categories c on p.category_id = c.id where p.id = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String sku = rs.getString("sku");
            String name = rs.getString("name");
            double price = Double.parseDouble(rs.getString("price"));
            String description = rs.getString("description");
            String avatar = rs.getString("avatar");
            double cost_price = Double.parseDouble(rs.getString("cost_price"));
            int quantity = Integer.parseInt(rs.getString("quantity"));
            int categoryId = rs.getInt("category_id");
            product = new Product(id, sku, name, price, description, avatar, cost_price, quantity, categoryId);
        }
        return product;
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = new DBConnect().getConnection();
        String sql = "delete from products where id = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public void update(Product product) throws SQLException {
        Connection connection = new DBConnect().getConnection();
        String sql = "update products set sku = ?, name = ?, price = ?, description = ?, avatar = ?, cost_price = ?, quantity = ?, category_id = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, product.getSku());
        ps.setString(2, product.getName());
        ps.setDouble(3, product.getPrice());
        ps.setString(4, product.getDescription());
        ps.setString(5, product.getAvatar());
        ps.setDouble(6, product.getCostPrice());
        ps.setInt(7, product.getQuantity());
        ps.setInt(8, product.getCategoryId());
        ps.setInt(9, product.getId());
        ps.executeUpdate();
    }

    @Override
    public List<Product> searchProductByName(String keyword) throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = new DBConnect().getConnection();
        String sql = "select * from products where name like ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        System.out.println(keyword);
        ps.setString(1, "%" + keyword +"%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setSku(rs.getString("sku"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setDescription(rs.getString("description"));
            product.setAvatar(rs.getString("avatar"));
            product.setCostPrice(rs.getDouble("cost_price"));
            product.setQuantity(rs.getInt("quantity"));
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> searchProductByName(String keyword, int limit) {
        List<Product> products = new ArrayList<>();
        Connection connection = new DBConnect().getConnection();
        String sql = "select * from products where name like ? order by id desc limit ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + keyword +"%");
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setSku(rs.getString("sku"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setAvatar(rs.getString("avatar"));
                product.setCostPrice(rs.getDouble("cost_price"));
                product.setQuantity(rs.getInt("quantity"));
                products.add(product);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public List<Product> getProductByCategoryId(int categoryId) {
        Connection connection = new DBConnect().getConnection();
        String sql = "select * from products where category_id = ?";
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setSku(rs.getString("sku"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setAvatar(rs.getString("avatar"));
                product.setCostPrice(rs.getDouble("cost_price"));
                product.setQuantity(rs.getInt("quantity"));
                products.add(product);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}

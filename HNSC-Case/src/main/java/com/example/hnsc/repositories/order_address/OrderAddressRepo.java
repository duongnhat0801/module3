package com.example.hnsc.repositories.order_address;

import com.example.hnsc.database.DBConnect;
import com.example.hnsc.models.OrderAddress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderAddressRepo implements IOrderAddressRepo {
    public void UpdateOrderAddress(OrderAddress orderAddress) throws SQLException {
        Connection connection = new DBConnect().getConnection();
        String sql = "update addresses set name=?, address=?,email=?,phone_number=? where id =? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,orderAddress.getName());
        ps.setString(2,orderAddress.getAddress());
        ps.setString(3,orderAddress.getEmail());
        ps.setString(4,orderAddress.getPhoneNumber());
        ps.setInt(5,orderAddress.getId());
        ps.executeUpdate();

    }

    @Override
    public void insert(OrderAddress orderAddress) throws SQLException {
        Connection connection = new DBConnect().getConnection();
        String sql = "insert into addresses(name, address, email,phone_number,order_id) value (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,orderAddress.getName());
        ps.setString(2,orderAddress.getAddress());
        ps.setString(3,orderAddress.getEmail());
        ps.setString(4,orderAddress.getPhoneNumber());
        ps.setInt(5,orderAddress.getOrder_id());
        ps.executeUpdate();
    }

}

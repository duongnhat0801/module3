package com.example.hnsc.repositories.order_address;

import com.example.hnsc.models.OrderAddress;

import java.sql.SQLException;

public interface IOrderAddressRepo {
    void UpdateOrderAddress(OrderAddress orderAddress) throws SQLException;
    void insert(OrderAddress orderAddress) throws SQLException;
}

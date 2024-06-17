package com.example.hnsc.repositories.order;

import com.example.hnsc.models.Order;

import java.sql.SQLException;
import java.util.List;

public interface IOrderRepo {
    List<Order> selectAll() throws SQLException;
    String insertOrder() throws SQLException;
    Order findOrderByNumber(String number) throws SQLException;
    Order findOrderById(int id) throws SQLException;
}

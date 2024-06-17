package com.example.hnsc.services.order;

import com.example.hnsc.models.Order;

import java.util.List;

public interface IOrderService {
    List<Order> selectAll();
    String insertOrder();
    Order findOrderByNumber(String number);
    Order findOrderById(int id);
}

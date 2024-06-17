package com.example.hnsc.services.order;

import com.example.hnsc.models.Order;
import com.example.hnsc.repositories.order.IOrderRepo;
import com.example.hnsc.repositories.order.OrderRepo;

import java.sql.SQLException;
import java.util.List;

public class OrderService implements IOrderService{
    IOrderRepo orderRepo = new OrderRepo();

    @Override
    public List<Order> selectAll() {
        try {
            return orderRepo.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String insertOrder() {
        try {
            return orderRepo.insertOrder();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order findOrderByNumber(String number) {
        try {
            return orderRepo.findOrderByNumber(number);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order findOrderById(int id) {
        try {
            return orderRepo.findOrderById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.example.hnsc.services.order_address;

import com.example.hnsc.models.OrderAddress;
import com.example.hnsc.repositories.order_address.IOrderAddressRepo;
import com.example.hnsc.repositories.order_address.OrderAddressRepo;

import java.sql.SQLException;

public class OrderAddressService implements IOrderAddressService {
    IOrderAddressRepo orderAddressRepo = new OrderAddressRepo();

    @Override
    public void UpdateOrderAddress(OrderAddress orderAddress) {
        try {
            orderAddressRepo.UpdateOrderAddress(orderAddress);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(OrderAddress orderAddress) {
        try {
            orderAddressRepo.insert(orderAddress);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

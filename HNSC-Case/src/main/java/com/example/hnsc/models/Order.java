package com.example.hnsc.models;

import java.util.List;

public class Order {
    private int id;
    private String number;
    private double total;
    private OrderAddress orderAddress;
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(int id, String number, double total, OrderAddress orderAddress) {
        this.id = id;
        this.number = number;
        this.total = total;
        this.orderAddress = orderAddress;
    }

    public Order(String number, double total, OrderAddress orderAddress, List<OrderItem> orderItems) {
        this.number = number;
        this.total = total;
        this.orderAddress = orderAddress;
        this.orderItems = orderItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public OrderAddress getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(OrderAddress orderAddress) {
        this.orderAddress = orderAddress;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}

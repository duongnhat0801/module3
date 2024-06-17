package com.example.hnsc.models;

public class Product {
    private int id;
    private String sku;
    private String name;
    private double price;
    private String description;
    private String avatar;
    private double costPrice;
    private int quantity;
    private int category_id;
    private Category category;

    public Product() {
    }

    public Product(int id, String sku, String name, double price, String description, String avatar, double costPrice, int quantity, int category_id) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.description = description;
        this.avatar = avatar;
        this.costPrice = costPrice;
        this.quantity = quantity;
        this.category_id = category_id;
    }

    public Product(String sku, String name, double price, String description, String avatar, double costPrice, int quantity, int category_id) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.description = description;
        this.avatar = avatar;
        this.costPrice = costPrice;
        this.quantity = quantity;
        this.category_id = category_id;
    }

    public Product(int id, String sku, String name, double price, String description, String avatar, double costPrice, int quantity) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.description = description;
        this.avatar = avatar;
        this.costPrice = costPrice;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return category_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

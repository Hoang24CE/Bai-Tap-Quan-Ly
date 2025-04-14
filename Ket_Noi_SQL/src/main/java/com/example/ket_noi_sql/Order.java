package com.example.ketnoisql.model;

import java.util.List;

public class Order {
    private int id;
    private int customerId;
    private List<OrderItem> orderItems;
    private double totalPrice;

    public Order(int id, int customerId, List<OrderItem> orderItems, double totalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.orderItems = orderItems;
        this.totalPrice = totalPrice;
    }

    public int getId() { return id; }
    public int getCustomerId() { return customerId; }
    public List<OrderItem> getOrderItems() { return orderItems; }
    public double getTotalPrice() { return totalPrice; }
}

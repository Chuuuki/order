package com.example.order.service;

import com.example.order.entity.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

public interface OrderService {

    Order get(Integer id);

    List<Order> list(Order order);

    int add(Order order);
}
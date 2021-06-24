package com.example.order.mapper;

import com.example.order.entity.Order;

import java.util.List;

public interface OrderMapper {

    Order selectOne(Integer id);

    List<Order> list(Order order);

    int add(Order order);
}
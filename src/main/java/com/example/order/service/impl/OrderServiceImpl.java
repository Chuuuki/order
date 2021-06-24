package com.example.order.service.impl;

import com.example.order.entity.Goods;
import com.example.order.entity.Order;
import com.example.order.mapper.GoodsMapper;
import com.example.order.mapper.OrderMapper;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Order get(Integer id) {
        return orderMapper.selectOne(id);
    }

    @Override
    public List<Order> list(Order order) {
        return orderMapper.list(order);
    }

    @Override
    public int add(Order order) {
        // 获取当前商品的价格
        Goods goods = goodsMapper.selectOne(order.getGoodsId());
        order.setPrice(goods.getPrice());
        order.setCreateTime(new Date());
        return orderMapper.add(order);
    }

}
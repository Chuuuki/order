package com.example.order.service.impl;

import com.example.order.entity.Goods;
import com.example.order.entity.Order;
import com.example.order.mapper.GoodsMapper;
import com.example.order.mapper.OrderMapper;
import com.example.order.service.GoodsService;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods get(Integer id) {
        return goodsMapper.selectOne(id);
    }

    @Override
    public List<Goods> list(Goods goods) {
        return goodsMapper.list();
    }

}
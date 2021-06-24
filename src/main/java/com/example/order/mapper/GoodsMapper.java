package com.example.order.mapper;

import com.example.order.entity.Goods;
import com.example.order.entity.Order;

import java.util.List;

public interface GoodsMapper {

    Goods selectOne(Integer id);

    List<Goods> list();
}
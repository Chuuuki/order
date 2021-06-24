package com.example.order.service;

import com.example.order.entity.Goods;
import com.example.order.entity.Order;

import java.util.List;

public interface GoodsService {

    Goods get(Integer id);

    List<Goods> list(Goods goods);
}
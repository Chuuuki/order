package com.example.order.controller;

import com.example.order.entity.Order;
import com.example.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderService orderService;

    @RequestMapping("/{id}")
    @ResponseBody
    public Order order(@PathVariable("id") Integer id) {
        if (id == null) { return null; }
        return orderService.get(id);
    }

    /**
     * 获取订单列表
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<Order> list(Order order) {
        logger.info("获取订单列表");
        return orderService.list(order);
    }


    /**
     * 创建订单
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public String add(Order order) {
        if (orderService.add(order) == 1) {
            logger.info("新增订单成功");
            return "添加成功，<a href='/'>去订单列表</a>";
        }
        logger.info("新增订单失败");
        return "添加失败，<a href='javascript:history.go(-1);'>点我返回</a>";
    }
}
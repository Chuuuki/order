package com.example.order.controller;

import com.example.order.entity.Admin;
import com.example.order.entity.Goods;
import com.example.order.service.AdminService;
import com.example.order.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 登录处理方法
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/list")
    @ResponseBody
    public List list(Goods goods) {
        logger.info("获取商品列表");
        return goodsService.list(goods);
    }

}
package com.example.order.service.impl;

import com.example.order.entity.Admin;
import com.example.order.mapper.AdminMapper;
import com.example.order.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {
        Admin admin = adminMapper.selectOne(username, password);
        return admin;
    }

}
package com.example.order.service;

import com.example.order.entity.Admin;

public interface AdminService {


    Admin login(String username, String password);
}
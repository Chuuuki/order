package com.example.order.mapper;

import com.example.order.entity.Admin;

public interface AdminMapper {

    Admin selectOne(String username, String password);

}
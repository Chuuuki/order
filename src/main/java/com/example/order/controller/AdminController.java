package com.example.order.controller;

import com.example.order.entity.Admin;
import com.example.order.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录处理方法
 */
@Controller
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminService adminService;

    /**
     * 默认跳转到登录页
     * @param request
     * @return
     */
    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        if (request.getSession().getAttribute("admin") == null)
            return "login";
        return "order";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password,
                        HttpServletRequest request, HttpServletResponse response) throws IOException {
        Admin admin = adminService.login(username, password);
        if (admin == null) {
            response.sendRedirect("/login?msg=用户名或密码错误");
            return null;
        }
        request.getSession().setAttribute("admin", admin);
        response.sendRedirect("/");
        logger.info("用户{}登陆成功", admin.getUsername());
        return null;
    }


}
package com.bookOline.bookOline.controller;

import com.bookOline.bookOline.entity.Order;
import com.bookOline.bookOline.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/allOrders")
    public List<Order>findAllOrders(){
        return orderService.findAllOrders();
    }
}
package com.bookOline.bookOline.services;

import com.bookOline.bookOline.entity.Order;
import com.bookOline.bookOline.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }
}

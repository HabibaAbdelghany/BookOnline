package com.bookOline.bookOline.services;

import com.bookOline.bookOline.ENTITY.Order;
import com.bookOline.bookOline.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    public List<Order> findAllOrders(){
        return orderRepo.findAll();
    }
}

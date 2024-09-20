package com.bookOline.bookOline.services;

import com.bookOline.bookOline.entity.Book;
import com.bookOline.bookOline.entity.Category;
import com.bookOline.bookOline.entity.Order;
import com.bookOline.bookOline.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer id){
        Optional<Order> orderOptional =orderRepository.findById(id);
        return orderOptional.orElse(null);

    }
    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    public void deleteOrderById (Integer id){
        Optional<Order>orderOptional=orderRepository.findById(id);
        if (orderOptional.isPresent()){
//

            orderRepository.deleteById(id);
        }else{
            throw new RuntimeException(id +"this id not exist") ;
        }

    }










}

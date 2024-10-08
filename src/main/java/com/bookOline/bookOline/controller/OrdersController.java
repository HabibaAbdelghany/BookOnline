package com.bookOline.bookOline.controller;

import com.bookOline.bookOline.dto.UpdateBookDTO;
import com.bookOline.bookOline.dto.UpdateBookOrderDto;
import com.bookOline.bookOline.entity.Category;
import com.bookOline.bookOline.entity.Order;
import com.bookOline.bookOline.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public List<Order>findAllOrders(){
        return orderService.findAllOrders();
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Integer id){
        return orderService.getOrderById(id);
    }
    @PostMapping
    public  Order createOrder(@RequestBody Order order){
        return  orderService.createOrder(order);
    }

    @DeleteMapping("/{id}")
    public String deleteOrderById(@PathVariable Integer id){
        orderService.deleteOrderById(id);
        return (id +"the order is deleted");
}

    @PutMapping("/{id}")
    public  String updateBookOrder(
            @PathVariable Integer id ,
            @RequestBody UpdateBookOrderDto updateBookOrderDto
            ){
     orderService.updateBookOrder(id,updateBookOrderDto);
        return"Order Updated";
    }


}
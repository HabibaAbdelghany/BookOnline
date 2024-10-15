package com.bookOline.bookOline.controller;

import com.bookOline.bookOline.dto.*;
import com.bookOline.bookOline.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public List<ResponseEntityOrdersDto>findAllOrders(){
        return orderService.findAllOrders();
    }
    @GetMapping("/{id}")
    public ResponseEntityOrdersDto getOrderById(@PathVariable Integer id){
        return orderService.getOrderById(id);
    }
    @PostMapping    public ResponseEntity<String> createOrder(@RequestBody CreateOrderDto createOrderDto) {
        // Validate the incoming DTO to ensure the customer ID and book IDs are provided
        if (createOrderDto.getCustomer_id() == null || createOrderDto.getSetBookId().isEmpty()) {
            return ResponseEntity.badRequest().body("Customer ID and Book IDs must not be null or empty");
        }

        orderService.createOrder(createOrderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Order created");
    }


    @DeleteMapping("/{id}")
    public String deleteOrderById(@PathVariable Integer id){
        orderService.deleteOrderById(id);
        return (id +"the order is deleted");
}

      @PutMapping("/updateOrder/{id}")
      public void updateOrder(@PathVariable Integer id,@RequestBody UpdateOrderDto updateOrderDto){
        orderService.updateOrder(id,updateOrderDto);
      }
    @PatchMapping("/{id}")
    public  String updateBookOrder(
            @PathVariable Integer id ,
            @RequestBody UpdateBookOrderDto updateBookOrderDto
            ){
     orderService.updateBookOrder(id,updateBookOrderDto);
        return"Order Updated";
    }


}
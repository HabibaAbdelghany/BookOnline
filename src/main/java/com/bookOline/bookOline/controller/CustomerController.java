package com.bookOline.bookOline.controller;

import com.bookOline.bookOline.ENTITY.Category;
import com.bookOline.bookOline.ENTITY.Customer;
import com.bookOline.bookOline.services.CategoryService;
import com.bookOline.bookOline.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/customer")


public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @RequestMapping("/allCustomers")
    public List<Customer> getAllCustomers(){
        return customerService.findAllCustometrs();
    }


}

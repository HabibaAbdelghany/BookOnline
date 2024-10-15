package com.bookOline.bookOline.controller;

import com.bookOline.bookOline.dto.CreateCustomerDto;
import com.bookOline.bookOline.dto.ResponseEntityCustomersDto;
import com.bookOline.bookOline.dto.UpdateCustomerDto;
import com.bookOline.bookOline.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")


public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping


    public List<ResponseEntityCustomersDto> getAllCustomers() {
        return customerService.findAllCustometrs();
    }

    @GetMapping("/{id}")
    public ResponseEntityCustomersDto getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public String createCustomer(@RequestBody CreateCustomerDto createCustomerDto) {
        customerService.createCustomer(createCustomerDto);
        return "Customer created";
    }

    @DeleteMapping("/{id}")
    public String deleteCustomerById(@PathVariable Integer id) {
        customerService.deleteCustomerById(id);
        return (id + " customer deleted");
    }

    @PatchMapping("/{id}")
    public String updateCustomer(@PathVariable Integer id,

                                 @RequestBody UpdateCustomerDto updateCustomerDto) {
        UpdateCustomerDto updatedCustomer = customerService.updateCustomer(id, updateCustomerDto);
        return "Customer updated";
    }

}

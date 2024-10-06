package com.bookOline.bookOline.controller;

import com.bookOline.bookOline.dto.CustomerDTO;
import com.bookOline.bookOline.entity.Customer;
import com.bookOline.bookOline.entity.Order;
import com.bookOline.bookOline.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/customers")


public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @RequestMapping
    public List<Customer> getAllCustomers(){
        return customerService.findAllCustometrs();
    }
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Integer id){
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer createCustomer (@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomerById(@PathVariable Integer id){
        customerService.deleteCustomerById(id);
        return (id+" customer deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(
            @PathVariable Integer id,
            @RequestBody CustomerDTO customerDTO) {
        try {
            CustomerDTO updatedCustomer = customerService.updateCustomer(id, customerDTO);
            return ResponseEntity.ok(updatedCustomer);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}

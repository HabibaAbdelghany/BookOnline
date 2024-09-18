package com.bookOline.bookOline.services;

import com.bookOline.bookOline.entity.Customer;
import com.bookOline.bookOline.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
   public List<Customer>findAllCustometrs(){
       return customerRepository.findAll();
   }
}

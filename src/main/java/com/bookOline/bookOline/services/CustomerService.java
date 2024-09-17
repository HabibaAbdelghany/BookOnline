package com.bookOline.bookOline.services;

import com.bookOline.bookOline.ENTITY.Book;
import com.bookOline.bookOline.ENTITY.Customer;
import com.bookOline.bookOline.Repository.BookRepo;
import com.bookOline.bookOline.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
   public List<Customer>findAllCustometrs(){
       return customerRepo.findAll();
   }
}

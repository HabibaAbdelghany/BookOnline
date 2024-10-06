package com.bookOline.bookOline.services;

import com.bookOline.bookOline.dto.CustomerDTO;
import com.bookOline.bookOline.entity.Category;
import com.bookOline.bookOline.entity.Customer;
import com.bookOline.bookOline.entity.Order;
import com.bookOline.bookOline.mapper.CustomerMapper;
import com.bookOline.bookOline.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CustomerService {
    @Autowired
    private  CustomerMapper customerMapper;
    @Autowired
    private CustomerRepository customerRepository;
   public List<Customer>findAllCustometrs(){
       return customerRepository.findAll();
   }
    public Customer getCustomerById(Integer id){
        Optional<Customer>customerOptional=customerRepository.findById(id);{
            return customerOptional .orElse(null);
        }
    }

    public  Customer createCustomer (Customer customer){
       return customerRepository.save(customer);
    }

    public CustomerDTO updateCustomer(Integer id,CustomerDTO customerDTO){
    Customer currentCustomer = customerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found"));

    customerMapper.updateCustomerFromDto(customerDTO, currentCustomer);
    customerRepository.save(currentCustomer);

    return customerMapper.toDTO(currentCustomer);

}




    public void deleteCustomerById (Integer id){
        Optional<Customer>customerOptional=customerRepository.findById(id);
        if (customerOptional.isPresent()){


            customerRepository.deleteById(id);
        }else{
            throw new RuntimeException(id +"this id not exist") ;
        }

    }}

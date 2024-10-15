package com.bookOline.bookOline.services;

import com.bookOline.bookOline.dto.CreateCustomerDto;
import com.bookOline.bookOline.dto.ResponseEntityCustomersDto;
import com.bookOline.bookOline.dto.UpdateCustomerDto;
import com.bookOline.bookOline.entity.Customer;
import com.bookOline.bookOline.mapper.CustomerMapper;
import com.bookOline.bookOline.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerRepository customerRepository;


    /*.map(customer -> RetrieveAllCustomers.builder()...build()):
The map method takes a Function as an argument, which applies a transformation to each element in the stream.
In this case, for each Customer object (customer), a new RetrieveAllCustomers DTO is created using the builder pattern.
The .builder() method creates a builder instance for RetrieveAllCustomers, and you set its properties (like id, name, email, and address) using the get methods from the Customer object.
Finally, .build() creates the RetrieveAllCustomers object.*/
    public List<ResponseEntityCustomersDto> findAllCustometrs() {
        return customerRepository.findAll()
                .stream().map(Customer -> ResponseEntityCustomersDto
                        .builder()
                        .name(Customer.getName()).email(Customer.getEmail()).address(Customer.getAddress()).id(Customer.getId())
                        .build()).collect(Collectors.toList());
    }

    public ResponseEntityCustomersDto getCustomerById(Integer id) {


        return customerRepository.findById(id)
                .map(customer -> ResponseEntityCustomersDto.builder()
                        .id(customer.getId())
                        .name(customer.getName())
                        .email(customer.getEmail())
                        .address(customer.getAddress())
                        .build()
                )
                .orElseThrow(() -> new RuntimeException("Customer not found for id: " + id));


    }

    public void createCustomer(CreateCustomerDto createCustomerDto) {
        Customer createdCustomer = customerMapper.toEntity(createCustomerDto);
        customerRepository.save(createdCustomer);
    }

    public UpdateCustomerDto updateCustomer(Integer id, UpdateCustomerDto updateCustomerDTO) {
        Customer currentCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customerMapper.updateCustomerFromDto(updateCustomerDTO, currentCustomer);
        customerRepository.save(currentCustomer);
        return customerMapper.toDTO(currentCustomer);

    }

    public void deleteCustomerById(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {


            customerRepository.deleteById(id);
        } else {
            throw new RuntimeException(id + "this id not exist");
        }

    }
}

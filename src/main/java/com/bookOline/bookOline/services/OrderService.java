package com.bookOline.bookOline.services;

import com.bookOline.bookOline.entity.Book;
import com.bookOline.bookOline.entity.Category;
import com.bookOline.bookOline.entity.Customer;
import com.bookOline.bookOline.entity.Order;
import com.bookOline.bookOline.repository.BookRepository;
import com.bookOline.bookOline.repository.CustomerRepository;
import com.bookOline.bookOline.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomerRepository customerRepository;
    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer id){
        Optional<Order> orderOptional =orderRepository.findById(id);
        return orderOptional.orElse(null);

    }


    @Transactional
    public Order createOrder(Order order) {
        // Fetch and set the full Customer entity
        Customer customer = customerRepository.findById(order.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        order.setCustomer(customer);

        // Fetch and set the full Book entities
        if (order.getBooks() != null && !order.getBooks().isEmpty()) {
            Set<Book> existingBooks = new HashSet<>(bookRepository.findAllById(
                    order.getBooks().stream().map(Book::getId).collect(Collectors.toList())
            ));
            order.setBooks(existingBooks);
        }

        // Save the order
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

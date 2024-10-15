package com.bookOline.bookOline.services;

import com.bookOline.bookOline.dto.*;
import com.bookOline.bookOline.entity.*;
import com.bookOline.bookOline.mapper.BookOrderMapper;
import com.bookOline.bookOline.mapper.OrderMappper;
import com.bookOline.bookOline.repository.BookOrderRepository;
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
    private OrderMappper orderMappper;
    @Autowired
    private BookOrderMapper bookOrderMapper;
    @Autowired
    BookOrderRepository bookOrderRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<ResponseEntityOrdersDto> findAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(Order -> ResponseEntityOrdersDto
                        .builder().id(Order.getId())
                        .date(Order.getDate())
                        .total_Price(Order.getTotal_Price())
                        .customerId(Order.getCustomer().getId()).build()
                ).collect(Collectors.toList());
    }

    public ResponseEntityOrdersDto getOrderById(Integer id) {
        return orderRepository.findById(id).map(Order -> ResponseEntityOrdersDto
                        .builder().id(Order.getId())
                        .date(Order.getDate())
                        .total_Price(Order.getTotal_Price())
                        .customerId(Order.getCustomer() != null ? Order.getCustomer().getId() : null)
                        .build())

                .orElse(null);

    }

    @Transactional
    public void createOrder(CreateOrderDto createOrderDto) {

        Customer customer = customerRepository.findById(createOrderDto.getCustomer_id())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Set<Book> books = new HashSet<>(bookRepository.findAllById(createOrderDto.getSetBookId()));

        // Create a new Order
        Order order = new Order();
        order.setTotal_Price(createOrderDto.getTotal_Price());
        order.setDate(createOrderDto.getDate());
        order.setCustomer(customer);
        order.setBooks(books);


        // Save the order to the repository
        orderRepository.save(order);


    }

    public void deleteOrderById(Integer id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
//

            orderRepository.deleteById(id);
        } else {
            throw new RuntimeException(id + "this id not exist");
        }

    }

    public void updateBookOrder(Integer id, UpdateBookOrderDto updateBookOrderDto) {
        BookOrder bookOrder = bookOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("this book not found"));
        bookOrderMapper.updateBookOrder(updateBookOrderDto, bookOrder);
        Book newBook = bookRepository.findById(updateBookOrderDto.getBookId())
                .orElseThrow(() -> new RuntimeException("Book with id " + updateBookOrderDto.getBookId() + " not found."));


        bookOrder.setBook(newBook);


        bookOrderRepository.save(bookOrder);

    }


    public void updateOrder(Integer id, UpdateOrderDto updateOrderDto) {
        // Find the order by id
        Order currentOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        Customer customer = customerRepository.findById(updateOrderDto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        currentOrder.setCustomer(customer);
        // Use the mapper to update the current order
        orderMappper.UpdateOrder(updateOrderDto,currentOrder);

        // Save the updated order back to the repository
        orderRepository.save(currentOrder);
    }


}

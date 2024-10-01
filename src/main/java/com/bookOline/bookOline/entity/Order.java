package com.bookOline.bookOline.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;

import java.util.Set;

@Data
@Builder

@AllArgsConstructor
@NoArgsConstructor

@Table(name="orders")
@Entity
public class Order{
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  Integer total_Price;
    private  Date date;
    @ManyToOne
    @JoinColumn(name = "customer_id") // Foreign key column in the Order table
    private Customer customer;




    @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "book_order", // The join table
            joinColumns = @JoinColumn(name = "order_id"), // Foreign key for Order
            inverseJoinColumns = @JoinColumn(name = "book_id") // Foreign key for Book
    )
    private Set<Book> books = new HashSet<>();

}


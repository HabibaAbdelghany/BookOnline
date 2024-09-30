package com.bookOline.bookOline.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
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




    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BookOrder> bookOrders = new HashSet<>();




}


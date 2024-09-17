package com.bookOline.bookOline.ENTITY;

import jakarta.persistence.*;
import lombok.*;

import java.security.PrivateKey;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.List;

@Data
@Builder

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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





@ManyToMany
    @JoinTable(
            name = "order_book",
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
 private List<Book>books;



}


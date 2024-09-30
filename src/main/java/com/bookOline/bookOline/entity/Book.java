package com.bookOline.bookOline.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer price;
    private String description;
    private String  author;
    private  String title;


    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)


    private Set<BookOrder> bookOrders = new HashSet<>();

    @ManyToMany(mappedBy = "books", cascade = { CascadeType.PERSIST, CascadeType.MERGE })

    private Set<Category> categories;


}


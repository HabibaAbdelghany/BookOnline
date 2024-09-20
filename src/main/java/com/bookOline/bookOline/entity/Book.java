package com.bookOline.bookOline.entity;

import jakarta.persistence.*;
import lombok.*;

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


    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    private List<Order> orders;

    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)

    private Set<Category> categories;


}


package com.bookOline.bookOline.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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



    @ManyToMany(mappedBy = "books", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("books")
    private Set<Order> orders = new HashSet<>();


    @ManyToMany(mappedBy = "books", cascade = { CascadeType.PERSIST, CascadeType.MERGE })

    private Set<Category> categories;

}


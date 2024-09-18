package com.bookOline.bookOline.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private String  name;

    @ManyToMany
    @JoinTable(
            name="book_category",
            joinColumns = @JoinColumn(name=  "category_id" ),
            inverseJoinColumns = @JoinColumn(name="book_id"))
    private Set<Book> books;
}

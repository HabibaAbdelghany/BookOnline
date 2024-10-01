package com.bookOline.bookOline.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
    private String name ;
    private String email;
    private String  address;

    @OneToMany(mappedBy = "customer")

    @JsonIgnoreProperties("customer")
    private List<Order> orders;

}


package com.bookOline.bookOline.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
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

    @OneToMany(mappedBy = "customer") // This must match the field name in Order
    private List<Order> orders;

}


package com.bookOline.bookOline.ENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table

public class Customer {
   private Integer id;
    private String name ;
    private String email;
    private String  address;

}

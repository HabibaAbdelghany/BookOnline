package com.bookOline.bookOline.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String address;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns =@JoinColumn(name="user_id") ,
            inverseJoinColumns =@JoinColumn(name="role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "customer")

    @JsonIgnoreProperties("customer")
    private List<Order> orders;





}

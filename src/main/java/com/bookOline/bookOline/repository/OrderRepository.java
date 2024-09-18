package com.bookOline.bookOline.repository;

import com.bookOline.bookOline.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrderRepository extends JpaRepository<Order,Integer>{
}

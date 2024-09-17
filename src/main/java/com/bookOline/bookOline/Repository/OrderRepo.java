package com.bookOline.bookOline.Repository;

import com.bookOline.bookOline.ENTITY.Book;
import com.bookOline.bookOline.ENTITY.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrderRepo extends JpaRepository<Order,Integer>{
}

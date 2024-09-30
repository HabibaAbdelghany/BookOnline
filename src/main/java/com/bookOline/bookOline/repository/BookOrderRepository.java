package com.bookOline.bookOline.repository;

import com.bookOline.bookOline.entity.BookOrder;
import com.bookOline.bookOline.entity.BookOrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookOrderRepository extends JpaRepository<BookOrder,Integer> {
    void deleteById(BookOrderId bookOrderId);
}

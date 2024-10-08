package com.bookOline.bookOline.repository;

import com.bookOline.bookOline.entity.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BookOrderRepository extends JpaRepository<BookOrder,Integer> {
  void deleteByBookId(Integer id);


}

package com.bookOline.bookOline.Repository;

import com.bookOline.bookOline.ENTITY.Book;
import com.bookOline.bookOline.ENTITY.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}

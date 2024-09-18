package com.bookOline.bookOline.repository;

import com.bookOline.bookOline.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}

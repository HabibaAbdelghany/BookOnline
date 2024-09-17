package com.bookOline.bookOline.Repository;

import com.bookOline.bookOline.ENTITY.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}

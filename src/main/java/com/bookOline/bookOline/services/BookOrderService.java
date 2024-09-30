package com.bookOline.bookOline.services;

import com.bookOline.bookOline.entity.BookOrderId;
import com.bookOline.bookOline.repository.BookOrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookOrderService {

    @Autowired
    private BookOrderRepository bookOrderRepository;
     @Transactional
    public void deleteBookFromOrder(Integer bookId, Integer orderId) {
        BookOrderId bookOrderId = new BookOrderId();
        bookOrderId.setBookId(bookId);
        bookOrderId.setOrderId(orderId);

        bookOrderRepository.deleteById(bookOrderId); // Delete the entry
    }
}

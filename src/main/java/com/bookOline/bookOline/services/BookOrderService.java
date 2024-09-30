package com.bookOline.bookOline.services;

import com.bookOline.bookOline.entity.BookOrderId;
import com.bookOline.bookOline.repository.BookOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookOrderService {
    @Autowired
           private BookOrderRepository bookOrderRepository;

            public ResponseEntity<Void> deleteBookFromOrder(Integer bookId, Integer orderId) {
                BookOrderId bookOrderId = new BookOrderId();
                bookOrderId.setBookId(bookId);
                bookOrderId.setOrderId(orderId);
                bookOrderRepository.deleteById(bookOrderId);

            }
}

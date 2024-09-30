package com.bookOline.bookOline.controller;

import com.bookOline.bookOline.services.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/book-orders")
public class BookOrderController {
    @Autowired
    BookOrderService bookOrderService;
    @DeleteMapping("/{bookId}/{orderId}")
    public ResponseEntity<Void> deleteBookFromOrder(@PathVariable Integer bookId, @PathVariable Integer orderId) {
        bookOrderService.deleteBookFromOrder(bookId, orderId);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }

}
package com.bookOline.bookOline.controller;

import com.bookOline.bookOline.entity.Book;
import com.bookOline.bookOline.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/allbooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}

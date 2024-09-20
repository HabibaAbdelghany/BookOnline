package com.bookOline.bookOline.controller;

import com.bookOline.bookOline.entity.Book;
import com.bookOline.bookOline.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }


    @GetMapping("/{id}")
    public Book  getBookById(@PathVariable Integer id){
        return bookService.getBookById(id);
    }

    @PostMapping
     public  Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }
    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable Integer id) {
        bookService.deleteBookById(id);
        return "Book deleted successfully with id: " + id;
    }

//    // Update a book by its ID
//    @PutMapping("/{id}")
//    public Book updateBook(@PathVariable Integer id, @RequestBody Book bookDetails) {
//        return bookService.updateBook(id, bookDetails);
//    }
//













}

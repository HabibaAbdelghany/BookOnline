package com.bookOline.bookOline.controller;

import com.bookOline.bookOline.dto.*;
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
    public List<ResponseEntityBooksDto> getAllBooks() {
        return bookService.getAllBooks();
    }


    @GetMapping("/{id}")
    public ResponseEntityBooksDto  getBookById(@PathVariable Integer id){
        return bookService.getBookById(id);
    }

    @PostMapping
     public String createBook(@RequestBody CreateBookDto createBookDto){
         bookService.createBookDto(createBookDto);
         return  "Book created";
    }

    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable Integer id) {
        bookService.deleteBookById(id);
        return "Book deleted successfully with id: " + id;
    }

    @PatchMapping("/{id}")
    public  String updateBook(
          @PathVariable Integer id ,
          @RequestBody UpdateBookDTO updateBookDTO
          ){
        bookService.updateBook(id,updateBookDTO);
        return"Book Updated";
  }












}

package com.bookOline.bookOline.services;

import com.bookOline.bookOline.ENTITY.Book;
import com.bookOline.bookOline.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }
}

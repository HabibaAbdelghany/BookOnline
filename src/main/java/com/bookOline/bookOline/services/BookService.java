package com.bookOline.bookOline.services;

import com.bookOline.bookOline.entity.Book;
import com.bookOline.bookOline.entity.Customer;
import com.bookOline.bookOline.repository.BookOrderRepository;
import com.bookOline.bookOline.repository.BookRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    BookOrderRepository bookOrderRepository;


    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }


    public Book getBookById(Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.orElse(null);
    }

    public Book createBook (Book book){
        return bookRepository.save(book);
    }
    @Transactional
  public void deleteBookById (Integer id){
    bookOrderRepository.deleteByBookId(id);
    bookRepository.deleteById(id);
}
}













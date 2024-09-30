package com.bookOline.bookOline.services;

import com.bookOline.bookOline.entity.Book;
import com.bookOline.bookOline.entity.Order;
import com.bookOline.bookOline.repository.BookRepository;
import com.bookOline.bookOline.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    private OrderRepository orderRepository;

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

  public void deleteBookById (Integer id){
        Optional<Book>bookOptional=bookRepository.findById(id);
        if (bookOptional.isPresent()){
      Book book = bookOptional.get();

            bookRepository.deleteById(id);
    }else{
            throw new RuntimeException(id +"this id not exist") ;
        }

  }
















}



















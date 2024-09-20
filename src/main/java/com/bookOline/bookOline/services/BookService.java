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
//        List<Order> orders = orderRepository.findAll();
//        for (Order order:orders){
//             order.getBooks().removeIf(book -> book.getId().equals(id));
//        }

            bookRepository.deleteById(id);
    }else{
            throw new RuntimeException(id +"this id not exist") ;
        }

  }
//
//    public void deleteBookById(Integer id) {
//        // Fetch all orders related to the book
//        List<Order> orders = orderRepository.findByBooksId(id);
//
//        // Delete each order
//        for (Order order : orders) {
//            orderRepository.delete(order);
//        }
//
//        // Now delete the book
//        bookRepository.deleteById(id);
//    }
//
//
//
//
//
















    // Update a book
//    public Book updateBook(Integer id, Book bookDetails) {
//        Book existingBook = bookRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
//        existingBook.setTitle(bookDetails.getTitle());
//        existingBook.setAuthor(bookDetails.getAuthor());
//        existingBook.setPrice(bookDetails.getPrice());
//        // Set other fields as needed
//
//        return bookRepository.save(existingBook);
//    }
}



















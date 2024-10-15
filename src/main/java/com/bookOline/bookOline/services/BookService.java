package com.bookOline.bookOline.services;

import com.bookOline.bookOline.dto.*;
import com.bookOline.bookOline.entity.Book;
import com.bookOline.bookOline.mapper.BookMapper;
import com.bookOline.bookOline.mapper.BookOrderMapper;
import com.bookOline.bookOline.repository.BookOrderRepository;
import com.bookOline.bookOline.repository.BookRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookOrderMapper bookOrderMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    BookOrderRepository bookOrderRepository;


    public List<ResponseEntityBooksDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(Book -> ResponseEntityBooksDto.builder()
                        .title(Book.getTitle())
                        .price(Book.getPrice())
                        .author(Book.getAuthor())
                        .description(Book.getDescription())
                        .id(Book.getId()).build()).collect(Collectors.toList());
    }


    public ResponseEntityBooksDto getBookById(Integer id) {
        return bookRepository.findById(id)
                .map(Book -> ResponseEntityBooksDto
                        .builder()
                        .title(Book.getTitle())
                        .price(Book.getPrice())
                        .author(Book.getAuthor())
                        .description(Book.getDescription())
                        .id(Book.getId())
                        .build())
                .orElseThrow(() -> new RuntimeException("Customer not found for id: " + id));


    }


    public void createBookDto(CreateBookDto createBookDto) {
        Book book = BookMapper.instance.toEntity(createBookDto);
        bookRepository.save(book);
    }

    @Transactional
    public void deleteBookById(Integer id) {
        bookOrderRepository.deleteByBookId(id);
        bookRepository.deleteById(id);
    }

    public void updateBook(Integer id, UpdateBookDTO updateBookDTO) {
        Book currentBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("this book not found"));
        bookMapper.updateBookFromDto(updateBookDTO, currentBook);
        bookRepository.save(currentBook);

    }


}













package com.bookOline.bookOline.mapper;

import com.bookOline.bookOline.dto.CreateBookDto;
import com.bookOline.bookOline.dto.ResponseEntityBooksDto;
import com.bookOline.bookOline.dto.UpdateBookDTO;
import com.bookOline.bookOline.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper instance = Mappers.getMapper(BookMapper.class);

    Book toEntity(CreateBookDto createBookDto);

    Book toEntity(ResponseEntityBooksDto retrieveAllBooksDto);

    UpdateBookDTO toDTO(Book book);

    Book toEntity(UpdateBookDTO updateBookDTO);

    void updateBookFromDto(UpdateBookDTO updateBookDTO, @MappingTarget Book book);
}

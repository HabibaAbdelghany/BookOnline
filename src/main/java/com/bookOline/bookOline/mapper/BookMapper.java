package com.bookOline.bookOline.mapper;

import com.bookOline.bookOline.dto.UpdateBookDTO;
import com.bookOline.bookOline.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
    UpdateBookDTO toDTO (Book book);
    Book toEntity (UpdateBookDTO updateBookDTO);
    void updateBookFromDto(UpdateBookDTO updateBookDTO, @MappingTarget Book book);
}

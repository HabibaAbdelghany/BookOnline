package com.bookOline.bookOline.mapper;

import com.bookOline.bookOline.dto.UpdateBookDTO;
import com.bookOline.bookOline.dto.UpdateBookOrderDto;
import com.bookOline.bookOline.entity.Book;
import com.bookOline.bookOline.entity.BookOrder;
import com.bookOline.bookOline.repository.BookRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface BookOrderMapper {
    UpdateBookOrderDto toDto(BookOrder bookOrder);

}
package com.bookOline.bookOline.mapper;

import com.bookOline.bookOline.dto.UpdateBookDTO;
import com.bookOline.bookOline.dto.UpdateBookOrderDto;
import com.bookOline.bookOline.entity.BookOrder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookOrderMapper {
    UpdateBookOrderDto toDto(BookOrder bookOrder);
     void  updateBookOrder(UpdateBookOrderDto updateBookOrderDto,@MappingTarget BookOrder bookOrder);

}

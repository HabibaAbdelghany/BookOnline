package com.bookOline.bookOline.dto;

import com.bookOline.bookOline.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateBookOrderDto {
    private Integer bookId;

}

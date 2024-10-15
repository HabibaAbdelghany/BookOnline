package com.bookOline.bookOline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseEntityBooksDto {
    private Integer id;
    private Integer price;
    private String description;
    private String author;
    private String title;

}

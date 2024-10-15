package com.bookOline.bookOline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreateBookDto {

    private Integer price;
    private String description;
    private String  author;
    private  String title;

}

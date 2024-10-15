package com.bookOline.bookOline.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseEntityCategoriesDto {
    private Integer id;
    private String description;
    private String name;
}

package com.bookOline.bookOline.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private Integer id;
    private String name ;
    private String email;
    private String  address;
}

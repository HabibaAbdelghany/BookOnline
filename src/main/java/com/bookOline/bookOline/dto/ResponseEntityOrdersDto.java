package com.bookOline.bookOline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ResponseEntityOrdersDto {
    private  Integer id;
    private  Integer total_Price;
    private Date date;
    private Integer customerId;
}

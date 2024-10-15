package com.bookOline.bookOline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UpdateOrderDto {
    private  Integer total_Price;
    private Date date;
    private Integer customerId;
}

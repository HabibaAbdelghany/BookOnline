package com.bookOline.bookOline.dto;

import com.bookOline.bookOline.entity.Book;
import com.bookOline.bookOline.entity.Customer;
import jakarta.transaction.UserTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateOrderDto {
    private Integer total_Price;
    private Date date;
    private Integer customer_id;
    //TO REPRESENT BOOK ID
    private Set<Integer> setBookId;
}

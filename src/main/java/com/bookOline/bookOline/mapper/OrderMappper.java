package com.bookOline.bookOline.mapper;

import com.bookOline.bookOline.dto.CreateOrderDto;
import com.bookOline.bookOline.dto.UpdateOrderDto;
import com.bookOline.bookOline.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMappper {
    Order toEntity(UpdateOrderDto updateOrderDto);

    Order toEntity(CreateOrderDto createOrderDto);

    CreateOrderDto toDto(Order order);

    void UpdateOrder(UpdateOrderDto updateOrderDto, @MappingTarget Order order);

}

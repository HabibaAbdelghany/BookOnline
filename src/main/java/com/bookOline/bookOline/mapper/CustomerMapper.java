package com.bookOline.bookOline.mapper;

import com.bookOline.bookOline.dto.UpdateCustomerDto;
import com.bookOline.bookOline.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
   UpdateCustomerDto toDTO(Customer customer);

    Customer toEntity(UpdateCustomerDto updateCustomerDto );
    void  updateCustomerFromDto(UpdateCustomerDto dto , @MappingTarget Customer customer);
}

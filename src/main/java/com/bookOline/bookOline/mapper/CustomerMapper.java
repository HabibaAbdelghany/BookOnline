package com.bookOline.bookOline.mapper;

import com.bookOline.bookOline.dto.CustomerDTO;
import com.bookOline.bookOline.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDTO(Customer customer);

    Customer toEntity(CustomerDTO customerDTO);
    void  updateCustomerFromDto(CustomerDTO dto , @MappingTarget Customer customer);
}

package com.bookOline.bookOline.mapper;

import com.bookOline.bookOline.dto.CreateCustomerDto;
import com.bookOline.bookOline.dto.ResponseEntityCustomersDto;
import com.bookOline.bookOline.dto.UpdateCustomerDto;
import com.bookOline.bookOline.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper instance = Mappers.getMapper(CustomerMapper.class);

    UpdateCustomerDto toDTO(Customer customer);

    Customer toEntity(CreateCustomerDto createCustomerDto);

    //  Customer toEntity(UpdateCustomerDto updateCustomerDto );
    //  Customer toEntity(ResponseEntityCustomersDto retrieveAllCustomers);
    void updateCustomerFromDto(UpdateCustomerDto dto, @MappingTarget Customer customer);
}

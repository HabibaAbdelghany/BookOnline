package com.bookOline.bookOline.mapper;

import com.bookOline.bookOline.dto.UpdateCategoryDto;
import com.bookOline.bookOline.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper (componentModel = "spring")
public interface CategoryMapper {
    UpdateCategoryDto toDTO (Category category);
    Category toEntity (UpdateCategoryDto updateCategoryDto);
    void updateCategoryFromDto(UpdateCategoryDto updateCategoryDto, @MappingTarget Category category);

}

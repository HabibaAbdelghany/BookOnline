package com.bookOline.bookOline.services;

import com.bookOline.bookOline.dto.CreateCategoryDto;
import com.bookOline.bookOline.dto.ResponseEntityCategoriesDto;
import com.bookOline.bookOline.dto.UpdateCategoryDto;
import com.bookOline.bookOline.entity.Category;
import com.bookOline.bookOline.mapper.CategoryMapper;
import com.bookOline.bookOline.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class CategoryService {
    @Autowired

    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<ResponseEntityCategoriesDto> findAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(Category -> ResponseEntityCategoriesDto
                        .builder()
                        .id(Category.getId())
                        .description(Category.getDescription())
                        .name(Category.getName())
                        .build()
                ).collect(Collectors.toList());
    }


    public ResponseEntityCategoriesDto getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .map(Category -> ResponseEntityCategoriesDto
                        .builder()
                        .description(Category.getDescription())
                        .name(Category.getName())
                        .id(Category.getId())
                        .build()).orElse(null);


    }

    public void createCategory(CreateCategoryDto createCategoryDto) {
        Category createdCategory = categoryMapper.toEntity(createCategoryDto);
        categoryRepository.save(createdCategory);
    }

    public void deleteCategoryById(Integer id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            categoryRepository.deleteById(id);

        } else {
            throw new RuntimeException("category not exist");
        }

    }

    public void updateCategory(Integer id, UpdateCategoryDto updateCategoryDTO) {
        Category currentCategory = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("category not found"));
        categoryMapper.updateCategoryFromDto(updateCategoryDTO, currentCategory);
        categoryRepository.save(currentCategory);
    }

}

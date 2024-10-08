package com.bookOline.bookOline.services;

import com.bookOline.bookOline.dto.UpdateCategoryDto;
import com.bookOline.bookOline.entity.Category;
import com.bookOline.bookOline.mapper.CategoryMapper;
import com.bookOline.bookOline.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CategoryService
{ @Autowired

private CategoryMapper categoryMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category>findAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer id){
        Optional <Category> categoryOptional =categoryRepository.findById(id);
        return categoryOptional.orElse(null);


    }
    public  Category createCategory(Category category){
       return  categoryRepository.save(category);
    }

    public  void  deleteCategoryById(Integer id){
        Optional<Category>categoryOptional=categoryRepository.findById(id);
        if (categoryOptional.isPresent()){
            categoryRepository.deleteById(id);

        }else {
            throw new RuntimeException("category not exist");
        }

 }
    public  void  updateCategory(Integer id ,  UpdateCategoryDto updateCategoryDTO){
        Category currentCategory =categoryRepository.findById(id).orElseThrow(()->new RuntimeException("category not found"));
        categoryMapper.updateCategoryFromDto(updateCategoryDTO,currentCategory);
        categoryRepository.save(currentCategory);
    }

}

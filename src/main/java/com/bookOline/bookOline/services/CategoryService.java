package com.bookOline.bookOline.services;

import com.bookOline.bookOline.entity.Category;
import com.bookOline.bookOline.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CategoryService
{    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category>findAllCategories(){
        return categoryRepository.findAll();
    }
}

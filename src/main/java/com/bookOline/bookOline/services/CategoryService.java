package com.bookOline.bookOline.services;

import com.bookOline.bookOline.ENTITY.Category;
import com.bookOline.bookOline.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CategoryService
{    @Autowired
    private CategoryRepo categoryRepo;
    public List<Category>findAllCategories(){
        return categoryRepo.findAll();
    }
}

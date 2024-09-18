package com.bookOline.bookOline.controller;

import com.bookOline.bookOline.entity.Category;
import com.bookOline.bookOline.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/allCategories")
    public List<Category>getAllCategories(){
        return categoryService.findAllCategories();
    }


}

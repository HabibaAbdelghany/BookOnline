package com.bookOline.bookOline.controller;

import com.bookOline.bookOline.entity.Category;
import com.bookOline.bookOline.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public List<Category>getAllCategories(){
        return categoryService.findAllCategories();
    }
    @GetMapping("/{id}")
     public  Category getCategoryById(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }
    @PostMapping
    public  Category createCategory(@RequestBody Category category){
       return  categoryService.createCategory(category);
    }
    @DeleteMapping("/{id}")
    public String deleteCategoryById(@PathVariable Integer id){
        categoryService.deleteCategoryById(id);
        return (id+" category deleted");
    }

}

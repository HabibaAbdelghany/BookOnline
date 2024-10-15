package com.bookOline.bookOline.controller;

import com.bookOline.bookOline.dto.CreateCategoryDto;
import com.bookOline.bookOline.dto.ResponseEntityCategoriesDto;
import com.bookOline.bookOline.dto.UpdateCategoryDto;
import com.bookOline.bookOline.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public List<ResponseEntityCategoriesDto>getAllCategories(){
        return categoryService.findAllCategories();
    }
    @GetMapping("/{id}")
     public ResponseEntityCategoriesDto getCategoryById(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }
    @PostMapping
    public  String  createCategory(@RequestBody CreateCategoryDto createCategoryDto){
               categoryService.createCategory(createCategoryDto);
        return"Category Created";

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Integer id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok(id + " category deleted");
    }


    @PatchMapping("/{id}")
    public  String updateCategory(
            @PathVariable Integer id,
            @RequestBody UpdateCategoryDto updateCategoryDto
            ){categoryService.updateCategory(id,updateCategoryDto);
        return "Category updated";
    }

}

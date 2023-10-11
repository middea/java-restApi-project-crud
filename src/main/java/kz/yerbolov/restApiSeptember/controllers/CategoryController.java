package kz.yerbolov.restApiSeptember.controllers;

import kz.yerbolov.restApiSeptember.entities.Category;
import kz.yerbolov.restApiSeptember.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public List <Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @GetMapping(value = "/{id}")
    public Category getCategory(@PathVariable("id") Long id){
        return categoryService.getCategory(id);
    }
    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }
    @PutMapping
    public Category updCategory(@RequestBody Category updatedCategory){
        return categoryService.updateCategory(updatedCategory);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
    }
}

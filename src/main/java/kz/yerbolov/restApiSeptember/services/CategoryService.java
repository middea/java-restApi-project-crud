package kz.yerbolov.restApiSeptember.services;

import kz.yerbolov.restApiSeptember.entities.Category;

import java.util.List;

public interface CategoryService {
    Category addCategory(Category category);
    List <Category> getAllCategories();
    Category getCategory(Long id);
    Category updateCategory(Category updCategory);
    void deleteCategory(Long id);

}

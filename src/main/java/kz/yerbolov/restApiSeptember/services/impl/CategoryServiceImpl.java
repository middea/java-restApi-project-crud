package kz.yerbolov.restApiSeptember.services.impl;

import kz.yerbolov.restApiSeptember.entities.Category;
import kz.yerbolov.restApiSeptember.repositories.CategoryRepository;
import kz.yerbolov.restApiSeptember.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findAllById(id);
    }

    @Override
    public Category updateCategory(Category updCategory) {
        Category category = categoryRepository.findAllById(updCategory.getId());
        category.setName(updCategory.getName());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}

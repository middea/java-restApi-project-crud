package kz.yerbolov.restApiSeptember.controllers;

import kz.yerbolov.restApiSeptember.entities.Category;
import kz.yerbolov.restApiSeptember.services.CategoryService;
import kz.yerbolov.restApiSeptember.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/front")
public class HomeController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ItemService itemService;
    @GetMapping(value = "/home")
    public String openHome(){
        return "home";
    }
    @GetMapping(value = "/add-item")
    public String openAddItem(Model model){
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "add-item";
    }
    @GetMapping(value = "/details/{id}")
    public String openDetails(@PathVariable("id") Long id, Model model){
        model.addAttribute("item", itemService.getItem(id));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "details";
    }
    @GetMapping(value = "/login")
    public String openLoginPage(){
        return "login";
    }
}

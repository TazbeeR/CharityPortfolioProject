package pl.coderslab.charity.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.service.CategoryService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    public String getCategories(Model model){
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        return "admin/category";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("category", new Category());
        return "admin/categoryinfo";
    }

    @PostMapping("/add")
    public String addCategory (@Valid Category category, BindingResult result){
        if (result.hasErrors()){
            return "admin/categoryinfo";
        }
        categoryService.add(category);
        return "redirect:/admin/category/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id){
        Category category = categoryService.findById(id).orElseThrow(EntityNotFoundException::new);
        categoryService.remove(category);
        return "redirect:/admin/category/all";
    }

    @GetMapping("/update/{id}")
    public String editCategory(@PathVariable Long id, Model model){
        Category category = categoryService.findById(id).orElseThrow(EntityNotFoundException::new);
        model.addAttribute("category", category);
        return "admin/categoryinfo";
    }

    @PostMapping("/update/{id}")
    public String updateCategory(@Valid Category category, BindingResult result){
        if (result.hasErrors()){
            return "admin/categoryinfo";
        }
        categoryService.update(category);
        return "redirect:/admin/category/all";
    }

}

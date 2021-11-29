package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Category;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {

    List<Category> getCategories();
    Optional<Category> findById(Long id);
    void add (Category category);
    void update(Category category);
    void remove(Category category);

}

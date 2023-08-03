package ro.sda.eventsFinalProject.service;

import org.springframework.stereotype.Service;
import ro.sda.eventsFinalProject.model.Category;
import ro.sda.eventsFinalProject.model.Event;
import ro.sda.eventsFinalProject.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category saveCategory(Category categoryToBeSaved) {
        if (categoryToBeSaved == null) {
            throw new IllegalArgumentException("An category must have body!");
        }
        if (categoryToBeSaved.getName() == null) {
            throw new IllegalArgumentException("An event must have a name!");
        }

        Category saveCategory = categoryRepository.save(categoryToBeSaved);
        return saveCategory;
    }

    public Category readCategory(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Category id must not be null!");
        }
        Category category = categoryRepository.findById(id).orElse(null);
        if (category == null) {
            throw new IllegalArgumentException("There it is no category with id: " + id);
        }
        return category;
    }

    public List<Category> readAllCategories() {
        return categoryRepository.findAll();
    }

    public Category categoryUpdate(Category updatedCategory){
        if(updatedCategory == null){
            throw new IllegalArgumentException("An category cant be null");
        }
        Category categoryToUpdate = readCategory(updatedCategory.getId());
        categoryRepository.save(updatedCategory);
        return categoryToUpdate;
    }
    public void deleteOneCategory(Integer id) {
        Category categoryToBeDeleted = readCategory(id);
        categoryRepository.delete(categoryToBeDeleted);
    }
    public void deleteAllCategory() {
        categoryRepository.deleteAll();
    }
}

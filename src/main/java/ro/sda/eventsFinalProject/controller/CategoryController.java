package ro.sda.eventsFinalProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.eventsFinalProject.model.Category;
import ro.sda.eventsFinalProject.service.CategoryService;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(path = "category")
    public ResponseEntity createCategory(@RequestBody Category category) {
        if (category.getId() != null) {
            return new ResponseEntity<>("The id must be empty", HttpStatus.BAD_REQUEST);
        }
        try {
            Category savedCategory = categoryService.saveCategory(category);
            return new ResponseEntity(savedCategory, HttpStatus.OK);
        } catch (IllegalArgumentException iAE) {
            return new ResponseEntity(iAE.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity readCategory(@PathVariable(name = "id") Integer categoryId) {
        try {
            Category readCategory = categoryService.readCategory(categoryId);
            return new ResponseEntity(readCategory, HttpStatus.OK);
        } catch (IllegalArgumentException iAE) {
            return new ResponseEntity(iAE.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/category/all")
    public ResponseEntity readAllCategory() {
        List<Category> allCategory = categoryService.readAllCategories();
        return new ResponseEntity(allCategory, HttpStatus.OK);
    }

    @PutMapping("/category/update/{id}")
    public ResponseEntity update(@PathVariable(name = "id") Integer pathId, @RequestBody Category updateCategory) {
        if (!pathId.equals(updateCategory.getId())) {
            return new ResponseEntity("Inconsistent ID", HttpStatus.BAD_REQUEST);
        }
        try {
            Category update = categoryService.categoryUpdate(updateCategory);
            return new ResponseEntity<>(update, HttpStatus.OK);
        } catch (IllegalArgumentException iAE) {
            return new ResponseEntity(iAE.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/category/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            categoryService.deleteOneCategory(id);
            return new ResponseEntity("Category deleted was successfully", HttpStatus.OK);
        } catch (IllegalArgumentException iAE) {
            return new ResponseEntity<>(iAE.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/category/deleteAll")
    public ResponseEntity deleteAllCategories(){
        try{
            categoryService.deleteAllCategory();
            return new ResponseEntity<>("All categories was deleted", HttpStatus.OK);
        } catch (IllegalArgumentException iAE){
            return new ResponseEntity<>(iAE.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

package ro.sda.eventsFinalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.eventsFinalProject.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

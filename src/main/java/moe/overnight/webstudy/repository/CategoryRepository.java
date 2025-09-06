package moe.overnight.webstudy.repository;

import moe.overnight.webstudy.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for managing {@link Category} entities.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

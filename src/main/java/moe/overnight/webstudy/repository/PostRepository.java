package moe.overnight.webstudy.repository;

import moe.overnight.webstudy.domain.category.Category;
import moe.overnight.webstudy.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository exposing persistence operations for {@link Post} entities.
 */
public interface PostRepository extends JpaRepository<Post, Long> {
    /**
     * Finds all posts within a particular {@link Category}.
     */
    List<Post> findByCategory(Category category);
}

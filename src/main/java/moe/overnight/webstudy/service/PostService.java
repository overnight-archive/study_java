package moe.overnight.webstudy.service;

import lombok.RequiredArgsConstructor;
import moe.overnight.webstudy.domain.category.Category;
import moe.overnight.webstudy.domain.post.Post;
import moe.overnight.webstudy.domain.user.User;
import moe.overnight.webstudy.repository.CategoryRepository;
import moe.overnight.webstudy.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service layer for managing posts. The service encapsulates business
 * logic and uses repositories to interact with the database.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    /**
     * Creates a new post within a given category.
     */
    public Post createPost(String title, String content, Long categoryId, User author) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        Post post = Post.builder()
                .title(title)
                .content(content)
                .category(category)
                .author(author)
                .createdAt(LocalDateTime.now())
                .build();
        return postRepository.save(post);
    }

    /**
     * Returns all posts for a category.
     */
    public List<Post> listByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        return postRepository.findByCategory(category);
    }
}

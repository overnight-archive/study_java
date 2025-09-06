package moe.overnight.webstudy.controller;

import lombok.RequiredArgsConstructor;
import moe.overnight.webstudy.domain.post.Post;
import moe.overnight.webstudy.domain.user.User;
import moe.overnight.webstudy.service.PostService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST endpoints for managing posts.
 */
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public Post create(@RequestParam String title,
                       @RequestParam String content,
                       @RequestParam Long categoryId,
                       @AuthenticationPrincipal User user) {
        return postService.createPost(title, content, categoryId, user);
    }

    @GetMapping("/category/{categoryId}")
    public List<Post> list(@PathVariable Long categoryId) {
        return postService.listByCategory(categoryId);
    }
}

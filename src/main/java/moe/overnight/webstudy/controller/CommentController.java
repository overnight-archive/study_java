package moe.overnight.webstudy.controller;

import lombok.RequiredArgsConstructor;
import moe.overnight.webstudy.domain.comment.Comment;
import moe.overnight.webstudy.domain.user.User;
import moe.overnight.webstudy.service.CommentService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Endpoints for creating and viewing comments.
 */
@RestController
@RequestMapping("/posts/{postId}/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public Comment add(@PathVariable Long postId,
                       @RequestParam String content,
                       @RequestParam(required = false) Long parentId,
                       @AuthenticationPrincipal User user) {
        return commentService.addComment(postId, parentId, content, user);
    }

    @GetMapping
    public List<Comment> list(@PathVariable Long postId) {
        return commentService.listByPost(postId);
    }
}

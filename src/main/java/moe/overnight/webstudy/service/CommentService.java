package moe.overnight.webstudy.service;

import lombok.RequiredArgsConstructor;
import moe.overnight.webstudy.domain.comment.Comment;
import moe.overnight.webstudy.domain.post.Post;
import moe.overnight.webstudy.domain.user.User;
import moe.overnight.webstudy.repository.CommentRepository;
import moe.overnight.webstudy.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service responsible for managing comments and replies.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    /**
     * Adds a comment or reply to a post.
     * @param postId   the id of the post being commented on
     * @param parentId optional parent comment id for replies
     */
    public Comment addComment(Long postId, Long parentId, String content, User author) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));
        Comment.CommentBuilder builder = Comment.builder()
                .post(post)
                .author(author)
                .content(content)
                .createdAt(LocalDateTime.now());
        if (parentId != null) {
            Comment parent = commentRepository.findById(parentId)
                    .orElseThrow(() -> new IllegalArgumentException("Parent comment not found"));
            builder.parent(parent);
        }
        return commentRepository.save(builder.build());
    }

    /**
     * Lists comments for a post.
     */
    public List<Comment> listByPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));
        return commentRepository.findByPost(post);
    }
}

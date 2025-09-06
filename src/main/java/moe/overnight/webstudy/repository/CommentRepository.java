package moe.overnight.webstudy.repository;

import moe.overnight.webstudy.domain.comment.Comment;
import moe.overnight.webstudy.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for {@link Comment} entities.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    /**
     * Returns all comments belonging to the given post.
     */
    List<Comment> findByPost(Post post);
}

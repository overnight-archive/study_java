package moe.overnight.webstudy.domain.comment;

import jakarta.persistence.*;
import lombok.*;
import moe.overnight.webstudy.domain.post.Post;
import moe.overnight.webstudy.domain.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Comment entity supporting nested replies through a self-referencing
 * parent-child relationship.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Post post;

    @ManyToOne(optional = false)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> children = new ArrayList<>();

    @Lob
    private String content;

    private LocalDateTime createdAt;
}

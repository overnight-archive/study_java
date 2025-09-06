package moe.overnight.webstudy.domain.post;

import jakarta.persistence.*;
import lombok.*;
import moe.overnight.webstudy.domain.category.Category;
import moe.overnight.webstudy.domain.user.User;

import java.time.LocalDateTime;

/**
 * Entity representing a board post. Each post belongs to a {@link Category}
 * and has an author {@link User}.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Lob
    private String content;

    @ManyToOne(optional = false)
    private User author;

    @ManyToOne(optional = false)
    private Category category;

    private LocalDateTime createdAt;
}

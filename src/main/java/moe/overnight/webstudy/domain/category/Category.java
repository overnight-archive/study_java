package moe.overnight.webstudy.domain.category;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents a discussion board category. Posts are grouped by categories
 * to provide a better user experience.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Human readable category name. */
    @Column(nullable = false, unique = true)
    private String name;
}

package moe.overnight.webstudy.domain.notification;

import jakarta.persistence.*;
import lombok.*;
import moe.overnight.webstudy.domain.user.User;

import java.time.LocalDateTime;

/**
 * Simple notification entity storing a message for a user.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private User user;

    private String message;

    private boolean read;

    private LocalDateTime createdAt;
}

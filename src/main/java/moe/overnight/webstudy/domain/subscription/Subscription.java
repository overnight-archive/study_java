package moe.overnight.webstudy.domain.subscription;

import jakarta.persistence.*;
import lombok.*;
import moe.overnight.webstudy.domain.user.User;

import java.time.LocalDate;

/**
 * Represents a user's monthly subscription.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private SubscriptionPlan plan;

    private LocalDate startDate;

    private boolean active;
}

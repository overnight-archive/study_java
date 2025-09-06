package moe.overnight.webstudy.repository;

import moe.overnight.webstudy.domain.subscription.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for handling {@link Subscription} persistence.
 */
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}

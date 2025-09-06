package moe.overnight.webstudy.service;

import lombok.RequiredArgsConstructor;
import moe.overnight.webstudy.domain.subscription.Subscription;
import moe.overnight.webstudy.domain.subscription.SubscriptionPlan;
import moe.overnight.webstudy.domain.user.User;
import moe.overnight.webstudy.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * Service handling monthly subscription logic.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    /**
     * Subscribes a user to a given plan. In a real application payment handling
     * would occur before activation.
     */
    public Subscription subscribe(User user, SubscriptionPlan plan) {
        Subscription subscription = Subscription.builder()
                .user(user)
                .plan(plan)
                .startDate(LocalDate.now())
                .active(true)
                .build();
        return subscriptionRepository.save(subscription);
    }
}

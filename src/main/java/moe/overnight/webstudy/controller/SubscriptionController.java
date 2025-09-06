package moe.overnight.webstudy.controller;

import lombok.RequiredArgsConstructor;
import moe.overnight.webstudy.domain.subscription.Subscription;
import moe.overnight.webstudy.domain.subscription.SubscriptionPlan;
import moe.overnight.webstudy.domain.user.User;
import moe.overnight.webstudy.service.SubscriptionService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller handling subscription endpoints.
 */
@RestController
@RequestMapping("/subscription")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping
    public Subscription subscribe(@RequestParam SubscriptionPlan plan,
                                  @AuthenticationPrincipal User user) {
        return subscriptionService.subscribe(user, plan);
    }
}

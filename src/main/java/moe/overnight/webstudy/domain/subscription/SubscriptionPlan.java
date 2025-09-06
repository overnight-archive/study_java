package moe.overnight.webstudy.domain.subscription;

/**
 * Available subscription plans for the service. Pricing or feature details
 * would typically be stored elsewhere; here we only model plan identity.
 */
public enum SubscriptionPlan {
    BASIC,
    STANDARD,
    PRO
}

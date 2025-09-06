package moe.overnight.webstudy.domain.user;

/**
 * Enumeration of roles for application users. Using an enum makes it easy
 * to provide type safety and integrate with Spring Security's authority model.
 */
public enum UserRole {
    USER,
    ADMIN
}

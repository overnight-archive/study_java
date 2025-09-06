package moe.overnight.webstudy.domain.user;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * JPA entity representing users of the system.
 * <p>
 * The class implements {@link UserDetails} so that instances can be used
 * directly by Spring Security's authentication infrastructure.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    /** Unique surrogate key for the user. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Login identifier used for form based authentication. */
    @Column(nullable = false, unique = true)
    private String username;

    /** Bcrypt encoded password. */
    @Column(nullable = false)
    private String password;

    /** User's e-mail address for contact and OAuth2 mapping. */
    @Column(nullable = false, unique = true)
    private String email;

    /** Display name and short bio for profile functionality. */
    private String displayName;
    private String bio;

    /** Role of the user. */
    @Enumerated(EnumType.STRING)
    private UserRole role;

    // --- UserDetails implementation ---

    /**
     * Returns authorities granted to the user. Spring Security expects a collection
     * of {@link GrantedAuthority} instances representing roles or permissions.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // account expiration is not tracked in this sample
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // account locking not implemented for brevity
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // credentials expiration not tracked
    }

    @Override
    public boolean isEnabled() {
        return true; // all users are enabled by default
    }
}

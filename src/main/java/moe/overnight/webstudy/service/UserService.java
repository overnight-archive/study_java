package moe.overnight.webstudy.service;

import lombok.RequiredArgsConstructor;
import moe.overnight.webstudy.domain.user.User;
import moe.overnight.webstudy.domain.user.UserRole;
import moe.overnight.webstudy.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Application service dealing with user registration and lookup. Annotated with
 * {@link Service} to mark it as a Spring component and {@link Transactional}
 * to ensure that database operations are executed within a transaction.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Registers a new user. Password is encoded using the injected
     * {@link PasswordEncoder} implementation (BCrypt by default).
     */
    public User register(String username, String password, String email) {
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .role(UserRole.USER)
                .build();
        return userRepository.save(user);
    }

    /**
     * Loads a user by username as required by the {@link UserDetailsService}
     * contract used by Spring Security for authentication.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    /**
     * Returns profile information for the given user id.
     */
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}

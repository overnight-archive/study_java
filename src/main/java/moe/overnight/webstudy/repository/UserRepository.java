package moe.overnight.webstudy.repository;

import moe.overnight.webstudy.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Spring Data repository providing CRUD operations for {@link User} entities.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Derived query method that finds a user by username. Spring Data JPA parses
     * the method name and generates the appropriate SQL automatically.
     */
    Optional<User> findByUsername(String username);
}

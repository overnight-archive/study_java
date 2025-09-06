package moe.overnight.webstudy.repository;

import moe.overnight.webstudy.domain.notification.Notification;
import moe.overnight.webstudy.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository providing data access for {@link Notification} entities.
 */
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    /**
     * Finds all notifications for a specific user.
     */
    List<Notification> findByUser(User user);
}

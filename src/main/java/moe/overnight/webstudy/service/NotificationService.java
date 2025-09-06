package moe.overnight.webstudy.service;

import lombok.RequiredArgsConstructor;
import moe.overnight.webstudy.domain.notification.Notification;
import moe.overnight.webstudy.domain.user.User;
import moe.overnight.webstudy.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service responsible for creating and retrieving notifications.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class NotificationService {
    private final NotificationRepository notificationRepository;

    /**
     * Creates a notification for a given user.
     */
    public Notification notify(User user, String message) {
        Notification notification = Notification.builder()
                .user(user)
                .message(message)
                .read(false)
                .createdAt(LocalDateTime.now())
                .build();
        return notificationRepository.save(notification);
    }

    /**
     * Lists all notifications for a user.
     */
    public List<Notification> list(User user) {
        return notificationRepository.findByUser(user);
    }

    /**
     * Marks the notification as read.
     */
    public void markRead(Long notificationId) {
        notificationRepository.findById(notificationId).ifPresent(n -> {
            n.setRead(true);
        });
    }
}

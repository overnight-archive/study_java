package moe.overnight.webstudy.controller;

import lombok.RequiredArgsConstructor;
import moe.overnight.webstudy.domain.notification.Notification;
import moe.overnight.webstudy.domain.user.User;
import moe.overnight.webstudy.service.NotificationService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Notification retrieval and update endpoints.
 */
@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping
    public List<Notification> list(@AuthenticationPrincipal User user) {
        return notificationService.list(user);
    }

    @PostMapping("/{id}/read")
    public void markRead(@PathVariable Long id) {
        notificationService.markRead(id);
    }
}

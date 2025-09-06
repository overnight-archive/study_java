package moe.overnight.webstudy.controller;

import lombok.RequiredArgsConstructor;
import moe.overnight.webstudy.domain.user.User;
import moe.overnight.webstudy.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Authentication related endpoints such as registration and profile lookup.
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    /**
     * Registers a new user using form parameters. In a production system a DTO
     * and validation would be used instead.
     */
    @PostMapping("/register")
    public User register(@RequestParam String username,
                         @RequestParam String password,
                         @RequestParam String email) {
        return userService.register(username, password, email);
    }

    /**
     * Returns profile information of the authenticated user.
     */
    @GetMapping("/me")
    public Optional<User> me(@AuthenticationPrincipal User user) {
        return userService.findById(user.getId());
    }
}

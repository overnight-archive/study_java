package moe.overnight.webstudy.config;

import lombok.RequiredArgsConstructor;
import moe.overnight.webstudy.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Basic security configuration enabling form login and Google OAuth2 login.
 * The configuration demonstrates how {@link HttpSecurity} is used to build the
 * filter chain that secures HTTP endpoints.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // HttpSecurity uses the builder pattern to configure many security aspects.
        http
            .csrf(csrf -> csrf.disable()) // Disabled for simplicity; not recommended for production.
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/auth/**", "/oauth2/**").permitAll()
                    .anyRequest().authenticated())
            .formLogin(login -> login.permitAll())
            .oauth2Login(oauth2 -> oauth2) // Google OAuth2 uses settings from application.properties
            .userDetailsService(userService);
        return http.build();
    }

    /**
     * Password encoder bean used by Spring Security to hash passwords. BCrypt is
     * the de-facto standard for password hashing in Spring applications.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

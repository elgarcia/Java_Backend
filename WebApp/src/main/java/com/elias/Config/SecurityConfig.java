package com.elias.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password("123")
                .roles("USER")
                .passwordEncoder(pw -> passwordEncoder.encode(pw))
                .build());
        manager.createUser(User.withUsername("admin")
                .password("abc")
                .roles("USER", "ADMIN")
                .passwordEncoder(pw -> passwordEncoder.encode(pw))
                .build());
        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/api/mediciones/form", "/api/mediciones/editar/**", "/api/mediciones/eliminar/**")
                        .hasRole("ADMIN")
                        .requestMatchers("/api/mediciones/**").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated())
                .formLogin(auth -> auth.permitAll())
                .logout(logout -> logout.permitAll())
                .build();
    }
}


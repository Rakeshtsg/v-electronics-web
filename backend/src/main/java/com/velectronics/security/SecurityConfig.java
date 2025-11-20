package com.velectronics.security;
import org.springframework.context.annotation.Bean; import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
public class SecurityConfig {
    @Autowired JwtFilter jwtFilter;
    @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
            .antMatchers("/api/auth/**", "/api/public/**", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html", "/h2-console/**").permitAll()
            .anyRequest().authenticated();
        http.headers().frameOptions().disable();
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}

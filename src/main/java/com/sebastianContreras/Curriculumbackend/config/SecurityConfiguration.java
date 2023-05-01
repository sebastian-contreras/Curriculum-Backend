package com.sebastianContreras.Curriculumbackend.config;

import jakarta.persistence.PostLoad;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(
                        "/api/v1/auth/**"
                )
                .permitAll()
                .requestMatchers(HttpMethod.GET).permitAll()
                //                .anyRequest()
                //                .authenticated()
                .requestMatchers(HttpMethod.DELETE,"/historias/**","/users/**","/skills/**","/proyects/**").authenticated()
                .requestMatchers(HttpMethod.POST,"/historias","/historias/**","/users/**","/skills","/skills/**","/proyects/**","/proyects").authenticated()
                .requestMatchers(HttpMethod.PUT,"/historias/**","/users/**","/skills/**","/proyects/**").authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        //  http.authorizeHttpRequests().requestMatchers(HttpMethod.GET).permitAll();
//        http.authorizeHttpRequests().requestMatchers(HttpMethod.DELETE).authenticated();
//        http.authorizeHttpRequests().requestMatchers(HttpMethod.POST).authenticated();
//        http.authorizeHttpRequests().requestMatchers(HttpMethod.PUT).authenticated();

        return http.build();
    }
}

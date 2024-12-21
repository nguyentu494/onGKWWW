/*
 * @ (#) SecurityConfig.java   1.0     21/12/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package com.example.onthiwww2.backend.configs;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 21/12/2024
 * @version: 1.0
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    public void globalConfig(AuthenticationManagerBuilder builder, PasswordEncoder encoder) throws Exception {
        builder.inMemoryAuthentication()
                .withUser(User.withUsername("user").password(encoder.encode("123456")).roles("USER"))
                .withUser(User.withUsername("admin").password(encoder.encode("123456")).roles("ADMIN"));
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests( req -> {
                    req.requestMatchers("/api/**").hasRole("ADMIN")
                            .requestMatchers("/home").permitAll()
                            .requestMatchers("/report1/**","/candidates", "/report1").hasRole("USER")
                            .requestMatchers("/report2").hasRole("ADMIN")
                            .requestMatchers("/cand_detail/**").permitAll()
                            .anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .formLogin(form -> form.defaultSuccessUrl("/home", true))
                .build();
    }
}

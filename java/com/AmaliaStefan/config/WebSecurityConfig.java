package com.AmaliaStefan.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .passwordEncoder(passwordEncoder())
            .usersByUsernameQuery("select username, password, enabled from users where username=?")
            .authoritiesByUsernameQuery("select username, role from users where username=?");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                	.requestMatchers("/images/*").permitAll()
                    .requestMatchers("/register/**").permitAll()
                    .requestMatchers("/bookEdit/**", "/book_register/**", "/deleteBook/**", "/save/*").hasRole("ADMIN")
                    .anyRequest().authenticated()
            )
            .formLogin(formLogin ->
                formLogin
               	.loginPage("/login")
                	.defaultSuccessUrl("/", true)
                    .permitAll()
            )
            .exceptionHandling(exceptionHandling ->
                exceptionHandling.accessDeniedPage("/accessDenied")
            )
            .logout(logout ->
                logout
                    .permitAll()
            );

        return http.build();
    }
}

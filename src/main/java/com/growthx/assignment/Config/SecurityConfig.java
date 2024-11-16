package com.growthx.assignment.Config;

import com.growthx.assignment.Exception.GlobalExceptionHandler;
import com.growthx.assignment.Service.AdminAuthenticationService;
import com.growthx.assignment.Service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Autowired
    private AdminAuthenticationService adminAuthenticationService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userAuthenticationService).passwordEncoder(passwordEncoder());
        auth.userDetailsService(adminAuthenticationService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**").permitAll() // swagger uri's have been excluded from the security
                .antMatchers("/user/v1/register").permitAll()  // open for registration users
                .antMatchers("/admin/v1/register").permitAll() // open for registration admins
                .antMatchers("/user/v1/**").hasRole("USER")
                .antMatchers("/admin/v1/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new GlobalExceptionHandler()) // UnAuthorized Handling
                .accessDeniedHandler(new GlobalExceptionHandler());   // Forbidden Handling
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

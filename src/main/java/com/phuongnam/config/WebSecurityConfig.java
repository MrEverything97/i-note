package com.phuongnam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").authenticated()
                .antMatchers("/**/create").hasAnyRole("MEMBER","ADMIN")
                .antMatchers("/**/delete").hasRole("ADMIN")
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");
    }
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user1 =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("1234")
                        .roles("USER")
                        .build();
        UserDetails user2 =
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("1234")
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(user1,user2);

    }
}


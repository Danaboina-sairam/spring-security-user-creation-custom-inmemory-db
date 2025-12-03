package com.spring.security.user.creation.custom.inmemory.db;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    public UserDetailsService userDetailsService(){
        UserDetails user1= User.withUsername("my_username_1")
                .password("{noop}my_password_1")
                .roles("ADMIN")
                .build();

        UserDetails user2= User.withUsername("my_username_2")
                .password("{noop}1234")
                .roles("USER")
                .build();

        UserDetails user3=User.withUsername("my_username_3")
                .password("{bcrypt}"+new BCryptPasswordEncoder().encode("my_password_3"))
                .roles("ADMIN")
                .build();

        UserDetails user4=User.withUsername("my_username_4")
                .password(new BCryptPasswordEncoder().encode("my_password_4"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1,user2,user3,user4);
    }
}

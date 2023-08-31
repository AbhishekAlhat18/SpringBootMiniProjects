package com.abhishek.restcrudapi.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


//Define a configuration class
//define a bean of InMemoryUserDetailsManager with no arguments
//Create an instance of UserDetails which consist of static method builder()
//builder return an object and call on that object call methods to set password, role and username

@Configuration
public class DemoSecurityConfig {

//    A Spring Bean is an object managed by the Spring framework.

/*  //Use when using predefined Spring security schema -users and authorities
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return  new JdbcUserDetailsManager(dataSource);
    }
*/
    @Bean

    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define query to retrieve a user by username
        //define a query to retrieve roles/authorities by username

        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members where user_id=?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles where user_id=?");

        return  jdbcUserDetailsManager;



    }
    //Define a method of type SecurityFilterChain which accepts parameter of type HttpSecurity
    //call method authorizeHttpRequests on object of HttpSecurity passed as an parameter
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests(c->c
                        .requestMatchers(HttpMethod.GET ,"/api/employess").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET ,"/api/employees/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST ,"/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT ,"/api/employees/**").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE ,"/api/employees/**").hasRole("ADMIN")
        );
        //use http basic auth
        http.httpBasic(Customizer.withDefaults());

        //disable Cross-Site Request Forgery(csrf)
        //in general not required for stateless rest API that use POST,PUT,DELETE and PATCH

         http.csrf(c->c.disable());

         return http.build();

    }
}

/*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("Employee")
                .build();

        UserDetails marry = User.builder()
                .username("marry")
                .password("{noop}test123")
                .roles("Employee","Manager")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("Employee","Manager","Admin")
                .build();

        return new InMemoryUserDetailsManager(john,marry,susan);




    }

    */
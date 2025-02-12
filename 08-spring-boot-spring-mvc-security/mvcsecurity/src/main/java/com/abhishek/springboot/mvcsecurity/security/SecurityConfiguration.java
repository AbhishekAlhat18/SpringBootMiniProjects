package com.abhishek.springboot.mvcsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {



    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

         JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();

         jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");

    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure ->
                        configure.requestMatchers("/").hasRole("EMPLOYEE")
                                 .requestMatchers("/leaders/**").hasRole("MANAGER")
                                 .requestMatchers("/systems/**").hasRole("ADMIN").anyRequest().authenticated()

                ).formLogin(form -> form.loginPage("/showLoginFormPage").
                        loginProcessingUrl("/authenticateTheUser").
                        permitAll()
                )
                .logout(logout ->
                        logout.permitAll());

        http.exceptionHandling(configure->configure.accessDeniedPage("/access-denied"));

        return http.build();
    }
}
 /*
       @Bean
    public InMemoryUserDetailsManager userDetailsManager() {


        UserDetails john = User.builder()
                .username("john")
                .password("{noop}john@123")
                .roles("EMPLOYEE")
                .build();

        UserDetails marry = User.builder()
                .username("marry")
                .password("{noop}marry@123")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails sussan = User.builder()
                .username("sussan")
                .password("{noop}sussan@123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, marry, sussan);
    }




*/




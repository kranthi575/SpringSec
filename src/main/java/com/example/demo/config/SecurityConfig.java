package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//this the custom security config class
//this will take care of url validation
//password encoding
//user management
//password breaching
@Configuration
public class SecurityConfig {


    //this method will take care of the url validation
    //this will verify whether url need to authenticate or permitting
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {


        http.authorizeHttpRequests((requests)->requests.requestMatchers("/welcome").authenticated()
                .requestMatchers("/home").permitAll());
       http.formLogin(flc->flc.loginPage("/login").permitAll());
       http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

    //we can implement user management through different ways
    //1.Storing user data in application properties file
    //2.Application InMemory
    //3.through jdbc Connection to the db (database schema need to be in spring security format)
    //**4.JDBC with customized database schema

    //we can select kind of passencoder we need to hash the password entered by the user


    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    //this method helps us to check to is given password is compromised?
    //    @Bean
    //    public CompromisedPasswordChecker compromisedPasswordChecker(){
    //        return new HaveIBeenPwnedRestApiPasswordChecker();
    //    }
}

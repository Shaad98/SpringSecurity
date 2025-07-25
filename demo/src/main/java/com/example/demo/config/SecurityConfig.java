package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
// import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

// Class that manage beans
@Configuration
// All default config will neglected . Our provided config only considered
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                    .csrf(customizer->customizer.disable())
                    .authorizeHttpRequests(request->request.anyRequest().authenticated())
        // with above 2 lines by postman 403 come and on browser access denied bcz even if you send with postman you are not accepting means method is not to accept by both
                    .formLogin(Customizer.withDefaults())
        // only above line give form if you access ,  by postman you get html page for rest api access do below thing
                    .httpBasic(Customizer.withDefaults())
        // logout url still work 
        // diff ways to handle csrf is you make http stateless , but problem is you cannot login from browser every time form comes bcz of new request , new session means login once more with postman you can easily handle

        // so comment to form login http basic come to browser like postman each req give credential and access
                    .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .build();
    }
}

//package com.global.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
////get users from memeory
//@Configuration
//public class SecurityConfig  {
//
//
////    @Bean
////    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder authBuilder, PasswordEncoder passwordEncoder) throws Exception {
////        authBuilder
////                .inMemoryAuthentication()
////                .withUser("admin").password(passwordEncoder.encode("123")).roles("ADMIN")
////                .and()
////                .withUser("user").password(passwordEncoder.encode("123")).roles("USER");
////
////        return authBuilder.build();
////    }
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////                .sessionManagement(session ->
////                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
////                .authorizeHttpRequests(auth ->
////                        auth.requestMatchers("/user").hasRole("USER")
////                                .requestMatchers("/admin").hasRole("ADMIN")
////                                .anyRequest().authenticated())
////                .csrf(csrf -> csrf.disable());
////
////        return http.build();
////    }
//
//
//    //we get users from inmemory
//     @Bean
//    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder){
//        UserDetails user1= User.builder()
//                 .username("user1")
//                 .password(passwordEncoder.encode("123"))
//                 .roles("USER")
//                 .build();
//
//         UserDetails user2= User.builder()
//                 .username("user2")
//                 .password(passwordEncoder.encode("123"))
//                 .roles("ADMIN")
//                 .build();
//         return new  InMemoryUserDetailsManager(user1,user2);
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(auth ->
//                        auth.requestMatchers("/api/v1/**").permitAll()
//                                .anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults())
//                .csrf( csrf -> csrf.disable());
//
//        return http.build();
//    }
//
//
//}
//
//

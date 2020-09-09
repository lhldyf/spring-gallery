// package com.lhldyf.gallery.springboot.webflux;
//
// import org.springframework.security.authentication.ReactiveAuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
// import reactor.core.publisher.Mono;
//
// /**
//  * @author lhldyf
//  * @date 2020-04-02 10:10
//  */
// public class CustomReactiveAuthenticationManager implements ReactiveAuthenticationManager {
//
//     private final ReactiveUserDetailsService userDetailsService;
//
//     @Override
//     public Mono<Authentication> authenticate(Authentication authentication) {
//         String username = authentication.getName();
//         String presentedPassword = (String) authentication.getCredentials();
//         System.out.println("CustomReactiveAuthenticationManager  " + username + "/" + presentedPassword);
//         return Mono.just(new UsernamePasswordAuthenticationToken(username, presentedPassword, null));
//     }
//
//     public CustomReactiveAuthenticationManager(ReactiveUserDetailsService userDetailsService) {
//         this.userDetailsService = userDetailsService;
//     }
// }

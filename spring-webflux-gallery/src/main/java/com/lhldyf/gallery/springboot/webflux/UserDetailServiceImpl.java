// package com.lhldyf.gallery.springboot.webflux;
//
// import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import reactor.core.publisher.Mono;
//
// /**
//  * @author lhldyf
//  * @date 2020-04-01 16:31
//  */
// public class UserDetailServiceImpl implements ReactiveUserDetailsService {
//     @Override
//     public Mono<UserDetails> findByUsername(String s) {
//         System.out.println("username:" + s);
//         UserDO userDO = new UserDO();
//         // userDO.setPassword("123456");
//         userDO.setPassword(new BCryptPasswordEncoder().encode("123456"));
//         userDO.setUsername("admin");
//         System.out.println("password:" + userDO.getPassword());
//         return Mono.just(userDO);
//     }
// }

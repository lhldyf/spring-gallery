// package com.lhldyf.gallery.springboot.webflux;
//
//
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.annotation.Order;
// import org.springframework.security.core.context.ReactiveSecurityContextHolder;
// import org.springframework.web.server.ServerWebExchange;
// import org.springframework.web.server.WebFilter;
// import org.springframework.web.server.WebFilterChain;
// import reactor.core.publisher.Mono;
//
// /**
//  * @author lhldyf
//  * @date 2019-08-25 15:17
//  */
// @Configuration
// @Order(-1)
// // @ConditionalOnProperty(value = "twmw.system.security.enabled", havingValue = "true")
// public class UserLoginFilter implements WebFilter {
//
//     @Override
//     public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
//         // ReactiveSecurityContextHolder.getContext().map(x -> {
//         //     System.out.println(x.getAuthentication());
//         // })
//         // return ReactiveSecurityContextHolder.getContext().map(x -> {
//         //     System.out.println(x.getAuthentication().getPrincipal());
//         // });
//         // ReactiveSecurityContextHolder.getContext().block().getAuthentication();
//         System.out.println("filter");
//         return ReactiveSecurityContextHolder.getContext().map(x -> {
//             System.out.println("filter1");
//             System.out.println(x.getAuthentication());
//             UserDO userDO = new UserDO();
//             userDO.setUsername(x.getAuthentication().getPrincipal().toString());
//             SecurityContext.put(userDO);
//             return Mono.empty();
//         }).then(webFilterChain.filter(serverWebExchange));
//     }
//
// }

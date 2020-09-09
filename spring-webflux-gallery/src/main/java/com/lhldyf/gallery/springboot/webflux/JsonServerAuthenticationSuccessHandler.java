// package com.lhldyf.gallery.springboot.webflux;
//
// import org.springframework.core.io.buffer.DataBuffer;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.server.reactive.ServerHttpResponse;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.web.server.WebFilterExchange;
// import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
// import reactor.core.publisher.Mono;
//
// /**
//  * @author lhldyf
//  * @date 2020-03-31 22:28
//  */
// public class JsonServerAuthenticationSuccessHandler implements ServerAuthenticationSuccessHandler {
//     @Override
//     public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {
//         ServerHttpResponse response = webFilterExchange.getExchange().getResponse();
//
//         response.setStatusCode(HttpStatus.OK);
//         String body = "success1";
//         DataBuffer buffer = response.bufferFactory().wrap(body.getBytes());
//         return response.writeWith(Mono.just(buffer));
//     }
// }

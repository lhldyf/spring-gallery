// package com.lhldyf.gallery.springboot.webflux;
//
// import org.springframework.context.annotation.Bean;
// import org.springframework.core.io.buffer.DataBuffer;
// import org.springframework.core.io.buffer.DataBufferUtils;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.authentication.DelegatingReactiveAuthenticationManager;
// import org.springframework.security.authentication.ReactiveAuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
// import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
// import org.springframework.security.config.web.server.ServerHttpSecurity;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.server.SecurityWebFilterChain;
// import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;
// import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
// import org.springframework.security.web.server.context.ServerSecurityContextRepository;
// import org.springframework.security.web.server.context.WebSessionServerSecurityContextRepository;
// import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
//
// import java.nio.charset.Charset;
// import java.util.LinkedList;
//
// /**
//  * @author lhldyf
//  * @date 2020-03-31 20:56
//  */
// @EnableWebFluxSecurity
// public class HelloWebfluxSecurityConfig {
//
//     private static final String[] AUTH_WHITELIST = new String[] {"/login", "/actuator/**"};
//
//     @Bean
//     ReactiveAuthenticationManager reactiveAuthenticationManager(ReactiveUserDetailsService userDetailsService) {
//         LinkedList<ReactiveAuthenticationManager> managers = new LinkedList<>();
//         // 其他登陆方式 (比如手机号验证码登陆) 可在此设置  不得抛出异常或者 Mono.error
//         managers.add(new CustomReactiveAuthenticationManager(userDetailsService));
//         // 必须放最后不然会优先使用用户名密码校验但是用户名密码不对时此 AuthenticationManager 会调用 Mono.error 造成后面的 AuthenticationManager 不生效
//         // managers.add(new UserDetailsRepositoryReactiveAuthenticationManager(detailsService));
//         return new DelegatingReactiveAuthenticationManager(managers);
//     }
//
//     @Bean
//     public UserDetailServiceImpl userDetailsService() {
//         return new UserDetailServiceImpl();
//     }
//
//     /**
//      * 将登陆后的用户及权限信息存入session中
//      * @return
//      */
//     @Bean
//     ServerSecurityContextRepository serverSecurityContextRepository() {
//         return new WebSessionServerSecurityContextRepository();
//     }
//
//     /**
//      * 密码加密工具
//      * @return
//      */
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
//
//     @Bean
//     CustomAuthenticationWebFilter customAuthenticationWebFilter(
//             ReactiveAuthenticationManager reactiveAuthenticationManager) {
//         CustomAuthenticationWebFilter authenticationFilter =
//                 new CustomAuthenticationWebFilter(reactiveAuthenticationManager);
//         authenticationFilter.setRequiresAuthenticationMatcher(
//                 ServerWebExchangeMatchers.pathMatchers(HttpMethod.POST, new String[] {"/user/login"}));
//         authenticationFilter.setAuthenticationFailureHandler(createAuthenticationFailureHandler());
//         authenticationFilter.setServerAuthenticationConverter(
//                 exchange -> exchange.getRequest().getBody().next().map(this::createAuthentication));
//         authenticationFilter.setAuthenticationSuccessHandler(createAuthenticationSuccessHandler());
//         authenticationFilter.setSecurityContextRepository(new WebSessionServerSecurityContextRepository());
//         return authenticationFilter;
//     }
//
//
//     private Authentication createAuthentication(DataBuffer buffer) {
//         Charset charset = Charset.forName("UTF-8");
//         String result = charset.decode(buffer.asByteBuffer()).toString();
//         DataBufferUtils.release(buffer);
//         System.out.println(result);
//         // String username = (String)data.getFirst(this.usernameParameter);
//         // String password = (String)data.getFirst(this.passwordParameter);
//         return new UsernamePasswordAuthenticationToken("test", "test");
//     }
//
//
//     @Bean
//     SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) {
//         return http.addFilterAt(customAuthenticationWebFilter(reactiveAuthenticationManager(userDetailsService())),
//                                 SecurityWebFiltersOrder.AUTHENTICATION).csrf().disable().httpBasic().disable()
//                    .authorizeExchange().pathMatchers(AUTH_WHITELIST).permitAll().anyExchange().authenticated().and()
//                    .build();
//     }
//
//     /**
//      * 登陆成功后执行的处理器
//      * @return
//      */
//     private ServerAuthenticationSuccessHandler createAuthenticationSuccessHandler() {
//         return new JsonServerAuthenticationSuccessHandler();
//     }
//
//     /**
//      * 登陆失败后执行的处理器
//      * @return
//      */
//     private ServerAuthenticationFailureHandler createAuthenticationFailureHandler() {
//         return new JsonServerAuthenticationFailureHandler();
//     }
//
// }

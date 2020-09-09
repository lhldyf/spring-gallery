// package com.lhldyf.gallery.springboot.webflux;
//
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
//
// import java.util.Collection;
//
// /**
//  * @author lhldyf
//  * @date 2020-04-01 16:31
//  */
// public class UserDO implements UserDetails {
//     private String username;
//
//     private String password;
//
//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         return null;
//     }
//
//     @Override
//     public boolean isAccountNonExpired() {
//         return false;
//     }
//
//     @Override
//     public boolean isAccountNonLocked() {
//         return false;
//     }
//
//     @Override
//     public boolean isCredentialsNonExpired() {
//         return false;
//     }
//
//     @Override
//     public boolean isEnabled() {
//         return true;
//     }
//
//     @Override
//     public String getUsername() {
//         return username;
//     }
//
//     public void setUsername(String username) {
//         this.username = username;
//     }
//
//     @Override
//     public String getPassword() {
//         return password;
//     }
//
//     public void setPassword(String password) {
//         this.password = password;
//     }
// }

package com.example.eatwhat.service;

import com.example.eatwhat.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDetail implements UserDetails {
  
  private User user;
  
  public UserDetail(User user) {
    this.user = user;
  }
  
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
      Set<GrantedAuthority> roles = new HashSet<>();
      for(String role : user.getAuth().split(",")) {
          roles.add(new SimpleGrantedAuthority(role));
      }
      return roles;
  }
  
  @Override
  public String getPassword() {
    return this.user.getUserPassword();
  }
  
  @Override
  public String getUsername() {
    return this.user.getUsername();
  }
  
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }
  
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }
  
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }
  
  @Override
  public boolean isEnabled() {
    return true;
  }
}

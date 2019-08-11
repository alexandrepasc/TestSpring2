package com.TestSpring2.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {
  
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;
  
  @Column(name = "username")
  private String username;
  
  @Column(name = "password")
  private String password;
  
  private Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public Collection<GrantedAuthority> getGrantedAuthoritiesList() {
    return grantedAuthoritiesList;
  }
  
  public void setGrantedAuthoritiesList(
      Collection<GrantedAuthority> grantedAuthoritiesList) {
    this.grantedAuthoritiesList = grantedAuthoritiesList;
  }
}

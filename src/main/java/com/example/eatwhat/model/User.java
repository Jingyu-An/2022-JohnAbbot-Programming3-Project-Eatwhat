package com.example.eatwhat.model;

import javax.persistence.*;

@Entity
@Table(name = "eatwhat_user")
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long userId;
  private String username;
  private String userEmail;
  private String userPassword;
  private long userPoint;
  
  public long getUserId() {
    return userId;
  }
  
  public void setUserId(long userId) {
    this.userId = userId;
  }
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getUserEmail() {
    return userEmail;
  }
  
  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }
  
  public String getUserPassword() {
    return userPassword;
  }
  
  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }
  
  public long getUserPoint() {
    return userPoint;
  }
  
  public void setUserPoint(long userPoint) {
    this.userPoint = userPoint;
  }
}

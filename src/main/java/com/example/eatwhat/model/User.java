package com.example.eatwhat.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "eatwhat_user")
@Data
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long userId;
  private String username;
  private String userEmail;
  private String userPassword;
  private long userPoint;

}

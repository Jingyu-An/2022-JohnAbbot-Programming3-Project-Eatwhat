package com.example.eatwhat.model;

import jdk.jfr.Name;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "eatwhat_user")
@Data
@NoArgsConstructor
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Name("user_id")
  private long id;

  private String username;

  private String userEmail;

  private String userPassword;

  private int userPoint;

}

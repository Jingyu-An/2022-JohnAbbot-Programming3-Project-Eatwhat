package com.example.eatwhat.role;

import javax.persistence.*;

@Entity
@Table(name = "eatwhat_role")
public class Role {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long roleid;
  private String roleName;
  
  public long getRoleid() {
    return roleid;
  }
  
  public void setRoleid(long roleid) {
    this.roleid = roleid;
  }
  
  public String getRoleName() {
    return roleName;
  }
  
  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }
}

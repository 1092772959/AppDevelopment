package com.myapp.demo.entity;

import javax.persistence.*;


@Entity
@Table(name="administer")
public class Administer {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name="id")
  private Integer id;

  @Column(name="acc_num")
  private String accNum;

  @Column(name="pswd")
  private String pswd;

  @Column(name="email")
  private String email;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getAccNum() {
    return accNum;
  }

  public void setAccNum(String accNum) {
    this.accNum = accNum;
  }


  public String getPswd() {
    return pswd;
  }

  public void setPswd(String pswd) {
    this.pswd = pswd;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Administer{" +
            "id=" + id +
            ", accNum='" + accNum + '\'' +
            ", pswd='" + pswd + '\'' +
            ", email='" + email + '\'' +
            '}';
  }
}

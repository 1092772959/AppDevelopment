package com.myapp.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="inquiry")
public class Inquiry {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name="id")
  private Integer id;

  @Column(name="userid")
  private Integer userid;

  @Column(name="release_time")
  private Date releaseTime;

  @Column(name="content")
  private String content;

  //询问时可能需要获取用户信息
  @Transient
  private User user;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public Date getReleaseTime() {
    return releaseTime;
  }

  public void setReleaseTime(Date releaseTime) {
    this.releaseTime = releaseTime;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "Inquiry{" +
            "id=" + id +
            ", userid=" + userid +
            ", releaseTime=" + releaseTime +
            ", content='" + content + '\'' +
            '}';
  }
}

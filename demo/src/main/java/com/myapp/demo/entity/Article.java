package com.myapp.demo.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="article")
public class Article {

  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Id
  @Column(name="id")
  private Integer id;

  @Column(name="title")
  private String title;

  @Column(name="admin_id")
  private Integer adminId;

  @Temporal(TemporalType.DATE)
  @Column(name="release_time")
  private Date releaseTime;

  @Column(name="content")
  private String content;

  @Column(name="src_url")
  private String srcUrl;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public Integer getAdminId() {
    return adminId;
  }

  public void setAdminId(Integer adminId) {
    this.adminId = adminId;
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

  public String getSrcUrl() {
    return srcUrl;
  }

  public void setSrcUrl(String srcUrl) {
    this.srcUrl = srcUrl;
  }

  @Override
  public String toString() {
    return "Article{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", adminId=" + adminId +
            ", releaseTime=" + releaseTime +
            ", content='" + content + '\'' +
            '}';
  }
}

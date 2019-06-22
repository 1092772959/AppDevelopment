package com.myapp.demo.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="favorite")
public class Favorite {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name="id")
  private Integer id;
  
  @Column(name="userid")
  private Integer userid;
  
  @Column(name="article_id")
  private Integer articleId;

  @Column(name="mark_time")
  private Date markTime;

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


  public Integer getArticleId() {
    return articleId;
  }

  public void setArticleId(Integer articleId) {
    this.articleId = articleId;
  }

  public Date getMarkTime() {
    return markTime;
  }

  public void setMarkTime(Date markTime) {
    this.markTime = markTime;
  }

  @Override
  public String toString() {
    return "Favorite{" +
            "id=" + id +
            ", userid=" + userid +
            ", articleId=" + articleId +
            ", markTime=" + markTime +
            '}';
  }
}

package com.myapp.demo.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="reply")
public class Reply {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name="id")
  private Integer id;

  @Column(name="iquiry_id")
  private Integer inquiryId;

  @Column(name="admin_id")
  private Integer adminId;

  @Temporal(TemporalType.DATE)
  @Column(name="release_time")
  private Date releaseTime;

  @Column(name="content")
  private String content;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getInquiryId() {
    return inquiryId;
  }

  public void setInquiryId(Integer inquiryId) {
    this.inquiryId = inquiryId;
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

  @Override
  public String toString() {
    return "Reply{" +
            "id=" + id +
            ", inquiryId=" + inquiryId +
            ", adminId=" + adminId +
            ", releaseTime=" + releaseTime +
            ", content='" + content + '\'' +
            '}';
  }
}
